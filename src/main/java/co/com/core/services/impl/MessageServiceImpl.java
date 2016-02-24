package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.MessageUtil;
import co.com.core.dao.MessageDAO;
import co.com.core.domain.Message;
import co.com.core.dto.MessageDTO;
import co.com.core.services.IMessageService;

public class MessageServiceImpl implements IMessageService {

	private static final Logger logger = Logger.getLogger(MessageServiceImpl.class);
	MessageDAO messageDAO;
	
	@Override
	public List<MessageDTO> getAll() {
		List<MessageDTO> Messages = new ArrayList<MessageDTO>();
		List<Message> entityList = messageDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Message message : entityList) {
				Messages.add(MessageUtil.getDtoFromEntity(message));
			}
		}
		return Messages;
	}

	@Override
	public void create(MessageDTO dto) {
		messageDAO.create(MessageUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(MessageDTO dto) {
		messageDAO.delete(MessageUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(MessageDTO dto) {
		messageDAO.update(MessageUtil.getEntityFromDto(dto));
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO MessageDAO) {
		this.messageDAO = MessageDAO;
	}
}
