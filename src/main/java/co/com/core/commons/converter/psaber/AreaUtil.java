package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.Area;
import co.com.core.dto.psaber.AreaDTO;

public class AreaUtil {

	public static AreaDTO getDtoFromEntity(Area entity) {
		AreaDTO dto = new AreaDTO();
		dto.setAreaId(entity.getAreaId());
		dto.setDescripcion(entity.getDescripcion());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		return dto;
	}
	
	public static Area getEntityFromDto(AreaDTO dto) {
		Area entity = new Area();
		entity.setAreaId(dto.getAreaId());
		entity.setCodigo(dto.getCodigo());
		entity.setDescripcion(dto.getDescripcion());
		entity.setNombre(dto.getNombre());
		return entity;
	}
}
