package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.BillHead;

public interface BillHeadDAO {

	public List<BillHead> getAllFilter(Map<String, Object> filter);
	
	public List<BillHead> getAll();
	
	public BillHead create(BillHead entity);
	
	public void delete(BillHead entity);
	
	public void update(BillHead entity);
}
