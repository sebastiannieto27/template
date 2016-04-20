package co.com.core.dao.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.NewsType;

public interface NewsTypeDAO {
	
	public List<NewsType> getAll();
	
	public List<NewsType> getAllFilter(Map<String, Object> filter);
	
	public void create(NewsType entity);
	
	public void delete(NewsType entity);
	
	public void update(NewsType entity);
	
}
