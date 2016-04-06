package co.com.core.services.cms;

import java.util.List;

import co.com.core.dto.cms.NewsTypeDTO;


public interface INewsTypeService {

	public List<NewsTypeDTO> getAll(); 
	
	public void create(NewsTypeDTO dto);
	
	public void delete(NewsTypeDTO dto);
	
	public void update(NewsTypeDTO dto);
}
