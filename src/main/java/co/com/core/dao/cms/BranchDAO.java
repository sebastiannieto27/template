package co.com.core.dao.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.Branch;;

public interface BranchDAO {
	
	public List<Branch> getAll();
	
	public List<Branch> getAllFilter(Map<String, Object> filter);
	
	public Branch create(Branch entity);
	
	public void delete(Branch entity);
	
	public void update(Branch entity);
	
}
