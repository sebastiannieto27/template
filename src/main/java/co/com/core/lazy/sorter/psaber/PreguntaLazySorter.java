package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.PreguntaDTO;

public class PreguntaLazySorter  implements Comparator<PreguntaDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public PreguntaLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(PreguntaDTO Pregunta1, PreguntaDTO Pregunta2) {
        try {
            Object value1 = PreguntaDTO.class.getField(this.sortField).get(Pregunta1);
            Object value2 = PreguntaDTO.class.getField(this.sortField).get(Pregunta2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
