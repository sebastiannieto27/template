package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.Tema;
import co.com.core.dto.psaber.TemaDTO;

public class TemaUtil {

	public static TemaDTO getDtoFromEntity(Tema entity) {
		TemaDTO dto = new TemaDTO();
		dto.setTemaId(entity.getTemaId());
		dto.setDescripcion(entity.getDescripcion());
		dto.setNombre(entity.getNombre());
		dto.setAreaId(entity.getAreaId());
		return dto;
	}
	
	public static Tema getEntityFromDto(TemaDTO dto) {
		Tema entity = new Tema();
		entity.setTemaId(dto.getTemaId());
		entity.setDescripcion(dto.getDescripcion());
		entity.setNombre(dto.getNombre());
		entity.setAreaId(dto.getAreaId());
		return entity;
	}
}
