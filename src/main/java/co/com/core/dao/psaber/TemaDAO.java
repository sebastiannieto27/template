package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Pregunta;
import co.com.core.domain.psaber.PreguntaTema;
import co.com.core.domain.psaber.Tema;
import co.com.core.dto.psaber.PreguntaTemaDTO;

public interface TemaDAO {
	
	public List<Tema> getAll();
	
	public List<Tema> getAllFilter(Map<String, Object> filter);
	
	public Tema create(Tema entity);
	
	public void delete(Tema entity);
	
	public void update(Tema entity);
	
	public List<PreguntaTema> findTemaByPregunta(Pregunta entity);
	
	public List<Tema> getNotAssignedTema(String ids);
	
	public PreguntaTema createPreguntaTema(PreguntaTema entity);
	
	public void deletePreguntaTema(PreguntaTema entity);
	
}
