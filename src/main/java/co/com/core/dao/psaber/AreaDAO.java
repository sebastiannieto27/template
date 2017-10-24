package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.AreaArchivoPrueba;

public interface AreaDAO {
	
	public List<Area> getAll();
	
	public List<Area> getAllFilter(Map<String, Object> filter);
	
	public Area create(Area entity);
	
	public void delete(Area entity);
	
	public void update(Area entity);
	
	public List<AreaArchivoPrueba> findAreaByArchivoPrueba(ArchivoPrueba entity);
	
	public List<Area> getNotAssignedArea(String ids);
	
	public AreaArchivoPrueba createAreaArchivoPrueba(AreaArchivoPrueba entity);
	
	public void deleteAreaArchivoPrueba(AreaArchivoPrueba entity);
}
