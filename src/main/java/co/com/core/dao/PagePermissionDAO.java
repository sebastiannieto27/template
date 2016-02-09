package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Page;
import co.com.core.domain.PagePermission;
import co.com.core.domain.Permission;

public interface PagePermissionDAO {
	
	public List<PagePermission> getAll();
	
	public void create(PagePermission entity);
	
	public void delete(PagePermission entity);
	
	public void update(PagePermission entity);
	
	public List<PagePermission> getNotAssignedPermission(String ids);
	
	public PagePermission getPermissionByPageCode(Page page, Permission permission);
}
