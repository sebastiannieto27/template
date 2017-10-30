package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.AreaArchivoPrueba;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.AreaArchivoPruebaDTO;

public class AreaArchivoPruebaUtil {

	public static AreaArchivoPruebaDTO getDtoFromEntity(AreaArchivoPrueba entity) {
		AreaArchivoPruebaDTO dto = new AreaArchivoPruebaDTO();
		dto.setArchivoPruebaId(entity.getArchivoPruebaId());
		dto.setAreaArchivoPruebaId(entity.getAreaArchivoPruebaId());
		dto.setAreaId(entity.getAreaId());
		dto.setNroColumna(entity.getNroColumna());
		return dto;
	}
	
	public static AreaArchivoPrueba getEntityFromDto(AreaArchivoPruebaDTO dto) {
		AreaArchivoPrueba entity = new AreaArchivoPrueba();
		entity.setArchivoPruebaId(dto.getArchivoPruebaId());
		entity.setAreaArchivoPruebaId(dto.getAreaArchivoPruebaId());
		entity.setAreaId(dto.getAreaId());
		entity.setNroColumna(dto.getNroColumna());
		return entity;
	}
}
