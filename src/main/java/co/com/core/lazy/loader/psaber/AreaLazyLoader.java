package co.com.core.lazy.loader.psaber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.AreaDTO;
import co.com.core.lazy.sorter.psaber.AreaLazySorter;
import co.com.core.services.psaber.IAreaService;

public class AreaLazyLoader extends LazyDataModel<AreaDTO> {
	private List<AreaDTO> datasource;
    
    public AreaLazyLoader(IAreaService serviceImpl) {
        this.datasource = serviceImpl.getAll();
    }
    
    @Override
    public AreaDTO getRowData(String rowKey) {
        for(AreaDTO dto : datasource) {
        	try {
            	Integer rowKeyInt = Integer.parseInt(rowKey);
        		if(dto.getAreaId() == rowKeyInt)
                return dto;
        	} catch(Exception ex) {
        		return null;
        	}
        }
        return null;
    }
 
    @Override
    public Object getRowKey(AreaDTO dto) {
        return dto.getAreaId();
    }
    
	@Override
    public List<AreaDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<AreaDTO> data = new ArrayList<AreaDTO>();
		  //filter
        for(AreaDTO dto : datasource) {
        	boolean match = true;
        	if (filters != null) {
        		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
        			try {
        				String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(dto.getClass().getField(filterProperty).get(dto));
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                        	match = true;
                        } else {
                            match = false;
                            break;
                        }
        			} catch(Exception ex) {
        				match = false;
        			}
        		}
        	}
        	if(match) {
                data.add(dto);
            }
        }
        
        //sort
        if(sortField != null) {
            Collections.sort(data, new AreaLazySorter(sortField, sortOrder));
        }
		
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
	}

	public List<AreaDTO> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<AreaDTO> datasource) {
		this.datasource = datasource;
	}
	
	
}
