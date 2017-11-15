package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.PromedioAreaArchivoPruebaProcesado;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;
import co.com.core.dto.psaber.PromedioAreaArchivoPruebaProcesadoDTO;


public interface IPromedioAreaArchivoPruebaProcesadoService {

	public List<PromedioAreaArchivoPruebaProcesadoDTO> getAll(); 

	public List<PromedioAreaArchivoPruebaProcesadoDTO> getAllFilter(Map<String, Object> filter); 
	
	public PromedioAreaArchivoPruebaProcesado create(PromedioAreaArchivoPruebaProcesadoDTO dto);
	
	public void delete(PromedioAreaArchivoPruebaProcesadoDTO dto);
	
	public void update(PromedioAreaArchivoPruebaProcesadoDTO dto);
	
	public List<PromedioAreaArchivoPruebaProcesadoDTO> getByArchivoPruebaProcesado(ArchivoPruebaProcesadoDTO dto); 
}
