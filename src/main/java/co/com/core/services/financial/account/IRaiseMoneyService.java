package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.RaiseMoney;
import co.com.core.dto.financial.account.RaiseMoneyDTO;

public interface IRaiseMoneyService {

	public List<RaiseMoneyDTO> getAll(); 

	public List<RaiseMoneyDTO> getAllFilter(Map<String, Object> filter); 
	
	public RaiseMoney create(RaiseMoneyDTO dto);
	
	public void delete(RaiseMoneyDTO dto);
	
	public void update(RaiseMoneyDTO dto);

}
