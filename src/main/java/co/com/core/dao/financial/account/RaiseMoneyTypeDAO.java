package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.RaiseMoneyType;

public interface RaiseMoneyTypeDAO {

	public List<RaiseMoneyType> getAllFilter(Map<String, Object> filter);
	
	public List<RaiseMoneyType> getAll();
	
	public RaiseMoneyType create(RaiseMoneyType entity);
	
	public void delete(RaiseMoneyType entity);
	
	public void update(RaiseMoneyType entity);
}
