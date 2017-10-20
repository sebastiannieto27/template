package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.PreguntaTemaUtil;
import co.com.core.commons.converter.psaber.PreguntaUtil;
import co.com.core.commons.converter.psaber.TemaUtil;
import co.com.core.dao.psaber.TemaDAO;
import co.com.core.domain.psaber.PreguntaTema;
import co.com.core.domain.psaber.Tema;
import co.com.core.dto.psaber.PreguntaDTO;
import co.com.core.dto.psaber.PreguntaTemaDTO;
import co.com.core.dto.psaber.TemaDTO;
import co.com.core.services.psaber.ITemaService;

public class TemaServiceImpl implements ITemaService {

	private static final Logger logger = Logger.getLogger(TemaServiceImpl.class);
	TemaDAO temaDAO;
	
	@Override
	public List<TemaDTO> getAll() {
		List<TemaDTO> Temas = new ArrayList<TemaDTO>();
		List<Tema> entityList = temaDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Tema Tema : entityList) {
				Temas.add(TemaUtil.getDtoFromEntity(Tema));
			}
		}
		return Temas;
	}

	@Override
	public List<TemaDTO> getAllFilter(Map<String, Object> filter) {
		List<TemaDTO> Temas = new ArrayList<TemaDTO>();
		List<Tema> entityList = temaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Tema Tema : entityList) {
				Temas.add(TemaUtil.getDtoFromEntity(Tema));
			}
		}
		return Temas;
	}
	
	@Override
	public List<PreguntaTemaDTO> findTemaByPregunta(PreguntaDTO dto) {
		List<PreguntaTemaDTO> dtoList = new ArrayList<PreguntaTemaDTO>();
		List<PreguntaTema> entityList = this.temaDAO.findTemaByPregunta(PreguntaUtil.getEntityFromDto(dto));
		
		if(entityList!= null && entityList.size() > 0) {
			for(PreguntaTema entity : entityList) {
				dtoList.add(PreguntaTemaUtil.getDtoFromEntity(entity));
			}
		}
		
		return dtoList;
	}
	
	@Override
	public List<TemaDTO> getNotAssignedTema(String ids) {
		List<TemaDTO> dtoList = new ArrayList<TemaDTO>();
		List<Tema> entityList = this.temaDAO.getNotAssignedTema(ids);
		if(entityList!=null && entityList.size() > 0) {
			for(Tema entity: entityList) {
				dtoList.add(TemaUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public void createPreguntaTema(PreguntaTemaDTO dto) {
		temaDAO.createPreguntaTema(PreguntaTemaUtil.getEntityFromDto(dto));
	}
	
	@Override
	public void deletePreguntaTema(PreguntaTemaDTO dto) {
		temaDAO.deletePreguntaTema(PreguntaTemaUtil.getEntityFromDto(dto));
	}
	
	@Override
	public Tema create(TemaDTO dto) {
		return temaDAO.create(TemaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(TemaDTO dto) {
		temaDAO.delete(TemaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(TemaDTO dto) {
		temaDAO.update(TemaUtil.getEntityFromDto(dto));
	}

	public TemaDAO getTemaDAO() {
		return temaDAO;
	}

	public void setTemaDAO(TemaDAO TemaDAO) {
		this.temaDAO = TemaDAO;
	}
}
