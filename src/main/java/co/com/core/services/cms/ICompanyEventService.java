package co.com.core.services.cms;

import java.util.List;
import java.util.Map;

import co.com.core.dto.cms.CompanyEventDTO;


public interface ICompanyEventService {

	public List<CompanyEventDTO> getAll(); 
	
	public List<CompanyEventDTO> getAllFilter(Map<String, Object> filter); 
	
	public void create(CompanyEventDTO dto);
	
	public void delete(CompanyEventDTO dto);
	
	public void update(CompanyEventDTO dto);
}
