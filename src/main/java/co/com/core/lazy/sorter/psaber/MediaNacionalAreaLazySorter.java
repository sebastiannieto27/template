package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.MediaNacionalAreaDTO;

public class MediaNacionalAreaLazySorter  implements Comparator<MediaNacionalAreaDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public MediaNacionalAreaLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(MediaNacionalAreaDTO MediaNacionalArea1, MediaNacionalAreaDTO MediaNacionalArea2) {
        try {
            Object value1 = MediaNacionalAreaDTO.class.getField(this.sortField).get(MediaNacionalArea1);
            Object value2 = MediaNacionalAreaDTO.class.getField(this.sortField).get(MediaNacionalArea2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
