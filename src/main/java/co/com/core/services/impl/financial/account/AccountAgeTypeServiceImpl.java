package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.AccountAgeTypeUtil;
import co.com.core.dao.financial.account.AccountAgeTypeDAO;
import co.com.core.domain.financial.account.AccountAgeType;
import co.com.core.dto.financial.account.AccountAgeTypeDTO;
import co.com.core.services.financial.account.IAccountAgeTypeService;

public class AccountAgeTypeServiceImpl implements IAccountAgeTypeService {
	private static final Logger logger = Logger.getLogger(AccountAgeTypeServiceImpl.class);
	AccountAgeTypeDAO accountAgeTypeDAO;
	
	@Override
	public List<AccountAgeTypeDTO> getAll() {
		List<AccountAgeTypeDTO> AccountAgeTypes = new ArrayList<AccountAgeTypeDTO>();
		List<AccountAgeType> entityList = accountAgeTypeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(AccountAgeType entity : entityList) {
				AccountAgeTypes.add(AccountAgeTypeUtil.getDtoFromEntity(entity));
			}
		}
		return AccountAgeTypes;
	}

	@Override
	public List<AccountAgeTypeDTO> getAllFilter(Map<String, Object> filter) {
		List<AccountAgeTypeDTO> dtoList = new ArrayList<AccountAgeTypeDTO>();
		List<AccountAgeType> entityList = accountAgeTypeDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(AccountAgeType entity : entityList) {
				dtoList.add(AccountAgeTypeUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public AccountAgeType create(AccountAgeTypeDTO dto) {
		return accountAgeTypeDAO.create(AccountAgeTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(AccountAgeTypeDTO dto) {
		accountAgeTypeDAO.delete(AccountAgeTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(AccountAgeTypeDTO dto) {
		accountAgeTypeDAO.update(AccountAgeTypeUtil.getEntityFromDto(dto));
	}

	public AccountAgeTypeDAO getAccountAgeTypeDAO() {
		return accountAgeTypeDAO;
	}

	public void setAccountAgeTypeDAO(AccountAgeTypeDAO AccountAgeTypeDAO) {
		this.accountAgeTypeDAO = AccountAgeTypeDAO;
	}
}
