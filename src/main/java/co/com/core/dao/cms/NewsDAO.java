package co.com.core.dao.cms;

import java.util.List;

import co.com.core.domain.cms.News;

public interface NewsDAO {
	
	public List<News> getAll();
	
	public void create(News entity);
	
	public void delete(News entity);
	
	public void update(News entity);
	
}
