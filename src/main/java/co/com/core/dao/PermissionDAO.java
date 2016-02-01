package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Permission;

public interface PermissionDAO {
	
	public List<Permission> getAll();
	
	public void create(Permission entity);
	
	public void delete(Permission entity);
	
	public void update(Permission entity);
}
