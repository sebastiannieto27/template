package co.com.core.lazy.loader.psaber;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.PreguntaDTO;
import co.com.core.lazy.sorter.psaber.PreguntaLazySorter;
import co.com.core.services.psaber.IPreguntaService;

public class PreguntaLazyLoader extends LazyDataModel<PreguntaDTO> {
	private List<PreguntaDTO> datasource;
    
    public PreguntaLazyLoader(IPreguntaService serviceImpl) {
        this.datasource = serviceImpl.getAll();
    }
    
    @Override
    public PreguntaDTO getRowData(String rowKey) {
        for(PreguntaDTO dto : datasource) {
        	try {
            	Integer rowKeyInt = Integer.parseInt(rowKey);
        		if(dto.getPreguntaId() == rowKeyInt)
                return dto;
        	} catch(Exception ex) {
        		return null;
        	}
        }
        return null;
    }
 
    @Override
    public Object getRowKey(PreguntaDTO dto) {
        return dto.getPreguntaId();
    }
    
	@Override
    public List<PreguntaDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<PreguntaDTO> data = new ArrayList<PreguntaDTO>();
		  //filter
        for(PreguntaDTO dto : datasource) {
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
            Collections.sort(data, new PreguntaLazySorter(sortField, sortOrder));
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
}
