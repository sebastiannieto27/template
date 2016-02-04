package co.com.core.services;

import java.util.List;

import co.com.core.dto.RoleDTO;
import co.com.core.dto.RoleMenuDTO;


public interface IRoleMenuService {

	public List<RoleMenuDTO> getAll(); 
	
	public void create(RoleMenuDTO dto);
	
	public void delete(RoleMenuDTO dto);
	
	public void update(RoleMenuDTO dto);
	
	public List<RoleMenuDTO> findMenuByRole(RoleDTO role);
}
