package co.com.core.dao;

import java.util.List;

import co.com.core.domain.User;

public interface UserDAO {

	public User getUserById(Integer userID);
	
	public User login(String userEmail, String password);

	public List<User> getAll();
	
	public void createUser(User user);
	
	public void delete(User user);
	
	public void update(User user);
	
	public User getByMail(String userEmail);
	
	public List<User> getUserByName(String name);
	
	public User getUserByDocNum(String idNumber);
}
