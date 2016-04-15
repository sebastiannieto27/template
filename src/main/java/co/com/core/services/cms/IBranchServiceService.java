package co.com.core.services.cms;

import java.util.List;

import co.com.core.dto.cms.BranchServiceDTO;


public interface IBranchServiceService {

	public List<BranchServiceDTO> getAll(); 
	
	public void create(BranchServiceDTO dto);
	
	public void delete(BranchServiceDTO dto);
	
	public void update(BranchServiceDTO dto);
}
