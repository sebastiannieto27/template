package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.TemaDTO;

public class TemaLazySorter  implements Comparator<TemaDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public TemaLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(TemaDTO Tema1, TemaDTO Tema2) {
        try {
            Object value1 = TemaDTO.class.getField(this.sortField).get(Tema1);
            Object value2 = TemaDTO.class.getField(this.sortField).get(Tema2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
