package co.com.core.lazy.sorter;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import co.com.core.dto.UserDTO;

public class UserLazySorter  implements Comparator<UserDTO> {
	
	private String sortField;
    
    private SortOrder sortOrder;
     
    public UserLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    public int compare(UserDTO user1, UserDTO user2) {
        try {
            Object value1 = UserDTO.class.getField(this.sortField).get(user1);
            Object value2 = UserDTO.class.getField(this.sortField).get(user2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
