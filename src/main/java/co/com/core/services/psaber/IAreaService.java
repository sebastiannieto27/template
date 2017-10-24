package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Area;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.AreaArchivoPruebaDTO;
import co.com.core.dto.psaber.AreaDTO;


public interface IAreaService {

	public List<AreaDTO> getAll(); 

	public List<AreaDTO> getAllFilter(Map<String, Object> filter); 
	
	public Area create(AreaDTO dto);
	
	public void delete(AreaDTO dto);
	
	public void update(AreaDTO dto);
	
	public List<AreaDTO> getNotAssignedArea(String ids); 
	
	public List<AreaArchivoPruebaDTO> findAreaByArchivoPrueba(ArchivoPruebaDTO dto);
	
	public void createAreaArchivoPrueba(AreaArchivoPruebaDTO dto);
	
	public void deleteAreaArchivoPrueba(AreaArchivoPruebaDTO dto);
}