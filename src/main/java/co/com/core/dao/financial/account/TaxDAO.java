package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.Brand;
import co.com.core.domain.financial.account.Tax;

public interface TaxDAO {

	public List<Tax> getAllFilter(Map<String, Object> filter);
	
	public List<Tax> getAll();
	
	public Tax create(Tax entity);
	
	public void delete(Tax entity);
	
	public void update(Tax entity);
}
