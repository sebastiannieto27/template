package co.com.core.lazy.loader.psaber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import co.com.core.dto.UserDTO;
import co.com.core.dto.psaber.RespuestaExamenDTO;
import co.com.core.lazy.sorter.psaber.RespuestaExamenLazySorter;
import co.com.core.services.psaber.IRespuestaExamenService;

public class RespuestaExamenLazyLoader extends LazyDataModel<RespuestaExamenDTO> {
	private List<RespuestaExamenDTO> datasource;
    
    public RespuestaExamenLazyLoader(IRespuestaExamenService serviceImpl, UserDTO dto, Date searchDate) {
        this.datasource = serviceImpl.getByRespuestaExamenResultado(dto, searchDate);
    }
    
    @Override
    public RespuestaExamenDTO getRowData(String rowKey) {
        for(RespuestaExamenDTO dto : datasource) {
        	try {
            	Integer rowKeyInt = Integer.parseInt(rowKey);
        		if(dto.getRespuestaExamenId() == rowKeyInt)
                return dto;
        	} catch(Exception ex) {
        		return null;
        	}
        }
        return null;
    }
 
    @Override
    public Object getRowKey(RespuestaExamenDTO dto) {
        return dto.getRespuestaExamenId();
    }
    
	@Override
    public List<RespuestaExamenDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<RespuestaExamenDTO> data = new ArrayList<RespuestaExamenDTO>();
		  //filter
        for(RespuestaExamenDTO dto : datasource) {
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
            Collections.sort(data, new RespuestaExamenLazySorter(sortField, sortOrder));
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

	public List<RespuestaExamenDTO> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<RespuestaExamenDTO> datasource) {
		this.datasource = datasource;
	}
	
	
}
