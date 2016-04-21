package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.BranchClientUtil;
import co.com.core.dao.financial.account.BranchClientDAO;
import co.com.core.domain.financial.account.BranchClient;
import co.com.core.dto.financial.account.BranchClientDTO;
import co.com.core.services.financial.account.IBranchClientService;

public class BranchClientServiceImpl implements IBranchClientService {
	private static final Logger logger = Logger.getLogger(BranchClientServiceImpl.class);
	BranchClientDAO branchClientDAO;
	
	@Override
	public List<BranchClientDTO> getAll() {
		List<BranchClientDTO> BranchClients = new ArrayList<BranchClientDTO>();
		List<BranchClient> entityList = branchClientDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(BranchClient BranchClient : entityList) {
				BranchClients.add(BranchClientUtil.getDtoFromEntity(BranchClient));
			}
		}
		return BranchClients;
	}

	@Override
	public List<BranchClientDTO> getAllFilter(Map<String, Object> filter) {
		List<BranchClientDTO> dtoList = new ArrayList<BranchClientDTO>();
		List<BranchClient> entityList = branchClientDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(BranchClient entity : entityList) {
				dtoList.add(BranchClientUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public BranchClient create(BranchClientDTO dto) {
		return branchClientDAO.create(BranchClientUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BranchClientDTO dto) {
		branchClientDAO.delete(BranchClientUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BranchClientDTO dto) {
		branchClientDAO.update(BranchClientUtil.getEntityFromDto(dto));
	}

	public BranchClientDAO getBranchClientDAO() {
		return branchClientDAO;
	}

	public void setBranchClientDAO(BranchClientDAO BranchClientDAO) {
		this.branchClientDAO = BranchClientDAO;
	}
}
