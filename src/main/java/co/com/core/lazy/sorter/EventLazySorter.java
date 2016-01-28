package co.com.core.lazy.sorter;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.EventDTO;

public class EventLazySorter  implements Comparator<EventDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public EventLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(EventDTO event1, EventDTO event2) {
        try {
            Object value1 = EventDTO.class.getField(this.sortField).get(event1);
            Object value2 = EventDTO.class.getField(this.sortField).get(event2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
