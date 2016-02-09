package co.com.core.services;

import java.util.List;

import co.com.core.dto.PageDTO;
import co.com.core.dto.PagePermissionDTO;
import co.com.core.dto.PermissionDTO;


public interface IPagePermissionService {

	public List<PagePermissionDTO> getAll(); 
	
	public void create(PagePermissionDTO dto);
	
	public void delete(PagePermissionDTO dto);
	
	public void update(PagePermissionDTO dto);
	
	public List<PagePermissionDTO> getNotAssignedPermission(String ids); 

	public PagePermissionDTO validatePermission(PageDTO pageDto, PermissionDTO permissionDto); 
}
