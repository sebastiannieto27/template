package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.CompetenciaDTO;

public class CompetenciaLazySorter  implements Comparator<CompetenciaDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public CompetenciaLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(CompetenciaDTO Competencia1, CompetenciaDTO Competencia2) {
        try {
            Object value1 = CompetenciaDTO.class.getField(this.sortField).get(Competencia1);
            Object value2 = CompetenciaDTO.class.getField(this.sortField).get(Competencia2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
