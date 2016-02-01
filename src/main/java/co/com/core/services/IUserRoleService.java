package co.com.core.services;

import java.util.List;

import co.com.core.dto.PageDTO;
import co.com.core.dto.UserRoleDTO;


public interface IUserRoleService {

	public List<UserRoleDTO> getAll(); 
	
	public void createUserRole(UserRoleDTO userRoleDto);
	
	public void delete(UserRoleDTO userRoleDto);
	
	public void update(UserRoleDTO userRoleDto);
}
