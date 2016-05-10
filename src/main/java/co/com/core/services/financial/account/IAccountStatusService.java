package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.dto.financial.account.AccountStatusDTO;

public interface IAccountStatusService {

	public List<AccountStatusDTO> getAll(); 

	public List<AccountStatusDTO> getAllFilter(Map<String, Object> filter); 

}
