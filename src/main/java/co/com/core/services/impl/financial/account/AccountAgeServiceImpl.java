package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.AccountAgeUtil;
import co.com.core.dao.financial.account.AccountAgeDAO;
import co.com.core.domain.financial.account.AccountAge;
import co.com.core.dto.financial.account.AccountAgeDTO;
import co.com.core.services.financial.account.IAccountAgeService;

public class AccountAgeServiceImpl implements IAccountAgeService {

	private static final Logger logger = Logger.getLogger(AccountAgeServiceImpl.class);
	AccountAgeDAO accountAgeDAO;
	
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
}
