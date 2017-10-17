package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.PreguntaUtil;
import co.com.core.dao.psaber.PreguntaDAO;
import co.com.core.domain.psaber.Pregunta;
import co.com.core.dto.psaber.PreguntaDTO;
import co.com.core.services.psaber.IPreguntaService;

public class PreguntaServiceImpl implements IPreguntaService {

	private static final Logger logger = Logger.getLogger(PreguntaServiceImpl.class);
	PreguntaDAO PreguntaDAO;
	
	@Override
	public List<PreguntaDTO> getAll() {
		List<PreguntaDTO> Preguntas = new ArrayList<PreguntaDTO>();
		List<Pregunta> entityList = PreguntaDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Pregunta Pregunta : entityList) {
				Preguntas.add(PreguntaUtil.getDtoFromEntity(Pregunta));
			}
		}
		return Preguntas;
	}

	@Override
	public List<PreguntaDTO> getAllFilter(Map<String, Object> filter) {
		List<PreguntaDTO> Preguntas = new ArrayList<PreguntaDTO>();
		List<Pregunta> entityList = PreguntaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Pregunta Pregunta : entityList) {
				Preguntas.add(PreguntaUtil.getDtoFromEntity(Pregunta));
			}
		}
		return Preguntas;
	}
	
	@Override
	public Pregunta create(PreguntaDTO dto) {
		return PreguntaDAO.create(PreguntaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(PreguntaDTO dto) {
		PreguntaDAO.delete(PreguntaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(PreguntaDTO dto) {
		PreguntaDAO.update(PreguntaUtil.getEntityFromDto(dto));
	}

	public PreguntaDAO getPreguntaDAO() {
		return PreguntaDAO;
	}

	public void setPreguntaDAO(PreguntaDAO PreguntaDAO) {
		this.PreguntaDAO = PreguntaDAO;
	}
}
