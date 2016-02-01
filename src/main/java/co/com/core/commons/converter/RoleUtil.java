package co.com.core.commons.converter;

import co.com.core.domain.Role;
import co.com.core.domain.UserRole;
import co.com.core.dto.RoleDTO;
import co.com.core.dto.UserRoleDTO;

public class RoleUtil {

	public static RoleDTO getDtoFromEntity(Role entity) {
		RoleDTO dto = new RoleDTO();
		dto.setRoleName(entity.getRoleName());
		dto.setRoleId(entity.getRoleId());
		dto.setDescription(entity.getDescription());
		return dto;
	}
	
	public static Role getEntityFromDto(RoleDTO dto) {
		Role entity = new Role();
		entity.setRoleId(dto.getRoleId());
		entity.setDescription(dto.getDescription());
		entity.setRoleName(dto.getRoleName());
		return entity;
	}
}
