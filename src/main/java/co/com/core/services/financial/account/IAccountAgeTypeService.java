package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.AccountAgeType;
import co.com.core.dto.financial.account.AccountAgeTypeDTO;

public interface IAccountAgeTypeService {

	public List<AccountAgeTypeDTO> getAll(); 

	public List<AccountAgeTypeDTO> getAllFilter(Map<String, Object> filter); 
	
	public AccountAgeType create(AccountAgeTypeDTO dto);
	
	public void delete(AccountAgeTypeDTO dto);
	
	public void update(AccountAgeTypeDTO dto);

}
