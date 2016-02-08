package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Priority;

public interface PriorityDAO {

	public List<Priority> getAll();
	
	public void create(Priority entity);
	
	public void delete(Priority entity);
	
	public void update(Priority entity);
}
