package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.ProductUtil;
import co.com.core.dao.financial.account.ProductDAO;
import co.com.core.domain.financial.account.Product;
import co.com.core.dto.financial.account.ProductDTO;
import co.com.core.services.financial.account.IProductService;

public class ProductServiceImpl implements IProductService {
	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);
	ProductDAO taxDAO;
	
	@Override
	public List<ProductDTO> getAll() {
		List<ProductDTO> Products = new ArrayList<ProductDTO>();
		List<Product> entityList = taxDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Product Product : entityList) {
				Products.add(ProductUtil.getDtoFromEntity(Product));
			}
		}
		return Products;
	}

	@Override
	public List<ProductDTO> getAllFilter(Map<String, Object> filter) {
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> entityList = taxDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Product entity : entityList) {
				dtoList.add(ProductUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public Product create(ProductDTO dto) {
		return taxDAO.create(ProductUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(ProductDTO dto) {
		taxDAO.delete(ProductUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(ProductDTO dto) {
		taxDAO.update(ProductUtil.getEntityFromDto(dto));
	}

	public ProductDAO getProductDAO() {
		return taxDAO;
	}

	public void setProductDAO(ProductDAO ProductDAO) {
		this.taxDAO = ProductDAO;
	}
}
