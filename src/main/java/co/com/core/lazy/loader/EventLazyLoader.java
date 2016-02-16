package co.com.core.lazy.loader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import co.com.core.dto.EventDTO;
import co.com.core.lazy.sorter.EventLazySorter;
import co.com.core.services.IEventService;

public class EventLazyLoader extends LazyDataModel<EventDTO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(EventLazyLoader.class);
	
	private List<EventDTO> datasource;
    
    public EventLazyLoader(IEventService eventServiceImpl) {
        this.datasource = eventServiceImpl.getAll();
    }
    
    @Override
    public EventDTO getRowData(String rowKey) {
    	int intRowKey = Integer.parseInt(rowKey);
        for(EventDTO event : datasource) {
            if(event.getEventId() == intRowKey){
            	return event;
            }
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
                        Field privateField = event.getClass().getDeclaredField(filterProperty);
                        privateField.setAccessible(true);
                        String fieldValue = String.valueOf(privateField.get(event));
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                        	match = true;
                        } else {
                            match = false;
                            break;
                        }
        			} catch(Exception ex) {
        				match = false;
        				logger.error("Exception : " + ex.getMessage());
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
