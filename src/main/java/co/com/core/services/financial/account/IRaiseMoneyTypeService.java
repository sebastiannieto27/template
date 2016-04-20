package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.RaiseMoneyType;
import co.com.core.dto.financial.account.RaiseMoneyTypeDTO;

public interface IRaiseMoneyTypeService {

	public List<RaiseMoneyTypeDTO> getAll(); 

	public List<RaiseMoneyTypeDTO> getAllFilter(Map<String, Object> filter); 
	
	public RaiseMoneyType create(RaiseMoneyTypeDTO dto);
	
	public void delete(RaiseMoneyTypeDTO dto);
	
	public void update(RaiseMoneyTypeDTO dto);

}
