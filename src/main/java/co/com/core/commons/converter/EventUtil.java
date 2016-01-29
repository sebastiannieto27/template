package co.com.core.commons.converter;

import co.com.core.domain.Event;
import co.com.core.dto.EventDTO;

public class EventUtil {

	public static EventDTO getDtoFromEntity(Event entity) {
		EventDTO EventDto = new EventDTO();
		EventDto.setEventId(entity.getEventId());
		EventDto.setName(entity.getName());
		EventDto.setStartDate(entity.getStartDate());
		EventDto.setEndDate(entity.getEndDate());
		EventDto.setPriorityId(entity.getPriorityId());
		return EventDto;
	}
	
	public static Event getEntityFromDto(EventDTO dto) {
		Event Event = new Event();
		Event.setEventId(dto.getEventId());
		Event.setName(dto.getName());
		Event.setStartDate(dto.getStartDate());
		Event.setEndDate(dto.getEndDate());
		Event.setPriorityId(dto.getPriorityId());
		return Event;
	}
}
