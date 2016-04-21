package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.BranchClient;
import co.com.core.dto.financial.account.BranchClientDTO;

public interface IBranchClientService {

	public List<BranchClientDTO> getAll(); 

	public List<BranchClientDTO> getAllFilter(Map<String, Object> filter); 
	
	public BranchClient create(BranchClientDTO dto);
	
	public void delete(BranchClientDTO dto);
	
	public void update(BranchClientDTO dto);

}
