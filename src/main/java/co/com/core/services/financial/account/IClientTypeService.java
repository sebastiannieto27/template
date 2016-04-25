package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.ClientType;
import co.com.core.dto.financial.account.ClientTypeDTO;

public interface IClientTypeService {

	public List<ClientTypeDTO> getAll(); 

	public List<ClientTypeDTO> getAllFilter(Map<String, Object> filter); 
	
	public ClientType create(ClientTypeDTO dto);
	
	public void delete(ClientTypeDTO dto);
	
	public void update(ClientTypeDTO dto);

}
