package co.com.core.commons.converter;

import co.com.core.domain.User;
import co.com.core.dto.UserDTO;

public class UserUtil {

	public static UserDTO getDtoFromEntity(User user) {
		UserDTO userDto = new UserDTO();
		
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setActive(user.getActive());
		userDto.setCreationDate(user.getCreationDate());
		userDto.setEmail(user.getEmail());
		userDto.setIdNumber(user.getIdNumber());
		userDto.setPassword(user.getPassword());
		userDto.setUserId(user.getUserId());
		userDto.setAccountLocked(user.getAccountLocked());
		userDto.setCompleteName(user.getCompleteName());
		return userDto;
	}
	
	public static User getEntityFromDto(UserDTO userDto){
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setActive(userDto.getActive());
		user.setCreationDate(userDto.getCreationDate());
		user.setEmail(userDto.getEmail());
		user.setIdNumber(userDto.getIdNumber());
		user.setPassword(userDto.getPassword());
		user.setAccountLocked(userDto.getAccountLocked());
		user.setCompleteName(userDto.getCompleteName());
		return user;
	}
}
