package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Materia;

public interface MateriaDAO {
	
	public List<Materia> getAll();
	
	public List<Materia> getAllFilter(Map<String, Object> filter);
	
	public Materia create(Materia entity);
	
	public void delete(Materia entity);
	
	public void update(Materia entity);
	
}
