package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.AreaUtil;
import co.com.core.dao.psaber.AreaDAO;
import co.com.core.domain.psaber.Area;
import co.com.core.dto.psaber.AreaDTO;
import co.com.core.services.psaber.IAreaService;

public class AreaServiceImpl implements IAreaService {

	private static final Logger logger = Logger.getLogger(AreaServiceImpl.class);
	AreaDAO AreaDAO;
	
	@Override
	public List<AreaDTO> getAll() {
		List<AreaDTO> Areas = new ArrayList<AreaDTO>();
		List<Area> entityList = AreaDAO.getAll();
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
		List<Area> entityList = AreaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Area Area : entityList) {
				Areas.add(AreaUtil.getDtoFromEntity(Area));
			}
		}
		return Areas;
	}
	
	@Override
	public Area create(AreaDTO dto) {
		return AreaDAO.create(AreaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(AreaDTO dto) {
		AreaDAO.delete(AreaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(AreaDTO dto) {
		AreaDAO.update(AreaUtil.getEntityFromDto(dto));
	}

	public AreaDAO getAreaDAO() {
		return AreaDAO;
	}

	public void setAreaDAO(AreaDAO AreaDAO) {
		this.AreaDAO = AreaDAO;
	}
}
