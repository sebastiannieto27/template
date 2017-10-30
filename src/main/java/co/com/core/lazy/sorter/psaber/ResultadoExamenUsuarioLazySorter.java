package co.com.core.lazy.sorter.psaber;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.psaber.ResultadoExamenUsuarioDTO;

public class ResultadoExamenUsuarioLazySorter  implements Comparator<ResultadoExamenUsuarioDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public ResultadoExamenUsuarioLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(ResultadoExamenUsuarioDTO ResultadoExamenUsuario1, ResultadoExamenUsuarioDTO ResultadoExamenUsuario2) {
        try {
            Object value1 = ResultadoExamenUsuarioDTO.class.getField(this.sortField).get(ResultadoExamenUsuario1);
            Object value2 = ResultadoExamenUsuarioDTO.class.getField(this.sortField).get(ResultadoExamenUsuario2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
