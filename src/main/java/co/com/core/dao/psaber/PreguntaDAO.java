package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Pregunta;

public interface PreguntaDAO {
	
	public List<Pregunta> getAll();
	
	public List<Pregunta> getAllFilter(Map<String, Object> filter);
	
	public Pregunta create(Pregunta entity);
	
	public void delete(Pregunta entity);
	
	public void update(Pregunta entity);
	
}
