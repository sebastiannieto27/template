package co.com.core.services.cms;

import java.util.List;

import co.com.core.dto.cms.BrandTypeDTO;


public interface IBrandTypeService {

	public List<BrandTypeDTO> getAll(); 
	
	public void create(BrandTypeDTO dto);
	
	public void delete(BrandTypeDTO dto);
	
	public void update(BrandTypeDTO dto);
}
