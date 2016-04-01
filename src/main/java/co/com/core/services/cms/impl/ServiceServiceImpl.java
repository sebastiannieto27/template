package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.ServiceUtil;
import co.com.core.dao.cms.ServiceDAO;
import co.com.core.domain.cms.Service;
import co.com.core.dto.cms.ServiceDTO;
import co.com.core.services.cms.IServiceService;

public class ServiceServiceImpl implements IServiceService {

	private static final Logger logger = Logger.getLogger(ServiceServiceImpl.class);
	ServiceDAO serviceDAO;
	
	@Override
	public List<ServiceDTO> getAll() {
		List<ServiceDTO> Services = new ArrayList<ServiceDTO>();
		List<Service> entityList = serviceDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Service Service : entityList) {
				Services.add(ServiceUtil.getDtoFromEntity(Service));
			}
		}
		return Services;
	}

	@Override
	public void create(ServiceDTO dto) {
		serviceDAO.create(ServiceUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(ServiceDTO dto) {
		serviceDAO.delete(ServiceUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(ServiceDTO dto) {
		serviceDAO.update(ServiceUtil.getEntityFromDto(dto));
	}

	public ServiceDAO getServiceDAO() {
		return serviceDAO;
	}

	public void setServiceDAO(ServiceDAO ServiceDAO) {
		this.serviceDAO = ServiceDAO;
	}
}
