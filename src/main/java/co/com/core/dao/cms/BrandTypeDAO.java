package co.com.core.dao.cms;

import java.util.List;

import co.com.core.domain.cms.BrandType;

public interface BrandTypeDAO {
	
	public List<BrandType> getAll();
	
	public void create(BrandType entity);
	
	public void delete(BrandType entity);
	
	public void update(BrandType entity);
	
}
