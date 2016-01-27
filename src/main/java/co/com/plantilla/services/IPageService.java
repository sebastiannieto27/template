package co.com.plantilla.services;

import java.util.List;

import co.com.plantilla.dto.PageDTO;


public interface IPageService {

	public List<PageDTO> getAll(); 
	
	public void createPage(PageDTO pageDto);
	
	public void delete(co.com.plantilla.dto.PageDTO pageDto);
	
	public void update(PageDTO pageDto);
}
