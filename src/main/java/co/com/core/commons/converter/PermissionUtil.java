package co.com.core.commons.converter;

import co.com.core.domain.Permission;
import co.com.core.dto.PermissionDTO;

public class PermissionUtil {

	public static PermissionDTO getDtoFromEntity(Permission entity) {
		PermissionDTO dto = new PermissionDTO();
		dto.setPermissionId(entity.getPermissionId());
		dto.setPermissionName(entity.getPermissionName());
		dto.setCode(entity.getCode());
		return dto;
	}
	
	public static Permission getEntityFromDto(PermissionDTO dto) {
		Permission entity = new Permission();
		entity.setPermissionId(dto.getPermissionId());
		entity.setPermissionName(dto.getPermissionName());
		entity.setCode(dto.getCode());
		return entity;
	}
}
