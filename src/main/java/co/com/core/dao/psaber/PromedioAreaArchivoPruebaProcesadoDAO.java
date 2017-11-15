package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.domain.psaber.PromedioAreaArchivoPruebaProcesado;

public interface PromedioAreaArchivoPruebaProcesadoDAO {
	
	public List<PromedioAreaArchivoPruebaProcesado> getAll();
	
	public List<PromedioAreaArchivoPruebaProcesado> getAllFilter(Map<String, Object> filter);
	
	public PromedioAreaArchivoPruebaProcesado create(PromedioAreaArchivoPruebaProcesado entity);
	
	public void delete(PromedioAreaArchivoPruebaProcesado entity);
	
	public void update(PromedioAreaArchivoPruebaProcesado entity);
	
	public List<PromedioAreaArchivoPruebaProcesado> getByArchivoPruebaProcesado(ArchivoPruebaProcesado entity);
}
