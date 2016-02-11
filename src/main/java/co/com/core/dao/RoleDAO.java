package co.com.core.dao;

import java.util.List;

import co.com.core.domain.PagePermission;
import co.com.core.domain.Role;

public interface RoleDAO {
	
	public List<Role> getAll();
	
	public void createRole(Role role);
	
	public void delete(Role role);
	
	public void update(Role role);
	
	public List<Role> getNotAssignedRole(String ids);
}
