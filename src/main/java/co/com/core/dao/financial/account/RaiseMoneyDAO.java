package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.RaiseMoney;

public interface RaiseMoneyDAO {

	public List<RaiseMoney> getAllFilter(Map<String, Object> filter);
	
	public List<RaiseMoney> getAll();
	
	public RaiseMoney create(RaiseMoney entity);
	
	public void delete(RaiseMoney entity);
	
	public void update(RaiseMoney entity);
}
