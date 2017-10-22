package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Respuesta;
import co.com.core.dto.psaber.RespuestaDTO;


public interface IRespuestaService {

	public List<RespuestaDTO> getAll(); 

	public List<RespuestaDTO> getAllFilter(Map<String, Object> filter); 
	
	public Respuesta create(RespuestaDTO dto);
	
	public void delete(RespuestaDTO dto);
	
	public void update(RespuestaDTO dto);
}
