package co.com.core.dao.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.News;

public interface NewsDAO {
	
	public List<News> getAll();
	
	public List<News> getAllFilter(Map<String, Object> filter);
	
	public void create(News entity);
	
	public void delete(News entity);
	
	public void update(News entity);
	
}
