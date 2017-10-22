package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.RespuestaUtil;
import co.com.core.dao.psaber.RespuestaDAO;
import co.com.core.domain.psaber.Respuesta;
import co.com.core.dto.psaber.RespuestaDTO;
import co.com.core.services.psaber.IRespuestaService;

public class RespuestaServiceImpl implements IRespuestaService {

	private static final Logger logger = Logger.getLogger(RespuestaServiceImpl.class);
	RespuestaDAO respuestaDAO;
	
	@Override
	public List<RespuestaDTO> getAll() {
		List<RespuestaDTO> dtoList = new ArrayList<RespuestaDTO>();
		List<Respuesta> entityList = respuestaDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Respuesta Respuesta : entityList) {
				dtoList.add(RespuestaUtil.getDtoFromEntity(Respuesta));
			}
		}
		return dtoList;
	}

	@Override
	public List<RespuestaDTO> getAllFilter(Map<String, Object> filter) {
		List<RespuestaDTO> dtoList = new ArrayList<RespuestaDTO>();
		List<Respuesta> entityList = respuestaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Respuesta Respuesta : entityList) {
				dtoList.add(RespuestaUtil.getDtoFromEntity(Respuesta));
			}
		}
		return dtoList;
	}
	
	@Override
	public Respuesta create(RespuestaDTO dto) {
		return respuestaDAO.create(RespuestaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(RespuestaDTO dto) {
		respuestaDAO.delete(RespuestaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(RespuestaDTO dto) {
		respuestaDAO.update(RespuestaUtil.getEntityFromDto(dto));
	}

	public RespuestaDAO getRespuestaDAO() {
		return respuestaDAO;
	}

	public void setRespuestaDAO(RespuestaDAO RespuestaDAO) {
		this.respuestaDAO = RespuestaDAO;
	}
}
