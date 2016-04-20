package co.com.core.services.cms;

import java.util.List;
import java.util.Map;

import co.com.core.dto.cms.NewsTypeDTO;


public interface INewsTypeService {

	public List<NewsTypeDTO> getAll(); 
	
	public List<NewsTypeDTO> getAllFilter(Map<String, Object> filter); 
	
	public void create(NewsTypeDTO dto);
	
	public void delete(NewsTypeDTO dto);
	
	public void update(NewsTypeDTO dto);
}
