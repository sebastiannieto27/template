package co.com.core.lazy.sorter;

import java.util.Comparator;

import org.apache.log4j.Logger;
import org.primefaces.model.SortOrder;

import co.com.core.controller.EventController;
import co.com.core.dto.EventDTO;

public class EventLazySorter  implements Comparator<EventDTO> {
	
	private static final Logger logger = Logger.getLogger(EventLazySorter.class);
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public EventLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(EventDTO event1, EventDTO event2) {
        try {
        	logger.info("event 1: "+event1.toString());
        	logger.info("event 2: "+event2.toString());
            Object value1 = EventDTO.class.getField(this.sortField).get(event1);
            Object value2 = EventDTO.class.getField(this.sortField).get(event2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch(Exception ex) {
        	logger.error("Throwed Exception [EventLazySorter.compare]: " + ex.getMessage() + " cause: " + ex.getCause());
        	return 0;
        }
    }
}
