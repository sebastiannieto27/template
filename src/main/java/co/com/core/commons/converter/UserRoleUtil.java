package co.com.core.commons.converter;

import co.com.core.domain.UserRole;
import co.com.core.dto.UserRoleDTO;

public class UserRoleUtil {

	public static UserRoleDTO getDtoFromEntity(UserRole entity) {
		UserRoleDTO dto = new UserRoleDTO();
		dto.setRoleId(entity.getRoleId());
		dto.setUserId(entity.getUserId());
		dto.setUserRoleId(entity.getUserRoleId());
		return dto;
	}
	
	public static UserRole getEntityFromDto(UserRoleDTO dto) {
		UserRole entity = new UserRole();
		entity.setRoleId(dto.getRoleId());
		entity.setUserId(dto.getUserId());
		entity.setUserRoleId(dto.getUserRoleId());
		return entity;
	}
}
