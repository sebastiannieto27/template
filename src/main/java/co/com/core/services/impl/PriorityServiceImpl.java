package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.PriorityUtil;
import co.com.core.commons.converter.RoleUtil;
import co.com.core.dao.PriorityDAO;
import co.com.core.domain.Priority;
import co.com.core.dto.PriorityDTO;
import co.com.core.dto.RoleDTO;
import co.com.core.services.IPriorityService;

public class PriorityServiceImpl implements IPriorityService {

	private static final Logger logger = Logger.getLogger(PriorityServiceImpl.class);
	PriorityDAO priorityDAO;
	
	@Override
	public List<PriorityDTO> getAll() {
		List<PriorityDTO> Prioritys = new ArrayList<PriorityDTO>();
		List<Priority> entityList = priorityDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Priority Priority : entityList) {
				Prioritys.add(PriorityUtil.getDtoFromEntity(Priority));
			}
		}
		return Prioritys;
	}

	@Override
	public void create(PriorityDTO dto) {
		priorityDAO.create(PriorityUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(PriorityDTO dto) {
		priorityDAO.delete(PriorityUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(PriorityDTO dto) {
		priorityDAO.update(PriorityUtil.getEntityFromDto(dto));
	}

	public PriorityDAO getPriorityDAO() {
		return priorityDAO;
	}

	public void setPriorityDAO(PriorityDAO PriorityDAO) {
		this.priorityDAO = PriorityDAO;
	}

	
}
