package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.domain.psaber.ResultadoExamenUsuario;

public interface ResultadoExamenUsuarioDAO {
	
	public List<ResultadoExamenUsuario> getAll();
	
	public List<ResultadoExamenUsuario> getAllFilter(Map<String, Object> filter);
	
	public ResultadoExamenUsuario create(ResultadoExamenUsuario entity);
	
	public void delete(ResultadoExamenUsuario entity);
	
	public void update(ResultadoExamenUsuario entity);
	
	public List<ResultadoExamenUsuario> getByUserNRespuestaExamenResultado(RespuestaExamen entity);
}
