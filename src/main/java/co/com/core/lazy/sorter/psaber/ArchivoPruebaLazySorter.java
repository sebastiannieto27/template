package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.ArchivoPruebaDTO;

public class ArchivoPruebaLazySorter  implements Comparator<ArchivoPruebaDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public ArchivoPruebaLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(ArchivoPruebaDTO ArchivoPrueba1, ArchivoPruebaDTO ArchivoPrueba2) {
        try {
            Object value1 = ArchivoPruebaDTO.class.getField(this.sortField).get(ArchivoPrueba1);
            Object value2 = ArchivoPruebaDTO.class.getField(this.sortField).get(ArchivoPrueba2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
