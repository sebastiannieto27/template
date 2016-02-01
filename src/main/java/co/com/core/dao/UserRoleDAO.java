package co.com.core.dao;

import java.util.List;

import co.com.core.domain.UserRole;

public interface UserRoleDAO {
	
	public List<UserRole> getAll();
	
	public void createUserRole(UserRole userRole);
	
	public void delete(UserRole userRole);
	
	public void update(UserRole userRole);
}
