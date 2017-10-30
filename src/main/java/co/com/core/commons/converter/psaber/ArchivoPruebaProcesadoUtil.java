package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;

public class ArchivoPruebaProcesadoUtil {

	public static ArchivoPruebaProcesadoDTO getDtoFromEntity(ArchivoPruebaProcesado entity) {
		ArchivoPruebaProcesadoDTO dto = new ArchivoPruebaProcesadoDTO();
		dto.setArchivoPruebaProcesadoId(entity.getArchivoPruebaProcesadoId());
		dto.setNombreArchivo(entity.getNombreArchivo());
		dto.setFecCre(entity.getFecCre());
		dto.setArchivoPruebaId(entity.getArchivoPruebaId());
		return dto;
	}
	
	public static ArchivoPruebaProcesado getEntityFromDto(ArchivoPruebaProcesadoDTO dto) {
		ArchivoPruebaProcesado entity = new ArchivoPruebaProcesado();
		entity.setArchivoPruebaProcesadoId(dto.getArchivoPruebaProcesadoId());
		entity.setNombreArchivo(dto.getNombreArchivo());
		entity.setFecCre(dto.getFecCre());
		entity.setArchivoPruebaId(dto.getArchivoPruebaId());
		return entity;
	}
}
