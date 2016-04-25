package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.ClientType;

public interface ClientTypeDAO {

	public List<ClientType> getAllFilter(Map<String, Object> filter);
	
	public List<ClientType> getAll();
	
	public ClientType create(ClientType entity);
	
	public void delete(ClientType entity);
	
	public void update(ClientType entity);
}
