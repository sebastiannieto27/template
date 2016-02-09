package co.com.core.dao;

import java.util.List;

import co.com.core.domain.PagePermission;

public interface PagePermissionDAO {
	
	public List<PagePermission> getAll();
	
	public void create(PagePermission entity);
	
	public void delete(PagePermission entity);
	
	public void update(PagePermission entity);
	
	public List<PagePermission> getNotAssignedPermission(String ids);
}
