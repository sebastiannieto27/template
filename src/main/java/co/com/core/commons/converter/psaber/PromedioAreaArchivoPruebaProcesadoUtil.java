package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.PromedioAreaArchivoPruebaProcesado;
import co.com.core.dto.psaber.PromedioAreaArchivoPruebaProcesadoDTO;

public class PromedioAreaArchivoPruebaProcesadoUtil {

	public static PromedioAreaArchivoPruebaProcesadoDTO getDtoFromEntity(PromedioAreaArchivoPruebaProcesado entity) {
		PromedioAreaArchivoPruebaProcesadoDTO dto = new PromedioAreaArchivoPruebaProcesadoDTO();
		dto.setArchivoPruebaProcesadoId(entity.getArchivoPruebaProcesadoId());
		dto.setPromedioAreaArchivoPruebaProcesadoId(entity.getPromedioAreaArchivoPruebaProcesadoId());
		dto.setAreaId(entity.getAreaId());
		dto.setValor(entity.getValor());
		return dto;
	}
	
	public static PromedioAreaArchivoPruebaProcesado getEntityFromDto(PromedioAreaArchivoPruebaProcesadoDTO dto) {
		PromedioAreaArchivoPruebaProcesado entity = new PromedioAreaArchivoPruebaProcesado();
		entity.setArchivoPruebaProcesadoId(dto.getArchivoPruebaProcesadoId());
		entity.setPromedioAreaArchivoPruebaProcesadoId(dto.getPromedioAreaArchivoPruebaProcesadoId());
		entity.setAreaId(dto.getAreaId());
		entity.setValor(dto.getValor());
		return entity;
	}
}
