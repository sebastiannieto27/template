package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Tema;
import co.com.core.dto.psaber.PreguntaDTO;
import co.com.core.dto.psaber.PreguntaTemaDTO;
import co.com.core.dto.psaber.TemaDTO;


public interface ITemaService {

	public List<TemaDTO> getAll(); 

	public List<TemaDTO> getAllFilter(Map<String, Object> filter); 
	
	public Tema create(TemaDTO dto);
	
	public void delete(TemaDTO dto);
	
	public void update(TemaDTO dto);
	
	public List<TemaDTO> getNotAssignedTema(String ids); 
	
	public List<PreguntaTemaDTO> findTemaByPregunta(PreguntaDTO dto);
	
	public void createPreguntaTema(PreguntaTemaDTO dto);
	
	public void deletePreguntaTema(PreguntaTemaDTO dto);
}
