package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.ArchivoPruebaUtil;
import co.com.core.commons.converter.psaber.AreaArchivoPruebaUtil;
import co.com.core.commons.converter.psaber.AreaUtil;
import co.com.core.commons.converter.psaber.PreguntaTemaUtil;
import co.com.core.dao.psaber.AreaDAO;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.AreaArchivoPrueba;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.AreaArchivoPruebaDTO;
import co.com.core.dto.psaber.AreaDTO;
import co.com.core.dto.psaber.PreguntaTemaDTO;
import co.com.core.services.psaber.IAreaService;

public class AreaServiceImpl implements IAreaService {

	private static final Logger logger = Logger.getLogger(AreaServiceImpl.class);
	AreaDAO areaDAO;
	
	@Override
	public List<AreaDTO> getAll() {
		List<AreaDTO> Areas = new ArrayList<AreaDTO>();
		List<Area> entityList = areaDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Area Area : entityList) {
				Areas.add(AreaUtil.getDtoFromEntity(Area));
			}
		}
		return Areas;
	}

	@Override
	public List<AreaDTO> getAllFilter(Map<String, Object> filter) {
		List<AreaDTO> Areas = new ArrayList<AreaDTO>();
		List<Area> entityList = areaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Area Area : entityList) {
				Areas.add(AreaUtil.getDtoFromEntity(Area));
			}
		}
		return Areas;
	}
	
	@Override
	public List<AreaArchivoPruebaDTO> findAreaByArchivoPrueba(ArchivoPruebaDTO dto) {
		List<AreaArchivoPruebaDTO> dtoList = new ArrayList<AreaArchivoPruebaDTO>();
		List<AreaArchivoPrueba> entityList = this.areaDAO.findAreaByArchivoPrueba(ArchivoPruebaUtil.getEntityFromDto(dto));
		
		if(entityList!= null && entityList.size() > 0) {
			for(AreaArchivoPrueba entity : entityList) {
				dtoList.add(AreaArchivoPruebaUtil.getDtoFromEntity(entity));
			}
		}
		
		return dtoList;
	}
	
	@Override
	public List<AreaDTO> getNotAssignedArea(String ids) {
		List<AreaDTO> dtoList = new ArrayList<AreaDTO>();
		List<Area> entityList = this.areaDAO.getNotAssignedArea(ids);
		if(entityList!=null && entityList.size() > 0) {
			for(Area entity: entityList) {
				dtoList.add(AreaUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	
	@Override
	public void createAreaArchivoPrueba(AreaArchivoPruebaDTO dto) {
		areaDAO.createAreaArchivoPrueba(AreaArchivoPruebaUtil.getEntityFromDto(dto));
	}
	
	@Override
	public void deleteAreaArchivoPrueba(AreaArchivoPruebaDTO dto) {
		areaDAO.deleteAreaArchivoPrueba(AreaArchivoPruebaUtil.getEntityFromDto(dto));
	}
	
	@Override
	public Area create(AreaDTO dto) {
		return areaDAO.create(AreaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(AreaDTO dto) {
		areaDAO.delete(AreaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(AreaDTO dto) {
		areaDAO.update(AreaUtil.getEntityFromDto(dto));
	}

	public AreaDAO getAreaDAO() {
		return areaDAO;
	}

	public void setAreaDAO(AreaDAO AreaDAO) {
		this.areaDAO = AreaDAO;
	}
}
