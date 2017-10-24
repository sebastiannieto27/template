package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.dto.psaber.ArchivoPruebaDTO;

public class ArchivoPruebaUtil {

	public static ArchivoPruebaDTO getDtoFromEntity(ArchivoPrueba entity) {
		ArchivoPruebaDTO dto = new ArchivoPruebaDTO();
		dto.setArchivoPruebaId(entity.getArchivoPruebaId());
		dto.setNombre(entity.getNombre());
		dto.setNroColumnas(entity.getNroColumnas());
		dto.setNroPreguntas(entity.getNroPreguntas());
		return dto;
	}
	
	public static ArchivoPrueba getEntityFromDto(ArchivoPruebaDTO dto) {
		ArchivoPrueba entity = new ArchivoPrueba();
		entity.setArchivoPruebaId(dto.getArchivoPruebaId());
		entity.setNombre(dto.getNombre());
		entity.setNroColumnas(dto.getNroColumnas());
		entity.setNroPreguntas(dto.getNroPreguntas());
		return entity;
	}
}
