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
import co.com.core.dto.psaber.ResultadoExamenUsuarioDTO;
import co.com.core.lazy.sorter.psaber.ResultadoExamenUsuarioLazySorter;
import co.com.core.services.psaber.IResultadoExamenUsuarioService;

public class ResultadoExamenUsuarioLazyLoader extends LazyDataModel<ResultadoExamenUsuarioDTO> {
	private List<ResultadoExamenUsuarioDTO> datasource;
    
    public ResultadoExamenUsuarioLazyLoader(IResultadoExamenUsuarioService serviceImpl) {
        this.datasource = serviceImpl.getAll();
    }
    
    @Override
    public ResultadoExamenUsuarioDTO getRowData(String rowKey) {
        for(ResultadoExamenUsuarioDTO dto : datasource) {
        	try {
            	Integer rowKeyInt = Integer.parseInt(rowKey);
        		if(dto.getResultadoExamenUsuarioId() == rowKeyInt)
                return dto;
        	} catch(Exception ex) {
        		return null;
        	}
        }
        return null;
    }
 
    @Override
    public Object getRowKey(ResultadoExamenUsuarioDTO dto) {
        return dto.getResultadoExamenUsuarioId();
    }
    
	@Override
    public List<ResultadoExamenUsuarioDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<ResultadoExamenUsuarioDTO> data = new ArrayList<ResultadoExamenUsuarioDTO>();
		  //filter
        for(ResultadoExamenUsuarioDTO dto : datasource) {
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
            Collections.sort(data, new ResultadoExamenUsuarioLazySorter(sortField, sortOrder));
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

	public List<ResultadoExamenUsuarioDTO> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<ResultadoExamenUsuarioDTO> datasource) {
		this.datasource = datasource;
	}
	
	
}
