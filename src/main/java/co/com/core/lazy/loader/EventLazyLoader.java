package co.com.core.lazy.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import co.com.core.dto.EventDTO;
import co.com.core.lazy.sorter.EventLazySorter;

public class EventLazyLoader extends LazyDataModel<EventDTO> {
	private List<EventDTO> datasource;
    
    /*public EventLazyLoader(EventBO eventBOImpl) {
        this.datasource = eventBOImpl.getAll();//TODO
    }*/
    
    @Override
    public EventDTO getRowData(String rowKey) {
        for(EventDTO event : datasource) {
            if(event.getEventId().equals(rowKey))
                return event;
        }
        return null;
    }
 
    @Override
    public Object getRowKey(EventDTO event) {
        return event.getEventId();
    }
    
	@Override
    public List<EventDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<EventDTO> data = new ArrayList<EventDTO>();
		  //filter
        for(EventDTO event : datasource) {
        	boolean match = true;
        	if (filters != null) {
        		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
        			try {
        				String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(event.getClass().getField(filterProperty).get(event));
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
                data.add(event);
            }
        }
        
        //sort
        if(sortField != null) {
            Collections.sort(data, new EventLazySorter(sortField, sortOrder));
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
