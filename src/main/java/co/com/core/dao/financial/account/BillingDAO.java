package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.Billing;

public interface BillingDAO {

	public List<Billing> getAllFilter(Map<String, Object> filter);
	
	public List<Billing> getAll();
	
}
