package co.com.core.services;

import java.util.List;

import co.com.core.dto.MenuDTO;
import co.com.core.dto.PermissionDTO;
import co.com.core.dto.RoleDTO;


public interface IPermissionService {

	public List<PermissionDTO> getAll(); 
	
	public void create(PermissionDTO dto);
	
	public void delete(PermissionDTO dto);
	
	public void update(PermissionDTO dto);
	
	public List<PermissionDTO> getNotAssignedPermission(String ids); 

	public PermissionDTO getByCode(String code); 
}
