package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.Product;

public interface ProductDAO {

	public List<Product> getAllFilter(Map<String, Object> filter);
	
	public List<Product> getAll();
	
	public Product create(Product entity);
	
	public void delete(Product entity);
	
	public void update(Product entity);
}
