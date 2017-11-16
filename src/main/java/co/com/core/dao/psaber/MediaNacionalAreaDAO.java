package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.MediaNacionalArea;

public interface MediaNacionalAreaDAO {
	
	public List<MediaNacionalArea> getAll();
	
	public List<MediaNacionalArea> getAllFilter(Map<String, Object> filter);
	
	public MediaNacionalArea create(MediaNacionalArea entity);
	
	public void delete(MediaNacionalArea entity);
	
	public void update(MediaNacionalArea entity);
	
	public List<MediaNacionalArea> getMediaNacionalByArchivoPrueba(ArchivoPrueba entity);
}
