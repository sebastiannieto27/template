package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.Materia;
import co.com.core.dto.psaber.MateriaDTO;

public class MateriaUtil {

	public static MateriaDTO getDtoFromEntity(Materia entity) {
		MateriaDTO dto = new MateriaDTO();
		dto.setMateriaId(entity.getMateriaId());
		dto.setComponenteId(entity.getComponenteId());;
		dto.setDescripcion(entity.getDescripcion());
		dto.setNombre(entity.getNombre());
		return dto;
	}
	
	public static Materia getEntityFromDto(MateriaDTO dto) {
		Materia entity = new Materia();
		entity.setMateriaId(dto.getMateriaId());
		entity.setComponenteId(dto.getComponenteId());
		entity.setDescripcion(dto.getDescripcion());
		entity.setNombre(dto.getNombre());
		return entity;
	}
}
