package co.com.core.dao.cms;

import java.util.List;
import java.util.Map;

import co.com.core.domain.cms.GeneralStatus;

public interface GeneralStatusDAO {
	
	public List<GeneralStatus> getAll();
	
	public List<GeneralStatus> getAllFilter(Map<String, Object> filter);
	
	public GeneralStatus create(GeneralStatus entity);
	
	public void delete(GeneralStatus entity);
	
	public void update(GeneralStatus entity);
	
}
