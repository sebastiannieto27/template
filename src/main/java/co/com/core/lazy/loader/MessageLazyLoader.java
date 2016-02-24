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

import co.com.core.dto.MessageDTO;
import co.com.core.lazy.sorter.MessageLazySorter;
import co.com.core.services.IMessageService;

public class MessageLazyLoader extends LazyDataModel<MessageDTO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(MessageLazyLoader.class);
	
	private List<MessageDTO> datasource;
    
    public MessageLazyLoader(IMessageService messageServiceImpl) {
        this.datasource = messageServiceImpl.getAll();
    }
    
    @Override
    public MessageDTO getRowData(String rowKey) {
    	int intRowKey = Integer.parseInt(rowKey);
        for(MessageDTO msg : datasource) {
            if(msg.getMessageId() == intRowKey){
            	return msg;
            }
        }
        return null;
    }
 
    @Override
    public Object getRowKey(MessageDTO event) {
        return event.getMessageId();
    }
    
	@Override
    public List<MessageDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<MessageDTO> data = new ArrayList<MessageDTO>();
		  //filter
        for(MessageDTO msg : datasource) {
        	boolean match = true;
        	if (filters != null) {
        		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
        			try {
        				String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        Field privateField = msg.getClass().getDeclaredField(filterProperty);
                        privateField.setAccessible(true);
                        String fieldValue = String.valueOf(privateField.get(msg));
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
                data.add(msg);
            }
        }
        
        //sort
        if(sortField != null) {
            Collections.sort(data, new MessageLazySorter(sortField, sortOrder));
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
