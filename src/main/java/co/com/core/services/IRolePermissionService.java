package co.com.core.services;

import java.util.List;

import co.com.core.dto.RolePermissionDTO;


public interface IRolePermissionService {

	public List<RolePermissionDTO> getAll(); 
	
	public void create(RolePermissionDTO dto);
	
	public void delete(RolePermissionDTO dto);
	
	public void update(RolePermissionDTO dto);
}
