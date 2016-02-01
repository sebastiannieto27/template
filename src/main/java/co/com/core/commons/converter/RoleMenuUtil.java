package co.com.core.commons.converter;

import co.com.core.domain.RoleMenu;
import co.com.core.dto.RoleMenuDTO;

public class RoleMenuUtil {

	public static RoleMenuDTO getDtoFromEntity(RoleMenu entity) {
		RoleMenuDTO dto = new RoleMenuDTO();
		dto.setMenuId(entity.getMenuId());
		dto.setRoleId(entity.getRoleId());
		dto.setRoleMenuId(entity.getRoleMenuId());
		return dto;
	}
	
	public static RoleMenu getEntityFromDto(RoleMenuDTO dto) {
		RoleMenu entity = new RoleMenu();
		entity.setMenuId(dto.getMenuId());
		entity.setRoleId(dto.getRoleId());
		entity.setRoleMenuId(dto.getRoleMenuId());
		return entity;
	}
}
