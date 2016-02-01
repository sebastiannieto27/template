package co.com.core.services;

import java.util.List;

import co.com.core.dto.PageDTO;


public interface IPageService {

	public List<PageDTO> getAll(); 
	
	public void createPage(PageDTO pageDto);
	
	public void delete(co.com.core.dto.PageDTO pageDto);
	
	public void update(PageDTO pageDto);
	
	public PageDTO getPageByURL(String url);
}
