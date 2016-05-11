package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.Albaran;

public interface AlbaranDAO {

	public List<Albaran> getAllFilter(Map<String, Object> filter);
	
	public List<Albaran> getAll();
	
}
