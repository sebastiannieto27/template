package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.dto.financial.account.BillingDTO;

public interface IBillingService {

	public List<BillingDTO> getAll(); 

	public List<BillingDTO> getAllFilter(Map<String, Object> filter); 

}
