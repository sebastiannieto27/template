package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.Product;
import co.com.core.dto.financial.account.ProductDTO;

public interface IProductService {

	public List<ProductDTO> getAll(); 

	public List<ProductDTO> getAllFilter(Map<String, Object> filter); 
	
	public Product create(ProductDTO dto);
	
	public void delete(ProductDTO dto);
	
	public void update(ProductDTO dto);

}
