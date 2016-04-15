package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.BranchUtil;
import co.com.core.dao.cms.BranchDAO;
import co.com.core.domain.cms.Branch;
import co.com.core.dto.cms.BranchDTO;
import co.com.core.services.cms.IBranchService;

public class BranchServiceImpl implements IBranchService {

	private static final Logger logger = Logger.getLogger(BranchServiceImpl.class);
	BranchDAO branchDAO;
	
	@Override
	public List<BranchDTO> getAll() {
		List<BranchDTO> Branchs = new ArrayList<BranchDTO>();
		List<Branch> entityList = branchDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Branch Branch : entityList) {
				Branchs.add(BranchUtil.getDtoFromEntity(Branch));
			}
		}
		return Branchs;
	}

	@Override
	public List<BranchDTO> getAllFilter(Map<String, Object> filter) {
		List<BranchDTO> Branchs = new ArrayList<BranchDTO>();
		List<Branch> entityList = branchDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Branch Branch : entityList) {
				Branchs.add(BranchUtil.getDtoFromEntity(Branch));
			}
		}
		return Branchs;
	}
	
	@Override
	public Branch create(BranchDTO dto) {
		return branchDAO.create(BranchUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BranchDTO dto) {
		branchDAO.delete(BranchUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BranchDTO dto) {
		branchDAO.update(BranchUtil.getEntityFromDto(dto));
	}

	public BranchDAO getBranchDAO() {
		return branchDAO;
	}

	public void setBranchDAO(BranchDAO BranchDAO) {
		this.branchDAO = BranchDAO;
	}
}
