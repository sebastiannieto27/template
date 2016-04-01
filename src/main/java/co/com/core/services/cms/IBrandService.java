package co.com.core.services.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.Brand;
import co.com.core.dto.cms.BrandDTO;


public interface IBrandService {

	public List<BrandDTO> getAll(); 

	public List<BrandDTO> getAllFilter(Map<String, Object> filter); 
	
	public Brand create(BrandDTO dto);
	
	public void delete(BrandDTO dto);
	
	public void update(BrandDTO dto);
}
