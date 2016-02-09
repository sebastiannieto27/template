package co.com.core.commons.converter;

import co.com.core.domain.PagePermission;
import co.com.core.dto.PagePermissionDTO;

public class PagePermissionUtil {

	public static PagePermissionDTO getDtoFromEntity(PagePermission entity) {
		PagePermissionDTO dto = new PagePermissionDTO();
		dto.setIdPagePermission(entity.getIdPagePermission());
		dto.setPageId(entity.getPageId());
		dto.setPermissionId(entity.getPermissionId());
		return dto;
	}
	
	public static PagePermission getEntityFromDto(PagePermissionDTO dto) {
		PagePermission entity = new PagePermission();
		entity.setIdPagePermission(dto.getIdPagePermission());
		entity.setPageId(dto.getPageId());
		entity.setPermissionId(dto.getPermissionId());
		return entity;
	}
}
