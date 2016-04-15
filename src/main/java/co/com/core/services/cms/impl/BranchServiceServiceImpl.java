package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.BranchServiceUtil;
import co.com.core.dao.cms.BranchServiceDAO;
import co.com.core.domain.cms.BranchService;
import co.com.core.dto.cms.BranchServiceDTO;
import co.com.core.services.cms.IBranchServiceService;

public class BranchServiceServiceImpl implements IBranchServiceService {

	private static final Logger logger = Logger.getLogger(BranchServiceServiceImpl.class);
	BranchServiceDAO BranchServiceDAO;
	
	@Override
	public List<BranchServiceDTO> getAll() {
		List<BranchServiceDTO> BranchServices = new ArrayList<BranchServiceDTO>();
		List<BranchService> entityList = BranchServiceDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(BranchService BranchService : entityList) {
				BranchServices.add(BranchServiceUtil.getDtoFromEntity(BranchService));
			}
		}
		return BranchServices;
	}

	@Override
	public void create(BranchServiceDTO dto) {
		BranchServiceDAO.create(BranchServiceUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BranchServiceDTO dto) {
		BranchServiceDAO.delete(BranchServiceUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BranchServiceDTO dto) {
		BranchServiceDAO.update(BranchServiceUtil.getEntityFromDto(dto));
	}

	public BranchServiceDAO getBranchServiceDAO() {
		return BranchServiceDAO;
	}

	public void setBranchServiceDAO(BranchServiceDAO BranchServiceDAO) {
		this.BranchServiceDAO = BranchServiceDAO;
	}
}
