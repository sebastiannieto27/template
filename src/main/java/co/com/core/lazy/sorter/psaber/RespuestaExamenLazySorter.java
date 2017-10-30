package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.RespuestaExamenDTO;

public class RespuestaExamenLazySorter  implements Comparator<RespuestaExamenDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public RespuestaExamenLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(RespuestaExamenDTO RespuestaExamen1, RespuestaExamenDTO RespuestaExamen2) {
        try {
            Object value1 = RespuestaExamenDTO.class.getField(this.sortField).get(RespuestaExamen1);
            Object value2 = RespuestaExamenDTO.class.getField(this.sortField).get(RespuestaExamen2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
