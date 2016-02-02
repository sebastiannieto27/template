package co.com.core.commons.converter;

import co.com.core.domain.RolePermission;
import co.com.core.dto.RolePermissionDTO;

public class RolePermissionUtil {

	public static RolePermissionDTO getDtoFromEntity(RolePermission entity) {
		RolePermissionDTO dto = new RolePermissionDTO();
		dto.setPermissionId(entity.getPermissionId());
		dto.setRoleId(entity.getRoleId());
		dto.setRolePermissionId(entity.getRolePermissionId());
		return dto;
	}
	
	public static RolePermission getEntityFromDto(RolePermissionDTO dto) {
		RolePermission entity = new RolePermission();
		entity.setPermissionId(dto.getPermissionId());
		entity.setRoleId(dto.getRoleId());
		entity.setRolePermissionId(dto.getRolePermissionId());
		return entity;
	}
}
