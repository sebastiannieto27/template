package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.CompetenciaUtil;
import co.com.core.dao.psaber.CompetenciaDAO;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.Competencia;
import co.com.core.dto.psaber.CompetenciaDTO;
import co.com.core.services.psaber.ICompetenciaService;

public class CompetenciaServiceImpl implements ICompetenciaService {

	private static final Logger logger = Logger.getLogger(CompetenciaServiceImpl.class);
	CompetenciaDAO competenciaDAO;
	
	@Override
	public List<CompetenciaDTO> getAll() {
		List<CompetenciaDTO> Competencias = new ArrayList<CompetenciaDTO>();
		List<Competencia> entityList = competenciaDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Competencia Competencia : entityList) {
				Competencias.add(CompetenciaUtil.getDtoFromEntity(Competencia));
			}
		}
		return Competencias;
	}

	@Override
	public List<CompetenciaDTO> getAllFilter(Map<String, Object> filter) {
		List<CompetenciaDTO> Competencias = new ArrayList<CompetenciaDTO>();
		List<Competencia> entityList = competenciaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Competencia Competencia : entityList) {
				Competencias.add(CompetenciaUtil.getDtoFromEntity(Competencia));
			}
		}
		return Competencias;
	}
	

	@Override
	public List<CompetenciaDTO> getByArea(Area area) {
		List<Competencia> entityList = competenciaDAO.getByArea(area);
		if(entityList!=null && entityList.size() > 0) {
			List<CompetenciaDTO> dtoList = new ArrayList<>();
			for(Competencia entity: entityList) {
				dtoList.add(CompetenciaUtil.getDtoFromEntity(entity));
			}
			return dtoList;
		}
		return null;
	}
	
	@Override
	public Competencia create(CompetenciaDTO dto) {
		return competenciaDAO.create(CompetenciaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(CompetenciaDTO dto) {
		competenciaDAO.delete(CompetenciaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(CompetenciaDTO dto) {
		competenciaDAO.update(CompetenciaUtil.getEntityFromDto(dto));
	}

	public CompetenciaDAO getCompetenciaDAO() {
		return competenciaDAO;
	}

	public void setCompetenciaDAO(CompetenciaDAO CompetenciaDAO) {
		this.competenciaDAO = CompetenciaDAO;
	}

}
