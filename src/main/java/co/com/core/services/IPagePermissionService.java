package co.com.core.services;

import java.util.List;

import co.com.core.dto.PagePermissionDTO;


public interface IPagePermissionService {

	public List<PagePermissionDTO> getAll(); 
	
	public void create(PagePermissionDTO dto);
	
	public void delete(PagePermissionDTO dto);
	
	public void update(PagePermissionDTO dto);
	
	public List<PagePermissionDTO> getNotAssignedPermission(String ids); 
}
