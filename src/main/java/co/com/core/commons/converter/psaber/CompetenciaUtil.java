package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.Competencia;
import co.com.core.dto.psaber.CompetenciaDTO;

public class CompetenciaUtil {

	public static CompetenciaDTO getDtoFromEntity(Competencia entity) {
		CompetenciaDTO dto = new CompetenciaDTO();
		dto.setCompetenciaId(entity.getCompetenciaId());
		dto.setDescripcion(entity.getDescripcion());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		dto.setAreaId(entity.getAreaId());
		return dto;
	}
	
	public static Competencia getEntityFromDto(CompetenciaDTO dto) {
		Competencia entity = new Competencia();
		entity.setCompetenciaId(dto.getCompetenciaId());
		entity.setCodigo(dto.getCodigo());
		entity.setDescripcion(dto.getDescripcion());
		entity.setNombre(dto.getNombre());
		entity.setAreaId(dto.getAreaId());
		return entity;
	}
}
