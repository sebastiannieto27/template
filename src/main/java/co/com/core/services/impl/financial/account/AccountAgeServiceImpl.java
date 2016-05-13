package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.AccountAgeUtil;
import co.com.core.dao.financial.account.AccountAgeDAO;
import co.com.core.dao.financial.account.AccountAgeOneDAO;
import co.com.core.domain.financial.account.AccountAge;
import co.com.core.domain.financial.account.views.AccountAgeOne;
import co.com.core.dto.financial.account.AccountAgeDTO;
import co.com.core.services.financial.account.IAccountAgeService;

public class AccountAgeServiceImpl implements IAccountAgeService {

	private static final Logger logger = Logger.getLogger(AccountAgeServiceImpl.class);
	AccountAgeDAO accountAgeDAO;
	AccountAgeOneDAO accountAgeOneDAO;
	
	@Override
	public List<AccountAgeDTO> getAll() {
		List<AccountAgeDTO> ageList = new ArrayList<AccountAgeDTO>();
		List<AccountAge> entityList = accountAgeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(AccountAge AccountAge : entityList) {
				ageList.add(AccountAgeUtil.getDtoFromEntity(AccountAge));
			}
		}
		return ageList;
	}

	public void proofConcept() {
		List<AccountAgeOne> entityList = accountAgeOneDAO.getAll();
		
		if(entityList!=null && entityList.size() > 0){
			for(AccountAgeOne item : entityList) {
				logger.info(item);
			}
		}
	}
	
	public AccountAgeDAO getAccountAgeDAO() {
		return accountAgeDAO;
	}

	public void setAccountAgeDAO(AccountAgeDAO accountAgeDAO) {
		this.accountAgeDAO = accountAgeDAO;
	}

	public AccountAgeOneDAO getAccountAgeOneDAO() {
		return accountAgeOneDAO;
	}

	public void setAccountAgeOneDAO(AccountAgeOneDAO accountAgeOneDAO) {
		this.accountAgeOneDAO = accountAgeOneDAO;
	}
	
	
}
