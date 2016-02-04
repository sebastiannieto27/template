package co.com.core.dao;

import java.util.List;

import co.com.core.domain.RolePermission;

public interface RolePermissionDAO {
	
	public List<RolePermission> getAll();
	
	public void create(RolePermission entity);
	
	public void delete(RolePermission entity);
	
	public void update(RolePermission entity);
}