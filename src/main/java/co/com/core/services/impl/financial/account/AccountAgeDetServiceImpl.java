package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.AccountAgeDetUtil;
import co.com.core.dao.financial.account.AccountAgeDetDAO;
import co.com.core.domain.financial.account.AccountAgeDet;
import co.com.core.dto.financial.account.AccountAgeDetDTO;
import co.com.core.services.financial.account.IAccountAgeDetService;

public class AccountAgeDetServiceImpl implements IAccountAgeDetService {
	private static final Logger logger = Logger.getLogger(AccountAgeDetServiceImpl.class);
	AccountAgeDetDAO accountAgeDetDAO;
	
	@Override
	public List<AccountAgeDetDTO> getAll() {
		List<AccountAgeDetDTO> AccountAgeDets = new ArrayList<AccountAgeDetDTO>();
		List<AccountAgeDet> entityList = accountAgeDetDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(AccountAgeDet entity : entityList) {
				AccountAgeDets.add(AccountAgeDetUtil.getDtoFromEntity(entity));
			}
		}
		return AccountAgeDets;
	}

	@Override
	public List<AccountAgeDetDTO> getAllFilter(Map<String, Object> filter) {
		List<AccountAgeDetDTO> dtoList = new ArrayList<AccountAgeDetDTO>();
		List<AccountAgeDet> entityList = accountAgeDetDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(AccountAgeDet entity : entityList) {
				dtoList.add(AccountAgeDetUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public AccountAgeDet create(AccountAgeDetDTO dto) {
		return accountAgeDetDAO.create(AccountAgeDetUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(AccountAgeDetDTO dto) {
		accountAgeDetDAO.delete(AccountAgeDetUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(AccountAgeDetDTO dto) {
		accountAgeDetDAO.update(AccountAgeDetUtil.getEntityFromDto(dto));
	}

	public AccountAgeDetDAO getAccountAgeDetDAO() {
		return accountAgeDetDAO;
	}

	public void setAccountAgeDetDAO(AccountAgeDetDAO AccountAgeDetDAO) {
		this.accountAgeDetDAO = AccountAgeDetDAO;
	}
}
