package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Pregunta;
import co.com.core.dto.psaber.PreguntaDTO;


public interface IPreguntaService {

	public List<PreguntaDTO> getAll(); 

	public List<PreguntaDTO> getAllFilter(Map<String, Object> filter); 
	
	public Pregunta create(PreguntaDTO dto);
	
	public void delete(PreguntaDTO dto);
	
	public void update(PreguntaDTO dto);
}
