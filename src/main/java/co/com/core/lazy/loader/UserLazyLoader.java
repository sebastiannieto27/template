package co.com.core.lazy.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import co.com.core.dto.UserDTO;
import co.com.core.lazy.sorter.UserLazySorter;
import co.com.core.services.IUserService;

public class UserLazyLoader extends LazyDataModel<UserDTO> {
	private List<UserDTO> datasource;
    
    public UserLazyLoader(IUserService userServiceImpl) {
        this.datasource = userServiceImpl.getAll();
    }
    
    @Override
    public UserDTO getRowData(String rowKey) {
        for(UserDTO user : datasource) {
            if(user.getUserId().equals(rowKey))
                return user;
        }
        return null;
    }
 
    @Override
    public Object getRowKey(UserDTO User) {
        return User.getUserId();
    }
    
	@Override
    public List<UserDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<UserDTO> data = new ArrayList<UserDTO>();
		  //filter
        for(UserDTO user : datasource) {
        	boolean match = true;
        	if (filters != null) {
        		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
        			try {
        				String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(user.getClass().getField(filterProperty).get(user));
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                        	match = true;
                        } else {
                            match = false;
                            break;
                        }
        			} catch(Exception ex) {
        				match = false;
        			}
        		}
        	}
        	if(match) {
                data.add(user);
            }
        }
        
        //sort
        if(sortField != null) {
            Collections.sort(data, new UserLazySorter(sortField, sortOrder));
        }
		
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
	}
}
