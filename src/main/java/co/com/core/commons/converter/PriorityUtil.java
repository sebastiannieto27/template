package co.com.core.commons.converter;

import co.com.core.domain.Priority;
import co.com.core.dto.PriorityDTO;

public class PriorityUtil {

	public static PriorityDTO getDtoFromEntity(Priority entity) {
		PriorityDTO priorityDto = new PriorityDTO();
		priorityDto.setColor(entity.getColor());
		priorityDto.setPriorityId(entity.getPriorityId());
		priorityDto.setName(entity.getName());
		return priorityDto;
	}
	
	public static Priority getEntityFromDto(PriorityDTO dto) {
		Priority Priority = new Priority();
		Priority.setPriorityId(dto.getPriorityId());
		Priority.setColor(dto.getColor());
		Priority.setName(dto.getName());
		return Priority;
	}
}
