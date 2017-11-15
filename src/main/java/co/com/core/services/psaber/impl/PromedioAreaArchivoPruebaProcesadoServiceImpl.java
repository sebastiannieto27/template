package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.ArchivoPruebaProcesadoUtil;
import co.com.core.commons.converter.psaber.PromedioAreaArchivoPruebaProcesadoUtil;
import co.com.core.dao.psaber.PromedioAreaArchivoPruebaProcesadoDAO;
import co.com.core.domain.psaber.PromedioAreaArchivoPruebaProcesado;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;
import co.com.core.dto.psaber.PromedioAreaArchivoPruebaProcesadoDTO;
import co.com.core.services.psaber.IPromedioAreaArchivoPruebaProcesadoService;

public class PromedioAreaArchivoPruebaProcesadoServiceImpl implements IPromedioAreaArchivoPruebaProcesadoService {

	private static final Logger logger = Logger.getLogger(PromedioAreaArchivoPruebaProcesadoServiceImpl.class);
	PromedioAreaArchivoPruebaProcesadoDAO promedioAreaArchivoPruebaProcesadoDAO;
	
	@Override
	public List<PromedioAreaArchivoPruebaProcesadoDTO> getAll() {
		List<PromedioAreaArchivoPruebaProcesadoDTO> dtoList = new ArrayList<PromedioAreaArchivoPruebaProcesadoDTO>();
		List<PromedioAreaArchivoPruebaProcesado> entityList = promedioAreaArchivoPruebaProcesadoDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(PromedioAreaArchivoPruebaProcesado PromedioAreaRespuestaExamen : entityList) {
				dtoList.add(PromedioAreaArchivoPruebaProcesadoUtil.getDtoFromEntity(PromedioAreaRespuestaExamen));
			}
		}
		return dtoList;
	}

	@Override
	public List<PromedioAreaArchivoPruebaProcesadoDTO> getAllFilter(Map<String, Object> filter) {
		List<PromedioAreaArchivoPruebaProcesadoDTO> dtoList = new ArrayList<PromedioAreaArchivoPruebaProcesadoDTO>();
		List<PromedioAreaArchivoPruebaProcesado> entityList = promedioAreaArchivoPruebaProcesadoDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(PromedioAreaArchivoPruebaProcesado item : entityList) {
				dtoList.add(PromedioAreaArchivoPruebaProcesadoUtil.getDtoFromEntity(item));
			}
		}
		return dtoList;
	}
	

	@Override
	public List<PromedioAreaArchivoPruebaProcesadoDTO> getByArchivoPruebaProcesado(ArchivoPruebaProcesadoDTO dto) {
		List<PromedioAreaArchivoPruebaProcesadoDTO> dtoList = new ArrayList<PromedioAreaArchivoPruebaProcesadoDTO>();
		List<PromedioAreaArchivoPruebaProcesado> entityList = 
				promedioAreaArchivoPruebaProcesadoDAO.getByArchivoPruebaProcesado(ArchivoPruebaProcesadoUtil.getEntityFromDto(dto));
		if(entityList!=null && entityList.size() > 0) {
			for(PromedioAreaArchivoPruebaProcesado item : entityList) {
				dtoList.add(PromedioAreaArchivoPruebaProcesadoUtil.getDtoFromEntity(item));
			}
		}
		return dtoList;
	}
	
	@Override
	public PromedioAreaArchivoPruebaProcesado create(PromedioAreaArchivoPruebaProcesadoDTO dto) {
		return promedioAreaArchivoPruebaProcesadoDAO.create(PromedioAreaArchivoPruebaProcesadoUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(PromedioAreaArchivoPruebaProcesadoDTO dto) {
		promedioAreaArchivoPruebaProcesadoDAO.delete(PromedioAreaArchivoPruebaProcesadoUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(PromedioAreaArchivoPruebaProcesadoDTO dto) {
		promedioAreaArchivoPruebaProcesadoDAO.update(PromedioAreaArchivoPruebaProcesadoUtil.getEntityFromDto(dto));
	}

	public PromedioAreaArchivoPruebaProcesadoDAO getPromedioAreaArchivoPruebaProcesadoDAO() {
		return promedioAreaArchivoPruebaProcesadoDAO;
	}

	public void setPromedioAreaArchivoPruebaProcesadoDAO(
			PromedioAreaArchivoPruebaProcesadoDAO promedioAreaArchivoPruebaProcesadoDAO) {
		this.promedioAreaArchivoPruebaProcesadoDAO = promedioAreaArchivoPruebaProcesadoDAO;
	}
}
