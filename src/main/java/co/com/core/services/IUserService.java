package co.com.core.services;

import java.util.List;

import co.com.core.dto.UserDTO;


public interface IUserService {

	public UserDTO getUserById(Integer userId);
	
	public UserDTO login(String userEmail, String password);

	public List<UserDTO> getAll(); 
	
	public void createUser(UserDTO UserDto);
	
	public void delete(UserDTO UserDto);
	
	public void update(UserDTO UserDto);
}
