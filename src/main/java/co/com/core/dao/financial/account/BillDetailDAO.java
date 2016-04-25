package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.BillDetail;

public interface BillDetailDAO {

	public List<BillDetail> getAllFilter(Map<String, Object> filter);
	
	public List<BillDetail> getAll();
	
	public BillDetail create(BillDetail entity);
	
	public void delete(BillDetail entity);
	
	public void update(BillDetail entity);
}
