package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.AccountAgeType;

public interface AccountAgeTypeDAO {

	public List<AccountAgeType> getAllFilter(Map<String, Object> filter);
	
	public List<AccountAgeType> getAll();
	
	public AccountAgeType create(AccountAgeType entity);
	
	public void delete(AccountAgeType entity);
	
	public void update(AccountAgeType entity);
}
