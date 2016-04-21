package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.BranchClient;

public interface BranchClientDAO {

	public List<BranchClient> getAllFilter(Map<String, Object> filter);
	
	public List<BranchClient> getAll();
	
	public BranchClient create(BranchClient entity);
	
	public void delete(BranchClient entity);
	
	public void update(BranchClient entity);
}
