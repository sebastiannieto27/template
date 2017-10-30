package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.dto.psaber.RespuestaExamenDTO;

public class RespuestaExamenUtil {

	public static RespuestaExamenDTO getDtoFromEntity(RespuestaExamen entity) {
		RespuestaExamenDTO dto = new RespuestaExamenDTO();
		dto.setRespuestaExamenId(entity.getRespuestaExamenId());
		dto.setArchivoPruebaProcesadoId(entity.getArchivoPruebaProcesadoId());
		dto.setRespuesta(entity.getRespuesta());
		dto.setUserId(entity.getUserId());
		dto.setProcesado(entity.getProcesado());
		return dto;
	}
	
	public static RespuestaExamen getEntityFromDto(RespuestaExamenDTO dto) {
		RespuestaExamen entity = new RespuestaExamen();
		entity.setRespuestaExamenId(dto.getRespuestaExamenId());
		entity.setArchivoPruebaProcesadoId(dto.getArchivoPruebaProcesadoId());
		entity.setRespuesta(dto.getRespuesta());
		entity.setUserId(dto.getUserId());
		entity.setProcesado(dto.getProcesado());
		return entity;
	}
}
