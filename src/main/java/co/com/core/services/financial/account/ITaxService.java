package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.Tax;
import co.com.core.dto.financial.account.TaxDTO;

public interface ITaxService {

	public List<TaxDTO> getAll(); 

	public List<TaxDTO> getAllFilter(Map<String, Object> filter); 
	
	public Tax create(TaxDTO dto);
	
	public void delete(TaxDTO dto);
	
	public void update(TaxDTO dto);

}
