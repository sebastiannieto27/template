package co.com.core.services;

import java.util.List;

import co.com.core.dto.MessageStatusDTO;


public interface IMessageStatusService {

	public List<MessageStatusDTO> getAll(); 
	
	public void create(MessageStatusDTO dto);
	
	public void delete(MessageStatusDTO dto);
	
	public void update(MessageStatusDTO dto);
}
