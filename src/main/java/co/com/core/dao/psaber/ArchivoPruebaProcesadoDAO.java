package co.com.core.dao.psaber;

import java.util.Date;
import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;

public interface ArchivoPruebaProcesadoDAO {
	
	public List<ArchivoPruebaProcesado> getAll();
	
	public List<ArchivoPruebaProcesado> getAllFilter(Map<String, Object> filter);
	
	public ArchivoPruebaProcesado create(ArchivoPruebaProcesado entity);
	
	public void delete(ArchivoPruebaProcesado entity);
	
	public void update(ArchivoPruebaProcesado entity);
	
	public ArchivoPruebaProcesado getByDateNName(Date date, String name);
	
}
