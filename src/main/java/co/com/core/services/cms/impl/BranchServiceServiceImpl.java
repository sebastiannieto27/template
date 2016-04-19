package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.BranchServiceUtil;
import co.com.core.commons.converter.cms.ServiceUtil;
import co.com.core.dao.cms.BranchServiceDAO;
import co.com.core.domain.cms.BranchService;
import co.com.core.domain.cms.Service;
import co.com.core.dto.cms.BranchServiceDTO;
import co.com.core.dto.cms.ServiceDTO;
import co.com.core.services.cms.IBranchServiceService;

public class BranchServiceServiceImpl implements IBranchServiceService {

	private static final Logger logger = Logger.getLogger(BranchServiceServiceImpl.class);
	BranchServiceDAO branchServiceDAO;
	
	@Override
	public List<BranchServiceDTO> getAll() {
		List<BranchServiceDTO> BranchServices = new ArrayList<BranchServiceDTO>();
		List<BranchService> entityList = branchServiceDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(BranchService BranchService : entityList) {
				BranchServices.add(BranchServiceUtil.getDtoFromEntity(BranchService));
			}
		}
		return BranchServices;
	}

	@Override
	public List<BranchServiceDTO> getAllFilter(Map<String, Object> filter) {
		List<BranchServiceDTO> dtoList = new ArrayList<BranchServiceDTO>();
		List<BranchService> entityList = branchServiceDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(BranchService entity : entityList) {
				dtoList.add(BranchServiceUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public void create(BranchServiceDTO dto) {
		branchServiceDAO.create(BranchServiceUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BranchServiceDTO dto) {
		branchServiceDAO.delete(BranchServiceUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BranchServiceDTO dto) {
		branchServiceDAO.update(BranchServiceUtil.getEntityFromDto(dto));
	}

	public BranchServiceDAO getBranchServiceDAO() {
		return branchServiceDAO;
	}

	public void setBranchServiceDAO(BranchServiceDAO BranchServiceDAO) {
		this.branchServiceDAO = BranchServiceDAO;
	}
}
