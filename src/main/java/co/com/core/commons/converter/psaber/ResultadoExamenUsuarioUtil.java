package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.ResultadoExamenUsuario;
import co.com.core.dto.psaber.ResultadoExamenUsuarioDTO;

public class ResultadoExamenUsuarioUtil {

	public static ResultadoExamenUsuarioDTO getDtoFromEntity(ResultadoExamenUsuario entity) {
		ResultadoExamenUsuarioDTO dto = new ResultadoExamenUsuarioDTO();
		dto.setResultadoExamenUsuarioId(entity.getResultadoExamenUsuarioId());
		dto.setArchivoPruebaId(entity.getArchivoPruebaId());
		dto.setAreaId(entity.getAreaId());
		dto.setNroPreguntasArea(entity.getNroPreguntasArea());
		dto.setRespuestaExamenId(entity.getRespuestaExamenId());
		dto.setRespuestasCorrectas(entity.getRespuestasCorrectas());
		dto.setRespuestasErradas(entity.getRespuestasErradas());
		dto.setSinContestar(entity.getSinContestar());
		dto.setUserId(entity.getUserId());
		dto.setPorcentajeAcierto(entity.getPorcentajeAcierto());
		dto.setPromedioArea(entity.getPromedioArea());
		return dto;
	}
	
	public static ResultadoExamenUsuario getEntityFromDto(ResultadoExamenUsuarioDTO dto) {
		ResultadoExamenUsuario entity = new ResultadoExamenUsuario();
		entity.setResultadoExamenUsuarioId(dto.getResultadoExamenUsuarioId());
		entity.setArchivoPruebaId(dto.getArchivoPruebaId());
		entity.setAreaId(dto.getAreaId());
		entity.setNroPreguntasArea(dto.getNroPreguntasArea());
		entity.setRespuestaExamenId(dto.getRespuestaExamenId());
		entity.setRespuestasCorrectas(dto.getRespuestasCorrectas());
		entity.setRespuestasErradas(dto.getRespuestasErradas());
		entity.setSinContestar(dto.getSinContestar());
		entity.setUserId(dto.getUserId());
		entity.setPorcentajeAcierto(dto.getPorcentajeAcierto());
		entity.setPromedioArea(dto.getPromedioArea());
		return entity;
	}
}
