package co.com.core.services.cms;

import java.util.List;

import co.com.core.dto.cms.CompanyEventDTO;


public interface ICompanyEventService {

	public List<CompanyEventDTO> getAll(); 
	
	public void create(CompanyEventDTO dto);
	
	public void delete(CompanyEventDTO dto);
	
	public void update(CompanyEventDTO dto);
}
