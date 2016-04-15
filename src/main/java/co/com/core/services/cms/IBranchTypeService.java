package co.com.core.services.cms;

import java.util.List;
import java.util.Map;

import co.com.core.dto.cms.BranchTypeDTO;


public interface IBranchTypeService {

	public List<BranchTypeDTO> getAll(); 
	
	public List<BranchTypeDTO> getAllFilter(Map<String, Object> filter);
	
	public void create(BranchTypeDTO dto);
	
	public void delete(BranchTypeDTO dto);
	
	public void update(BranchTypeDTO dto);
}
