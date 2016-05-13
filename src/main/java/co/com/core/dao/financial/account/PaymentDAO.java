package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.Payment;

public interface PaymentDAO {

	public List<Payment> getAllFilter(Map<String, Object> filter);
	
	public List<Payment> getAll();
	
}
