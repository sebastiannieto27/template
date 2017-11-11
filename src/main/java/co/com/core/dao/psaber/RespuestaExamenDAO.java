package co.com.core.dao.psaber;

import java.util.Date;
import java.util.List;
import java.util.Map;

import co.com.core.domain.User;
import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.domain.psaber.RespuestaExamen;

public interface RespuestaExamenDAO {
	
	public List<RespuestaExamen> getAll();
	
	public List<RespuestaExamen> getAllFilter(Map<String, Object> filter);
	
	public RespuestaExamen create(RespuestaExamen entity);
	
	public void delete(RespuestaExamen entity);
	
	public void update(RespuestaExamen entity);
	
	public RespuestaExamen getByRespuestaExamenId(Integer id);
	
	public List<RespuestaExamen> getByArchivoPruebaProcesado(ArchivoPruebaProcesado dto);
	
	public List<RespuestaExamen> getByRespuestaExamenResultado(User userId, Date searchDate);
	
	public List<RespuestaExamen> getByArchivoPruebaFecha(ArchivoPrueba archivoPruebaId, Date searchDate);
}
