package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.Competencia;
import co.com.core.dto.psaber.CompetenciaDTO;


public interface ICompetenciaService {

	public List<CompetenciaDTO> getAll(); 

	public List<CompetenciaDTO> getAllFilter(Map<String, Object> filter); 
	
	public Competencia create(CompetenciaDTO dto);
	
	public void delete(CompetenciaDTO dto);
	
	public void update(CompetenciaDTO dto);
	
	public List<CompetenciaDTO> getByArea(Area area);
}
