package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Menu;
import co.com.core.domain.Permission;
import co.com.core.domain.Role;

public interface PermissionDAO {
	
	public List<Permission> getAll();
	
	public void create(Permission entity);
	
	public void delete(Permission entity);
	
	public void update(Permission entity);
	
	public List<Permission> getNotAssignedPermission(String ids);

	public Permission getByCode(String code);
}
