package co.com.core.services.cms;

import java.util.List;
import java.util.Map;

import co.com.core.dto.cms.BranchServiceDTO;


public interface IBranchServiceService {

	public List<BranchServiceDTO> getAll(); 
	
	public List<BranchServiceDTO> getAllFilter(Map<String, Object> filter);
	
	public void create(BranchServiceDTO dto);
	
	public void delete(BranchServiceDTO dto);
	
	public void update(BranchServiceDTO dto);
}
