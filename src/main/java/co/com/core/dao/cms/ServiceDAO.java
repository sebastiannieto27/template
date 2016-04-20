package co.com.core.dao.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.Service;

public interface ServiceDAO {
	
	public List<Service> getAll();
	
	public List<Service> getAllFilter(Map<String, Object> filter);
	
	public void create(Service entity);
	
	public void delete(Service entity);
	
	public void update(Service entity);
	
}
