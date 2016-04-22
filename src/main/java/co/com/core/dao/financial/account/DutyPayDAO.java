package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.DutyPay;

public interface DutyPayDAO {

	public List<DutyPay> getAllFilter(Map<String, Object> filter);
	
	public List<DutyPay> getAll();
	
	public DutyPay create(DutyPay entity);
	
	public void delete(DutyPay entity);
	
	public void update(DutyPay entity);
}
