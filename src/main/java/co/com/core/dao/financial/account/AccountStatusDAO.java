package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.AccountStatus;

public interface AccountStatusDAO {

	public List<AccountStatus> getAllFilter(Map<String, Object> filter);
	
	public List<AccountStatus> getAll();
	
}
