package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.PromedioAreaRespuestaExamen;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.PromedioAreaRespuestaExamenDTO;

public class PromedioAreaRespuestaExamenUtil {

	public static PromedioAreaRespuestaExamenDTO getDtoFromEntity(PromedioAreaRespuestaExamen entity) {
		PromedioAreaRespuestaExamenDTO dto = new PromedioAreaRespuestaExamenDTO();
		dto.setRespuestaExamenId(entity.getRespuestaExamenId());
		dto.setPromedioAreaRespuestaExamenId(entity.getPromedioAreaRespuestaExamenId());
		dto.setAreaId(entity.getAreaId());
		dto.setValor(entity.getValor());
		return dto;
	}
	
	public static PromedioAreaRespuestaExamen getEntityFromDto(PromedioAreaRespuestaExamenDTO dto) {
		PromedioAreaRespuestaExamen entity = new PromedioAreaRespuestaExamen();
		entity.setRespuestaExamenId(dto.getRespuestaExamenId());
		entity.setPromedioAreaRespuestaExamenId(dto.getPromedioAreaRespuestaExamenId());
		entity.setAreaId(dto.getAreaId());
		entity.setValor(dto.getValor());
		return entity;
	}
}
