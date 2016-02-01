package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Page;


public interface PageDAO {

	public List<Page> getAll();
	
	public void createPage(Page Page);
	
	public void delete(Page Page);
	
	public void update(Page Page);
	
	public List<Page> getPageByURL(String url);
}
