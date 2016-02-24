package co.com.core.commons.converter;

import co.com.core.domain.Message;
import co.com.core.dto.MessageDTO;

public class MessageUtil {

	public static MessageDTO getDtoFromEntity(Message entity) {
		MessageDTO dto = new MessageDTO();
		dto.setMessageId(entity.getMessageId());
		dto.setTitle(entity.getTitle());
		dto.setBody(entity.getBody());
		dto.setDate(entity.getDate());
		dto.setMessageStatusId(entity.getMessageStatusId());
		dto.setPriorityId(entity.getPriorityId());
		dto.setReceiverId(entity.getReceiverId());
		dto.setSenderId(entity.getSenderId());
		return dto;
	}
	
	public static Message getEntityFromDto(MessageDTO dto) {
		Message entity = new Message();
		entity.setMessageId(dto.getMessageId());
		entity.setTitle(dto.getTitle());
		entity.setBody(dto.getBody());
		entity.setDate(dto.getDate());
		entity.setMessageStatusId(dto.getMessageStatusId());
		entity.setPriorityId(dto.getPriorityId());
		entity.setReceiverId(dto.getReceiverId());
		entity.setSenderId(dto.getSenderId());
		return entity;
	}
}
