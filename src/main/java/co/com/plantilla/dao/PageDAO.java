package co.com.plantilla.dao;

import java.util.List;

import co.com.plantilla.domain.Page;


public interface PageDAO {

	public List<Page> getAll();
	
	public void createPage(Page Page);
	
	public void delete(Page Page);
	
	public void update(Page Page);
}
