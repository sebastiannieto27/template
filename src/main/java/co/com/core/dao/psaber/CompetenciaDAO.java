package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.Competencia;

public interface CompetenciaDAO {
	
	public List<Competencia> getAll();
	
	public List<Competencia> getAllFilter(Map<String, Object> filter);
	
	public Competencia create(Competencia entity);
	
	public void delete(Competencia entity);
	
	public void update(Competencia entity);
	
	public List<Competencia> getByArea(Area area);
	
}
