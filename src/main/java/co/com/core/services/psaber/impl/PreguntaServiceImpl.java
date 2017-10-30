package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.PreguntaUtil;
import co.com.core.commons.converter.psaber.RespuestaUtil;
import co.com.core.dao.psaber.PreguntaDAO;
import co.com.core.dao.psaber.TemaDAO;
import co.com.core.domain.psaber.Pregunta;
import co.com.core.domain.psaber.Respuesta;
import co.com.core.dto.psaber.PreguntaDTO;
import co.com.core.dto.psaber.RespuestaDTO;
import co.com.core.services.psaber.IPreguntaService;

public class PreguntaServiceImpl implements IPreguntaService {

	private static final Logger logger = Logger.getLogger(PreguntaServiceImpl.class);
	PreguntaDAO preguntaDAO;
	TemaDAO temaDAO;
	
	@Override
	public List<PreguntaDTO> getAll() {
		List<PreguntaDTO> Preguntas = new ArrayList<PreguntaDTO>();
		List<Pregunta> entityList = preguntaDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Pregunta Pregunta : entityList) {
				Preguntas.add(PreguntaUtil.getDtoFromEntity(Pregunta));
			}
		}
		return Preguntas;
	}

	@Override
	public List<PreguntaDTO> getAllFilter(Map<String, Object> filter) {
		List<PreguntaDTO> dtoList = new ArrayList<PreguntaDTO>();
		List<Pregunta> entityList = preguntaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Pregunta pregunta : entityList) {
				dtoList.add(PreguntaUtil.getDtoFromEntity(pregunta));
			}
		}
		return dtoList;
	}

	@Override
	public RespuestaDTO getRespuestaByPreguntaCode(String code) {
		RespuestaDTO dto = null;
		Pregunta pregunta = preguntaDAO.getPreguntaByCode(code);
		if(pregunta!=null) {
			Respuesta entity = preguntaDAO.getRespuestaByPregunta(pregunta);
			dto = RespuestaUtil.getDtoFromEntity(entity);
		}
		
		return dto;
	}
	
	@Override
	public Pregunta create(PreguntaDTO dto) {
		return preguntaDAO.create(PreguntaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(PreguntaDTO dto) {
		preguntaDAO.delete(PreguntaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(PreguntaDTO dto) {
		preguntaDAO.update(PreguntaUtil.getEntityFromDto(dto));
	}

	public PreguntaDAO getPreguntaDAO() {
		return preguntaDAO;
	}

	public void setPreguntaDAO(PreguntaDAO PreguntaDAO) {
		this.preguntaDAO = PreguntaDAO;
	}
}
