package co.com.core.services;

import java.util.List;

import co.com.core.dto.EventDTO;

public interface IEventService {

	public List<EventDTO> getAll(); 
	
	public void createEvent(EventDTO eventDto);
	
	public void delete(EventDTO eventDto);
	
	public void update(EventDTO eventDto);
	
	public void updateHQL(EventDTO eventDto);
}
