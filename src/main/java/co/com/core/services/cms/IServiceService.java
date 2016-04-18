package co.com.core.services.cms;

import java.util.List;
import java.util.Map;

import co.com.core.dto.cms.ServiceDTO;


public interface IServiceService {

	public List<ServiceDTO> getAll(); 
	
	public List<ServiceDTO> getAllFilter(Map<String, Object> filter);
	
	public void create(ServiceDTO dto);
	
	public void delete(ServiceDTO dto);
	
	public void update(ServiceDTO dto);
}
