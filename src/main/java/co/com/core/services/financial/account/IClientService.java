package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.Client;
import co.com.core.dto.financial.account.ClientDTO;

public interface IClientService {

	public List<ClientDTO> getAll(); 

	public List<ClientDTO> getAllFilter(Map<String, Object> filter); 
	
	public Client create(ClientDTO dto);
	
	public void delete(ClientDTO dto);
	
	public void update(ClientDTO dto);

}
