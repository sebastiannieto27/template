package co.com.core.services.cms;

import java.util.List;

import co.com.core.dto.cms.ServiceDTO;


public interface IServiceService {

	public List<ServiceDTO> getAll(); 
	
	public void create(ServiceDTO dto);
	
	public void delete(ServiceDTO dto);
	
	public void update(ServiceDTO dto);
}
