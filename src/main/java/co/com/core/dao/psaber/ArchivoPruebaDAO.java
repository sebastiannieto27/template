package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.ArchivoPrueba;

public interface ArchivoPruebaDAO {
	
	public List<ArchivoPrueba> getAll();
	
	public List<ArchivoPrueba> getAllFilter(Map<String, Object> filter);
	
	public ArchivoPrueba create(ArchivoPrueba entity);
	
	public void delete(ArchivoPrueba entity);
	
	public void update(ArchivoPrueba entity);
	
}
