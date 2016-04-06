package co.com.core.services.cms;

import java.util.List;

import co.com.core.dto.cms.NewsDTO;


public interface INewsService {

	public List<NewsDTO> getAll(); 
	
	public void create(NewsDTO dto);
	
	public void delete(NewsDTO dto);
	
	public void update(NewsDTO dto);
}
