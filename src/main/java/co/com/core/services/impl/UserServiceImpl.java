package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.core.commons.converter.UserUtil;
import co.com.core.dao.UserDAO;
import co.com.core.domain.User;
import co.com.core.dto.UserDTO;
import co.com.core.services.IUserService;

public class UserServiceImpl implements IUserService {

	UserDAO userDAO;
	
	@Override
	public UserDTO getUserById(Integer userId) {
		User user = userDAO.getUserById(userId);
		UserDTO userDto = UserUtil.getDtoFromEntity(user);
		return userDto;
	}
	
	@Override
	public UserDTO login(String userEmail, String password) {
		UserDTO userDto = null;
		User user = userDAO.login(userEmail, password);
		if (user!=null) {
			userDto = UserUtil.getDtoFromEntity(user);
		}
		return userDto;
	}
	
	@Override
	public List<UserDTO> getAll() {
		List<UserDTO> Users = new ArrayList<UserDTO>();
		List<User> entityList = userDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(User User : entityList) {
				Users.add(UserUtil.getDtoFromEntity(User));
			}
		}
		return Users;
	}

	@Override
	public UserDTO getByMail(String userEmail) {
		UserDTO userDto = null;
		User user = userDAO.getByMail(userEmail);
		if (user!=null) {
			userDto = UserUtil.getDtoFromEntity(user);
		}
		return userDto;
	}
	
	@Override
	public List<UserDTO> getUserByName(String name) {
		List<UserDTO> userDtoList = null;
		List<User> userList = userDAO.getUserByName(name);
		if (userList!=null) {
			userDtoList = new ArrayList<UserDTO>();
			for(User entity: userList) {
				userDtoList.add(UserUtil.getDtoFromEntity(entity));
			}
		}
		return userDtoList;
	}
	
	@Override
	public UserDTO getUserByDocNum(String idNumber) {
		UserDTO userDto = null;
		User user = userDAO.getUserByDocNum(idNumber);
		if (user!=null) {
			userDto = UserUtil.getDtoFromEntity(user);
		}
		return userDto;
	}
	
	@Override
	public void createUser(UserDTO UserDto) {
		userDAO.createUser(UserUtil.getEntityFromDto(UserDto));
	}

	@Override
	public void delete(UserDTO UserDto) {
		userDAO.delete(UserUtil.getEntityFromDto(UserDto));
	}

	@Override
	public void update(UserDTO UserDto) {
		userDAO.update(UserUtil.getEntityFromDto(UserDto));
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
