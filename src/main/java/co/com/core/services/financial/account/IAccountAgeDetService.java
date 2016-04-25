package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.AccountAgeDet;
import co.com.core.dto.financial.account.AccountAgeDetDTO;

public interface IAccountAgeDetService {

	public List<AccountAgeDetDTO> getAll(); 

	public List<AccountAgeDetDTO> getAllFilter(Map<String, Object> filter); 
	
	public AccountAgeDet create(AccountAgeDetDTO dto);
	
	public void delete(AccountAgeDetDTO dto);
	
	public void update(AccountAgeDetDTO dto);

}
