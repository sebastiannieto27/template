package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.MateriaUtil;
import co.com.core.dao.psaber.MateriaDAO;
import co.com.core.domain.psaber.Materia;
import co.com.core.dto.psaber.MateriaDTO;
import co.com.core.services.psaber.IMateriaService;

public class MateriaServiceImpl implements IMateriaService {

	private static final Logger logger = Logger.getLogger(MateriaServiceImpl.class);
	MateriaDAO materiaDAO;
	
	@Override
	public List<MateriaDTO> getAll() {
		List<MateriaDTO> materias = new ArrayList<MateriaDTO>();
		List<Materia> entityList = materiaDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Materia Materia : entityList) {
				materias.add(MateriaUtil.getDtoFromEntity(Materia));
			}
		}
		return materias;
	}

	@Override
	public List<MateriaDTO> getAllFilter(Map<String, Object> filter) {
		List<MateriaDTO> materias = new ArrayList<MateriaDTO>();
		List<Materia> entityList = materiaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Materia Materia : entityList) {
				materias.add(MateriaUtil.getDtoFromEntity(Materia));
			}
		}
		return materias;
	}
	
	@Override
	public Materia create(MateriaDTO dto) {
		return materiaDAO.create(MateriaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(MateriaDTO dto) {
		materiaDAO.delete(MateriaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(MateriaDTO dto) {
		materiaDAO.update(MateriaUtil.getEntityFromDto(dto));
	}

	public MateriaDAO getMateriaDAO() {
		return materiaDAO;
	}

	public void setMateriaDAO(MateriaDAO MateriaDAO) {
		this.materiaDAO = MateriaDAO;
	}
}
