package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.Respuesta;
import co.com.core.dto.psaber.RespuestaDTO;

public class RespuestaUtil {

	public static RespuestaDTO getDtoFromEntity(Respuesta entity) {
		RespuestaDTO dto = new RespuestaDTO();
		dto.setRespuesta(entity.getRespuesta());
		dto.setDescripcion(entity.getDescripcion());
		dto.setCodigo(entity.getCodigo());
		dto.setVerdadera(entity.getVerdadera());
		dto.setPreguntaId(entity.getPreguntaId());
		dto.setLetra(entity.getLetra());
		return dto;
	}
	
	public static Respuesta getEntityFromDto(RespuestaDTO dto) {
		Respuesta entity = new Respuesta();
		entity.setRespuesta(dto.getRespuesta());
		entity.setDescripcion(dto.getDescripcion());
		entity.setCodigo(dto.getCodigo());
		entity.setVerdadera(dto.getVerdadera());
		entity.setPreguntaId(dto.getPreguntaId());
		entity.setLetra(dto.getLetra());
		return entity;
	}
}
