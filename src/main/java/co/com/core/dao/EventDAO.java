package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Event;

public interface EventDAO {

	public List<Event> getAll();
	
	public void createEvent(Event event);
	
	public void delete(Event event);
	
	public void update(Event event);
	
	public void updateHQL(Event entity);
}
