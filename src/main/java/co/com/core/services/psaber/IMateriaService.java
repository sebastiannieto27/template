package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Materia;
import co.com.core.dto.psaber.MateriaDTO;


public interface IMateriaService {

	public List<MateriaDTO> getAll(); 

	public List<MateriaDTO> getAllFilter(Map<String, Object> filter); 
	
	public Materia create(MateriaDTO dto);
	
	public void delete(MateriaDTO dto);
	
	public void update(MateriaDTO dto);
}
