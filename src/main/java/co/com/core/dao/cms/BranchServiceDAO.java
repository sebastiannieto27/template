package co.com.core.dao.cms;

import java.util.List;

import co.com.core.domain.cms.BranchService;

public interface BranchServiceDAO {
	
	public List<BranchService> getAll();
	
	public void create(BranchService entity);
	
	public void delete(BranchService entity);
	
	public void update(BranchService entity);
	
}
