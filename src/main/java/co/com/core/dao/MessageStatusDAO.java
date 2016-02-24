package co.com.core.dao;

import java.util.List;

import co.com.core.domain.MessageStatus;

public interface MessageStatusDAO {
	
	public List<MessageStatus> getAll();
	
	public void create(MessageStatus entity);
	
	public void delete(MessageStatus entity);
	
	public void update(MessageStatus entity);
	
}
