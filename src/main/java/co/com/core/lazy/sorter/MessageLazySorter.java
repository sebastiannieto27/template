package co.com.core.lazy.sorter;

import java.util.Comparator;

import org.apache.log4j.Logger;
import org.primefaces.model.SortOrder;

import co.com.core.dto.MessageDTO;

public class MessageLazySorter  implements Comparator<MessageDTO> {
	
	private static final Logger logger = Logger.getLogger(MessageLazySorter.class);
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public MessageLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(MessageDTO msg1, MessageDTO msg2) {
        try {
            Object value1 = MessageDTO.class.getField(this.sortField).get(msg1);
            Object value2 = MessageDTO.class.getField(this.sortField).get(msg2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch(Exception ex) {
        	logger.error("Throwed Exception [MessageLazySorter.compare]: " + ex.getMessage() + " cause: " + ex.getCause());
        	return 0;
        }
    }
}
