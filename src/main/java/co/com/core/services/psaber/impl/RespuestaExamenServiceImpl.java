package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.ArchivoPruebaProcesadoUtil;
import co.com.core.commons.converter.psaber.RespuestaExamenUtil;
import co.com.core.dao.psaber.RespuestaExamenDAO;
import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;
import co.com.core.dto.psaber.RespuestaExamenDTO;
import co.com.core.services.psaber.IRespuestaExamenService;

public class RespuestaExamenServiceImpl implements IRespuestaExamenService {

	private static final Logger logger = Logger.getLogger(RespuestaExamenServiceImpl.class);
	RespuestaExamenDAO respuestaExamenDAO;
	
	@Override
	public List<RespuestaExamenDTO> getAll() {
		List<RespuestaExamenDTO> RespuestaExamens = new ArrayList<RespuestaExamenDTO>();
		List<RespuestaExamen> entityList = respuestaExamenDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(RespuestaExamen RespuestaExamen : entityList) {
				RespuestaExamens.add(RespuestaExamenUtil.getDtoFromEntity(RespuestaExamen));
			}
		}
		return RespuestaExamens;
	}

	@Override
	public List<RespuestaExamenDTO> getAllFilter(Map<String, Object> filter) {
		List<RespuestaExamenDTO> RespuestaExamens = new ArrayList<RespuestaExamenDTO>();
		List<RespuestaExamen> entityList = respuestaExamenDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(RespuestaExamen RespuestaExamen : entityList) {
				RespuestaExamens.add(RespuestaExamenUtil.getDtoFromEntity(RespuestaExamen));
			}
		}
		return RespuestaExamens;
	}
	
	@Override
	public List<RespuestaExamenDTO> getByArchivoPruebaProcesado(ArchivoPruebaProcesadoDTO id) {
		List<RespuestaExamenDTO> dtoList = null;
		List<RespuestaExamen> entityList = respuestaExamenDAO.getByArchivoPruebaProcesado(ArchivoPruebaProcesadoUtil.getEntityFromDto(id));
		if(entityList!=null && entityList.size() > 0) {
			for(RespuestaExamen entity : entityList) {
				dtoList.add(RespuestaExamenUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public RespuestaExamen create(RespuestaExamenDTO dto) {
		return respuestaExamenDAO.create(RespuestaExamenUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(RespuestaExamenDTO dto) {
		respuestaExamenDAO.delete(RespuestaExamenUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(RespuestaExamenDTO dto) {
		respuestaExamenDAO.update(RespuestaExamenUtil.getEntityFromDto(dto));
	}

	public RespuestaExamenDAO getRespuestaExamenDAO() {
		return respuestaExamenDAO;
	}

	public void setRespuestaExamenDAO(RespuestaExamenDAO RespuestaExamenDAO) {
		this.respuestaExamenDAO = RespuestaExamenDAO;
	}
}
