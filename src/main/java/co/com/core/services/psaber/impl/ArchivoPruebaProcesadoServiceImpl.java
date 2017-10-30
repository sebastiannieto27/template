package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.ArchivoPruebaProcesadoUtil;
import co.com.core.dao.psaber.ArchivoPruebaProcesadoDAO;
import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;
import co.com.core.services.psaber.IArchivoPruebaProcesadoService;

public class ArchivoPruebaProcesadoServiceImpl implements IArchivoPruebaProcesadoService {

	private static final Logger logger = Logger.getLogger(ArchivoPruebaProcesadoServiceImpl.class);
	ArchivoPruebaProcesadoDAO archivoPruebaProcesadoDAO;
	
	@Override
	public List<ArchivoPruebaProcesadoDTO> getAll() {
		List<ArchivoPruebaProcesadoDTO> ArchivoPruebaProcesados = new ArrayList<ArchivoPruebaProcesadoDTO>();
		List<ArchivoPruebaProcesado> entityList = archivoPruebaProcesadoDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(ArchivoPruebaProcesado ArchivoPruebaProcesado : entityList) {
				ArchivoPruebaProcesados.add(ArchivoPruebaProcesadoUtil.getDtoFromEntity(ArchivoPruebaProcesado));
			}
		}
		return ArchivoPruebaProcesados;
	}

	@Override
	public List<ArchivoPruebaProcesadoDTO> getAllFilter(Map<String, Object> filter) {
		List<ArchivoPruebaProcesadoDTO> ArchivoPruebaProcesados = new ArrayList<ArchivoPruebaProcesadoDTO>();
		List<ArchivoPruebaProcesado> entityList = archivoPruebaProcesadoDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(ArchivoPruebaProcesado ArchivoPruebaProcesado : entityList) {
				ArchivoPruebaProcesados.add(ArchivoPruebaProcesadoUtil.getDtoFromEntity(ArchivoPruebaProcesado));
			}
		}
		return ArchivoPruebaProcesados;
	}
	
	@Override
	public ArchivoPruebaProcesadoDTO getByDateNName(Date date, String name) {
		ArchivoPruebaProcesadoDTO dto = null;
		ArchivoPruebaProcesado entity = archivoPruebaProcesadoDAO.getByDateNName(date, name);
		if(entity!=null) {
			ArchivoPruebaProcesadoUtil.getDtoFromEntity(entity);
		}
		return dto;
	}
	
	@Override
	public ArchivoPruebaProcesado create(ArchivoPruebaProcesadoDTO dto) {
		return archivoPruebaProcesadoDAO.create(ArchivoPruebaProcesadoUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(ArchivoPruebaProcesadoDTO dto) {
		archivoPruebaProcesadoDAO.delete(ArchivoPruebaProcesadoUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(ArchivoPruebaProcesadoDTO dto) {
		archivoPruebaProcesadoDAO.update(ArchivoPruebaProcesadoUtil.getEntityFromDto(dto));
	}

	public ArchivoPruebaProcesadoDAO getArchivoPruebaProcesadoDAO() {
		return archivoPruebaProcesadoDAO;
	}

	public void setArchivoPruebaProcesadoDAO(ArchivoPruebaProcesadoDAO ArchivoPruebaProcesadoDAO) {
		this.archivoPruebaProcesadoDAO = ArchivoPruebaProcesadoDAO;
	}
}
