package co.com.core.dao.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.BranchService;

public interface BranchServiceDAO {
	
	public List<BranchService> getAll();
	
	public List<BranchService> getAllFilter(Map<String, Object> filter);
	
	public void create(BranchService entity);
	
	public void delete(BranchService entity);
	
	public void update(BranchService entity);
	
}
