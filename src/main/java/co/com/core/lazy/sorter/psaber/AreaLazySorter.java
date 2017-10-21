package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.AreaDTO;

public class AreaLazySorter  implements Comparator<AreaDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public AreaLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(AreaDTO Area1, AreaDTO Area2) {
        try {
            Object value1 = AreaDTO.class.getField(this.sortField).get(Area1);
            Object value2 = AreaDTO.class.getField(this.sortField).get(Area2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
