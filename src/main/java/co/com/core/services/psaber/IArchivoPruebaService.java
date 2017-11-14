package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.AreaArchivoPruebaDTO;


public interface IArchivoPruebaService {

	public List<ArchivoPruebaDTO> getAll(); 

	public List<ArchivoPruebaDTO> getAllFilter(Map<String, Object> filter); 
	
	public ArchivoPrueba create(ArchivoPruebaDTO dto);
	
	public void delete(ArchivoPruebaDTO dto);
	
	public void update(ArchivoPruebaDTO dto);
	
	public ArchivoPruebaDTO getByArchivoPruebaId(Integer id);
	
	public List<AreaArchivoPruebaDTO> getAreasByArchivoPrueba(ArchivoPruebaDTO dto); 
}
