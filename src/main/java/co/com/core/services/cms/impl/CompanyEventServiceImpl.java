package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.BrandUtil;
import co.com.core.commons.converter.cms.CompanyEventUtil;
import co.com.core.dao.cms.CompanyEventDAO;
import co.com.core.domain.cms.Brand;
import co.com.core.domain.cms.CompanyEvent;
import co.com.core.dto.cms.BrandDTO;
import co.com.core.dto.cms.CompanyEventDTO;
import co.com.core.services.cms.ICompanyEventService;

public class CompanyEventServiceImpl implements ICompanyEventService {

	private static final Logger logger = Logger.getLogger(CompanyEventServiceImpl.class);
	CompanyEventDAO companyEventDAO;
	
	@Override
	public List<CompanyEventDTO> getAll() {
		List<CompanyEventDTO> CompanyEvents = new ArrayList<CompanyEventDTO>();
		List<CompanyEvent> entityList = companyEventDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(CompanyEvent CompanyEvent : entityList) {
				CompanyEvents.add(CompanyEventUtil.getDtoFromEntity(CompanyEvent));
			}
		}
		return CompanyEvents;
	}

	@Override
	public List<CompanyEventDTO> getAllFilter(Map<String, Object> filter) {
		List<CompanyEventDTO> events = new ArrayList<CompanyEventDTO>();
		List<CompanyEvent> entityList = companyEventDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(CompanyEvent event : entityList) {
				events.add(CompanyEventUtil.getDtoFromEntity(event));
			}
		}
		return events;
	}
	
	@Override
	public void create(CompanyEventDTO dto) {
		companyEventDAO.create(CompanyEventUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(CompanyEventDTO dto) {
		companyEventDAO.delete(CompanyEventUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(CompanyEventDTO dto) {
		companyEventDAO.update(CompanyEventUtil.getEntityFromDto(dto));
	}

	public CompanyEventDAO getCompanyEventDAO() {
		return companyEventDAO;
	}

	public void setCompanyEventDAO(CompanyEventDAO CompanyEventDAO) {
		this.companyEventDAO = CompanyEventDAO;
	}
}
