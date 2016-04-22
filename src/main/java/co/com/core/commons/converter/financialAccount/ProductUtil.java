package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.Product;
import co.com.core.dto.financial.account.ProductDTO;

public class ProductUtil {

	public static ProductDTO getDtoFromEntity(Product entity) {
		ProductDTO dto = new ProductDTO();
		dto.setProductId(entity.getProductId());
		dto.setProductIntCode(entity.getProductIntCode());
		dto.setProductName(entity.getProductName());
		dto.setProductDesc(entity.getProductDesc());
		return dto;
	}
	
	public static Product getEntityFromDto(ProductDTO dto) {
		Product entity = new Product();
		entity.setProductId(dto.getProductId());
		entity.setProductIntCode(dto.getProductIntCode());
		entity.setProductName(dto.getProductName());
		entity.setProductDesc(dto.getProductDesc());
		return entity;
	}
}
