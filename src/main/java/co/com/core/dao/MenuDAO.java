package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Menu;
import co.com.core.domain.RoleMenu;
import co.com.core.domain.User;
import co.com.core.domain.UserRole;

public interface MenuDAO {

	public List<UserRole> getUserRoles(User user);
	
	public List<RoleMenu> getUserRoleMenu(List<UserRole> userRoles);
	
	public List<Menu> getUserMenuOptions(List<RoleMenu> roleMenuList);
	
	public List<Menu> getMenuGeneral();
	
	public List<Menu> getAll();
	
	public List<Menu> getNotAssignedMenu(String ids);
	
	public void createMenu(Menu menu);
	
	public void delete(Menu menu);
	
	public void update(Menu menu);
}
