package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.Competencia;
import co.com.core.dto.psaber.CompetenciaDTO;

public class CompetenciaUtil {

	public static CompetenciaDTO getDtoFromEntity(Competencia entity) {
		CompetenciaDTO dto = new CompetenciaDTO();
		dto.setCompetenciaId(entity.getCompetenciaId());
		dto.setContenidoId(entity.getContenidoId());
		dto.setDescripcion(entity.getDescripcion());
		dto.setNombre(entity.getNombre());
		return dto;
	}
	
	public static Competencia getEntityFromDto(CompetenciaDTO dto) {
		Competencia entity = new Competencia();
		entity.setCompetenciaId(dto.getCompetenciaId());
		entity.setContenidoId(dto.getContenidoId());
		entity.setDescripcion(dto.getDescripcion());
		entity.setNombre(dto.getNombre());
		return entity;
	}
}
