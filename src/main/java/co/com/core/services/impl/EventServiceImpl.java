package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.core.commons.converter.EventUtil;
import co.com.core.dao.EventDAO;
import co.com.core.domain.Event;
import co.com.core.dto.EventDTO;
import co.com.core.services.IEventService;


public class EventServiceImpl implements IEventService{

	EventDAO eventDAO;
	
	@Override
	public List<EventDTO> getAll() {
		List<EventDTO> events = new ArrayList<EventDTO>();
		List<Event> entityList = eventDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Event event : entityList) {
				events.add(EventUtil.getDtoFromEntity(event));
			}
		}
		return events;
	}

	@Override
	public void createEvent(EventDTO eventDto) {
		eventDAO.createEvent(EventUtil.getEntityFromDto(eventDto));
	}

	@Override
	public void delete(EventDTO eventDto) {
		eventDAO.delete(EventUtil.getEntityFromDto(eventDto));
	}

	@Override
	public void update(EventDTO eventDto) {
		eventDAO.update(EventUtil.getEntityFromDto(eventDto));
	}

	@Override
	public void updateHQL(EventDTO eventDto) {
		eventDAO.updateHQL(EventUtil.getEntityFromDto(eventDto));
	}

	public EventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}
}
