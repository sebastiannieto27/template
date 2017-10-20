package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.PreguntaTema;
import co.com.core.dto.psaber.PreguntaTemaDTO;

public class PreguntaTemaUtil {

	public static PreguntaTemaDTO getDtoFromEntity(PreguntaTema entity) {
		PreguntaTemaDTO dto = new PreguntaTemaDTO();
		dto.setPreguntaTemaId(entity.getPreguntaTemaId());
		dto.setPreguntaId(entity.getPreguntaId());
		dto.setTemaId(entity.getTemaId());
		return dto;
	}
	
	public static PreguntaTema getEntityFromDto(PreguntaTemaDTO dto) {
		PreguntaTema entity = new PreguntaTema();
		entity.setPreguntaTemaId(dto.getPreguntaTemaId());
		entity.setPreguntaId(dto.getPreguntaId());
		entity.setTemaId(dto.getTemaId());
		return entity;
	}
}
