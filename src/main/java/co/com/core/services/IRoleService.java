package co.com.core.services;

import java.util.List;

import co.com.core.dto.PagePermissionDTO;
import co.com.core.dto.RoleDTO;


public interface IRoleService {

	public List<RoleDTO> getAll(); 
	
	public void createRole(RoleDTO roleDto);
	
	public void delete(RoleDTO roleDto);
	
	public void update(RoleDTO roleDto);
	
	public List<RoleDTO> getNotAssignedRole(String ids);
}
