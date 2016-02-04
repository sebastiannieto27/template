package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Role;
import co.com.core.domain.RoleMenu;

public interface RoleMenuDAO {
	
	public List<RoleMenu> getAll();
	
	public void createRoleMenu(RoleMenu entity);
	
	public void delete(RoleMenu entity);
	
	public void update(RoleMenu entity);
	
	public List<RoleMenu> findMenuByRole(Role role);
}
