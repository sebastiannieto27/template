package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.Pregunta;
import co.com.core.dto.psaber.PreguntaDTO;

public class PreguntaUtil {

	public static PreguntaDTO getDtoFromEntity(Pregunta entity) {
		PreguntaDTO dto = new PreguntaDTO();
		dto.setPreguntaId(entity.getPreguntaId());
		dto.setDescripcion(entity.getDescripcion());
		dto.setTitulo(entity.getTitulo());
		dto.setCodigo(entity.getCodigo());
		return dto;
	}
	
	public static Pregunta getEntityFromDto(PreguntaDTO dto) {
		Pregunta entity = new Pregunta();
		entity.setPreguntaId(dto.getPreguntaId());
		entity.setDescripcion(dto.getDescripcion());
		entity.setTitulo(dto.getTitulo());
		entity.setCodigo(dto.getCodigo());
		return entity;
	}
}
