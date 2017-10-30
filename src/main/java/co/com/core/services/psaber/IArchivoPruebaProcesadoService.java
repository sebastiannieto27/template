package co.com.core.services.psaber;

import java.util.Date;
import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;


public interface IArchivoPruebaProcesadoService {

	public List<ArchivoPruebaProcesadoDTO> getAll(); 

	public List<ArchivoPruebaProcesadoDTO> getAllFilter(Map<String, Object> filter); 
	
	public ArchivoPruebaProcesado create(ArchivoPruebaProcesadoDTO dto);
	
	public void delete(ArchivoPruebaProcesadoDTO dto);
	
	public void update(ArchivoPruebaProcesadoDTO dto);
	
	public ArchivoPruebaProcesadoDTO getByDateNName(Date date, String name);
}
