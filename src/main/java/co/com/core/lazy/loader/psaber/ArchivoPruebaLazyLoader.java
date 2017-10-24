package co.com.core.lazy.loader.psaber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.lazy.sorter.psaber.ArchivoPruebaLazySorter;
import co.com.core.services.psaber.IArchivoPruebaService;

public class ArchivoPruebaLazyLoader extends LazyDataModel<ArchivoPruebaDTO> {
	private List<ArchivoPruebaDTO> datasource;
    
    public ArchivoPruebaLazyLoader(IArchivoPruebaService serviceImpl) {
        this.datasource = serviceImpl.getAll();
    }
    
    @Override
    public ArchivoPruebaDTO getRowData(String rowKey) {
        for(ArchivoPruebaDTO dto : datasource) {
        	try {
            	Integer rowKeyInt = Integer.parseInt(rowKey);
        		if(dto.getArchivoPruebaId() == rowKeyInt)
                return dto;
        	} catch(Exception ex) {
        		return null;
        	}
        }
        return null;
    }
 
    @Override
    public Object getRowKey(ArchivoPruebaDTO dto) {
        return dto.getArchivoPruebaId();
    }
    
	@Override
    public List<ArchivoPruebaDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<ArchivoPruebaDTO> data = new ArrayList<ArchivoPruebaDTO>();
		  //filter
        for(ArchivoPruebaDTO dto : datasource) {
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
            Collections.sort(data, new ArchivoPruebaLazySorter(sortField, sortOrder));
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

	public List<ArchivoPruebaDTO> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<ArchivoPruebaDTO> datasource) {
		this.datasource = datasource;
	}
	
	
}
