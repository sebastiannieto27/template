package co.com.core.dao.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.Brand;

public interface BrandDAO {
	
	public List<Brand> getAll();
	
	public List<Brand> getAllFilter(Map<String, Object> filter);
	
	public Brand create(Brand entity);
	
	public void delete(Brand entity);
	
	public void update(Brand entity);
	
}
