package co.com.core.dao.cms;

import java.util.List;

import co.com.core.domain.cms.CompanyEvent;

public interface CompanyEventDAO {
	
	public List<CompanyEvent> getAll();
	
	public void create(CompanyEvent entity);
	
	public void delete(CompanyEvent entity);
	
	public void update(CompanyEvent entity);
	
}
