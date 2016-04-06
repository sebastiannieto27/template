package co.com.core.dao.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.CompanyEvent;

public interface CompanyEventDAO {
	
	public List<CompanyEvent> getAll();
	
	public List<CompanyEvent> getAllFilter(Map<String, Object> filter);
	
	public void create(CompanyEvent entity);
	
	public void delete(CompanyEvent entity);
	
	public void update(CompanyEvent entity);
	
}
