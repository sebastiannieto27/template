package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.AccountAgeDet;

public interface AccountAgeDetDAO {

	public List<AccountAgeDet> getAllFilter(Map<String, Object> filter);
	
	public List<AccountAgeDet> getAll();
	
	public AccountAgeDet create(AccountAgeDet entity);
	
	public void delete(AccountAgeDet entity);
	
	public void update(AccountAgeDet entity);
}
