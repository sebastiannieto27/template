package co.com.core.services.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.Branch;
import co.com.core.dto.cms.BranchDTO;


public interface IBranchService {

	public List<BranchDTO> getAll(); 

	public List<BranchDTO> getAllFilter(Map<String, Object> filter); 
	
	public Branch create(BranchDTO dto);
	
	public void delete(BranchDTO dto);
	
	public void update(BranchDTO dto);
}
