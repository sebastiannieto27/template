package co.com.core.services;

import java.util.List;

import co.com.core.dto.PermissionDTO;


public interface IPermissionService {

	public List<PermissionDTO> getAll(); 
	
	public void create(PermissionDTO dto);
	
	public void delete(PermissionDTO dto);
	
	public void update(PermissionDTO dto);
}
