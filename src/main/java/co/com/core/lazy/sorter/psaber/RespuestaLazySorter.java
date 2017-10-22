package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.RespuestaDTO;

public class RespuestaLazySorter  implements Comparator<RespuestaDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public RespuestaLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(RespuestaDTO Respuesta1, RespuestaDTO Respuesta2) {
        try {
            Object value1 = RespuestaDTO.class.getField(this.sortField).get(Respuesta1);
            Object value2 = RespuestaDTO.class.getField(this.sortField).get(Respuesta2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
