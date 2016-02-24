package co.com.core.services;

import java.util.List;

import co.com.core.dto.MessageDTO;


public interface IMessageService {

	public List<MessageDTO> getAll(); 
	
	public void create(MessageDTO dto);
	
	public void delete(MessageDTO dto);
	
	public void update(MessageDTO dto);
}
