package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.Area;

public interface AreaDAO {
	
	public List<Area> getAll();
	
	public List<Area> getAllFilter(Map<String, Object> filter);
	
	public Area create(Area entity);
	
	public void delete(Area entity);
	
	public void update(Area entity);
	
}
