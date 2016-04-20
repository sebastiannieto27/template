package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.BranchTypeUtil;
import co.com.core.commons.converter.cms.BranchUtil;
import co.com.core.dao.cms.BranchTypeDAO;
import co.com.core.domain.cms.Branch;
import co.com.core.domain.cms.BranchType;
import co.com.core.dto.cms.BranchDTO;
import co.com.core.dto.cms.BranchTypeDTO;
import co.com.core.services.cms.IBranchTypeService;

public class BranchTypeServiceImpl implements IBranchTypeService {

	private static final Logger logger = Logger.getLogger(BranchTypeServiceImpl.class);
	BranchTypeDAO branchTypeDAO;
	
	@Override
	public List<BranchTypeDTO> getAll() {
		List<BranchTypeDTO> BranchTypes = new ArrayList<BranchTypeDTO>();
		List<BranchType> entityList = branchTypeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(BranchType BranchType : entityList) {
				BranchTypes.add(BranchTypeUtil.getDtoFromEntity(BranchType));
			}
		}
		return BranchTypes;
	}

	@Override
	public List<BranchTypeDTO> getAllFilter(Map<String, Object> filter) {
		List<BranchTypeDTO> dtoList = new ArrayList<BranchTypeDTO>();
		List<BranchType> entityList = branchTypeDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(BranchType entity : entityList) {
				dtoList.add(BranchTypeUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public void create(BranchTypeDTO dto) {
		branchTypeDAO.create(BranchTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BranchTypeDTO dto) {
		branchTypeDAO.delete(BranchTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BranchTypeDTO dto) {
		branchTypeDAO.update(BranchTypeUtil.getEntityFromDto(dto));
	}

	public BranchTypeDAO getBranchTypeDAO() {
		return branchTypeDAO;
	}

	public void setBranchTypeDAO(BranchTypeDAO BranchTypeDAO) {
		this.branchTypeDAO = BranchTypeDAO;
	}
}
