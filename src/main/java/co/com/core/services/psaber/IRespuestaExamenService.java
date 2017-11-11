package co.com.core.services.psaber;

import java.util.Date;
import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.dto.UserDTO;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;
import co.com.core.dto.psaber.RespuestaExamenDTO;


public interface IRespuestaExamenService {

	public List<RespuestaExamenDTO> getAll(); 

	public List<RespuestaExamenDTO> getAllFilter(Map<String, Object> filter); 
	
	public RespuestaExamen create(RespuestaExamenDTO dto);
	
	public void delete(RespuestaExamenDTO dto);
	
	public void update(RespuestaExamenDTO dto);
	
	public List<RespuestaExamenDTO> getByArchivoPruebaProcesado(ArchivoPruebaProcesadoDTO dto); 
	
	public List<RespuestaExamenDTO> getByRespuestaExamenResultado(UserDTO dto, Date searchDate);
	
	public List<RespuestaExamenDTO> getByArchivoPruebaFecha(ArchivoPruebaDTO dto, Date searchDate);
}
