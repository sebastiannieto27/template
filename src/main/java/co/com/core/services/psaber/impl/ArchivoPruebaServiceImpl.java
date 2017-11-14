package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.ArchivoPruebaUtil;
import co.com.core.commons.converter.psaber.AreaArchivoPruebaUtil;
import co.com.core.dao.psaber.ArchivoPruebaDAO;
import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.AreaArchivoPrueba;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.AreaArchivoPruebaDTO;
import co.com.core.services.psaber.IArchivoPruebaService;

public class ArchivoPruebaServiceImpl implements IArchivoPruebaService {

	private static final Logger logger = Logger.getLogger(ArchivoPruebaServiceImpl.class);
	ArchivoPruebaDAO archivoPruebaDAO;
	
	@Override
	public List<ArchivoPruebaDTO> getAll() {
		List<ArchivoPruebaDTO> ArchivoPruebas = new ArrayList<ArchivoPruebaDTO>();
		List<ArchivoPrueba> entityList = archivoPruebaDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(ArchivoPrueba ArchivoPrueba : entityList) {
				ArchivoPruebas.add(ArchivoPruebaUtil.getDtoFromEntity(ArchivoPrueba));
			}
		}
		return ArchivoPruebas;
	}

	@Override
	public List<ArchivoPruebaDTO> getAllFilter(Map<String, Object> filter) {
		List<ArchivoPruebaDTO> dtoList = new ArrayList<ArchivoPruebaDTO>();
		List<ArchivoPrueba> entityList = archivoPruebaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(ArchivoPrueba ArchivoPrueba : entityList) {
				dtoList.add(ArchivoPruebaUtil.getDtoFromEntity(ArchivoPrueba));
			}
		}
		return dtoList;
	}
	
	@Override
	public ArchivoPruebaDTO getByArchivoPruebaId(Integer id) {
		ArchivoPruebaDTO dto = new ArchivoPruebaDTO();
		ArchivoPrueba entity = archivoPruebaDAO.getByArchivoPruebaId(id);
		if(entity!=null) {
			dto = ArchivoPruebaUtil.getDtoFromEntity(entity);
		}
		return dto;
	}

	@Override
	public List<AreaArchivoPruebaDTO> getAreasByArchivoPrueba(ArchivoPruebaDTO dto) {
		List<AreaArchivoPruebaDTO> dtoList = new ArrayList<AreaArchivoPruebaDTO>();
		List<AreaArchivoPrueba> entityList = archivoPruebaDAO.getAreasByArchivoPrueba(ArchivoPruebaUtil.getEntityFromDto(dto));
		if(entityList!=null && entityList.size() > 0) {
			for(AreaArchivoPrueba entity : entityList) {
				dtoList.add(AreaArchivoPruebaUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public ArchivoPrueba create(ArchivoPruebaDTO dto) {
		return archivoPruebaDAO.create(ArchivoPruebaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(ArchivoPruebaDTO dto) {
		archivoPruebaDAO.delete(ArchivoPruebaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(ArchivoPruebaDTO dto) {
		archivoPruebaDAO.update(ArchivoPruebaUtil.getEntityFromDto(dto));
	}

	public ArchivoPruebaDAO getArchivoPruebaDAO() {
		return archivoPruebaDAO;
	}

	public void setArchivoPruebaDAO(ArchivoPruebaDAO ArchivoPruebaDAO) {
		this.archivoPruebaDAO = ArchivoPruebaDAO;
	}
}
