package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Message;

public interface MessageDAO {
	
	public List<Message> getAll();
	
	public void create(Message entity);
	
	public void delete(Message entity);
	
	public void update(Message entity);
	
}
