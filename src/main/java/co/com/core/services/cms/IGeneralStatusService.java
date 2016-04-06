package co.com.core.services.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.GeneralStatus;
import co.com.core.dto.cms.GeneralStatusDTO;


public interface IGeneralStatusService {

	public List<GeneralStatusDTO> getAll(); 

	public List<GeneralStatusDTO> getAllFilter(Map<String, Object> filter); 
	
	public GeneralStatus create(GeneralStatusDTO dto);
	
	public void delete(GeneralStatusDTO dto);
	
	public void update(GeneralStatusDTO dto);
}
