package co.com.core.dao.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.Branch;
import co.com.core.domain.cms.BranchType;

public interface BranchTypeDAO {
	
	public List<BranchType> getAll();
	
	public List<BranchType> getAllFilter(Map<String, Object> filter);
	
	public void create(BranchType entity);
	
	public void delete(BranchType entity);
	
	public void update(BranchType entity);
	
}
