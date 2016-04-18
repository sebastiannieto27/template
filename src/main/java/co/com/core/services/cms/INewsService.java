package co.com.core.services.cms;

import java.util.List;
import java.util.Map;

import co.com.core.dto.cms.NewsDTO;


public interface INewsService {

	public List<NewsDTO> getAll(); 
	
	public List<NewsDTO> getAllFilter(Map<String, Object> filter); 
	
	public void create(NewsDTO dto);
	
	public void delete(NewsDTO dto);
	
	public void update(NewsDTO dto);
}
