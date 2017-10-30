package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.ResultadoExamenUsuario;
import co.com.core.dto.psaber.RespuestaExamenDTO;
import co.com.core.dto.psaber.ResultadoExamenUsuarioDTO;


public interface IResultadoExamenUsuarioService {

	public List<ResultadoExamenUsuarioDTO> getAll(); 

	public List<ResultadoExamenUsuarioDTO> getAllFilter(Map<String, Object> filter); 
	
	public ResultadoExamenUsuario create(ResultadoExamenUsuarioDTO dto);
	
	public void delete(ResultadoExamenUsuarioDTO dto);
	
	public void update(ResultadoExamenUsuarioDTO dto);
	
	public List<ResultadoExamenUsuarioDTO> getByUserNRespuestaExamenResultado(RespuestaExamenDTO dto);
}
