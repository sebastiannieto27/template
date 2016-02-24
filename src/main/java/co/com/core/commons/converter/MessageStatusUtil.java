package co.com.core.commons.converter;

import co.com.core.domain.MessageStatus;
import co.com.core.dto.MessageStatusDTO;

public class MessageStatusUtil {

	public static MessageStatusDTO getDtoFromEntity(MessageStatus entity) {
		MessageStatusDTO dto = new MessageStatusDTO();
		dto.setName(entity.getName());
		dto.setMessageStatusId(entity.getMessageStatusId());
		return dto;
	}
	
	public static MessageStatus getEntityFromDto(MessageStatusDTO dto) {
		MessageStatus entity = new MessageStatus();
		entity.setName(dto.getName());
		entity.setMessageStatusId(dto.getMessageStatusId());
		return entity;
	}
}
