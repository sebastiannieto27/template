package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.Client;

public interface ClientDAO {

	public List<Client> getAllFilter(Map<String, Object> filter);
	
	public List<Client> getAll();
	
	public Client create(Client entity);
	
	public void delete(Client entity);
	
	public void update(Client entity);
}
