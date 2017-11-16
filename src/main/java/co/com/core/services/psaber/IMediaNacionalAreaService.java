package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.MediaNacionalArea;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.MediaNacionalAreaDTO;


public interface IMediaNacionalAreaService {

	public List<MediaNacionalAreaDTO> getAll(); 

	public List<MediaNacionalAreaDTO> getAllFilter(Map<String, Object> filter); 
	
	public MediaNacionalArea create(MediaNacionalAreaDTO dto);
	
	public void delete(MediaNacionalAreaDTO dto);
	
	public void update(MediaNacionalAreaDTO dto);
	
	public List<MediaNacionalAreaDTO> getMediaNacionalByArchivoPrueba(ArchivoPruebaDTO dto);
}
