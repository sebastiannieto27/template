package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Respuesta;

public interface RespuestaDAO {
	
	public List<Respuesta> getAll();
	
	public List<Respuesta> getAllFilter(Map<String, Object> filter);
	
	public Respuesta create(Respuesta entity);
	
	public void delete(Respuesta entity);
	
	public void update(Respuesta entity);
	
}
