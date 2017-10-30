package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;

public class ArchivoPruebaProcesadoLazySorter  implements Comparator<ArchivoPruebaProcesadoDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public ArchivoPruebaProcesadoLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(ArchivoPruebaProcesadoDTO ArchivoPruebaProcesado1, ArchivoPruebaProcesadoDTO ArchivoPruebaProcesado2) {
        try {
            Object value1 = ArchivoPruebaProcesadoDTO.class.getField(this.sortField).get(ArchivoPruebaProcesado1);
            Object value2 = ArchivoPruebaProcesadoDTO.class.getField(this.sortField).get(ArchivoPruebaProcesado2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
