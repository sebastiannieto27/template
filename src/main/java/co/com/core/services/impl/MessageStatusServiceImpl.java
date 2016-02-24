package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.MessageStatusUtil;
import co.com.core.dao.MessageStatusDAO;
import co.com.core.domain.MessageStatus;
import co.com.core.dto.MessageStatusDTO;
import co.com.core.services.IMessageStatusService;

public class MessageStatusServiceImpl implements IMessageStatusService {

	private static final Logger logger = Logger.getLogger(MessageStatusServiceImpl.class);
	MessageStatusDAO messageStatusDAO;
	
	@Override
	public List<MessageStatusDTO> getAll() {
		List<MessageStatusDTO> MessageStatuss = new ArrayList<MessageStatusDTO>();
		List<MessageStatus> entityList = messageStatusDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(MessageStatus MessageStatus : entityList) {
				MessageStatuss.add(MessageStatusUtil.getDtoFromEntity(MessageStatus));
			}
		}
		return MessageStatuss;
	}

	@Override
	public void create(MessageStatusDTO dto) {
		messageStatusDAO.create(MessageStatusUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(MessageStatusDTO dto) {
		messageStatusDAO.delete(MessageStatusUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(MessageStatusDTO dto) {
		messageStatusDAO.update(MessageStatusUtil.getEntityFromDto(dto));
	}

	public MessageStatusDAO getMessageStatusDAO() {
		return messageStatusDAO;
	}

	public void setMessageStatusDAO(MessageStatusDAO MessageStatusDAO) {
		this.messageStatusDAO = MessageStatusDAO;
	}
}
