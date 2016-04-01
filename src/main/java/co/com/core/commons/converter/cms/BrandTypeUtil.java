package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.BrandType;
import co.com.core.dto.cms.BrandTypeDTO;

public class BrandTypeUtil {

	public static BrandTypeDTO getDtoFromEntity(BrandType entity) {
		BrandTypeDTO dto = new BrandTypeDTO();
		dto.setBrandTypeId(entity.getBrandTypeId());
		dto.setBrandTypeName(entity.getBrandTypeName());
		dto.setDateCre(entity.getDateCre());
		dto.setUserId(entity.getUserId());
		return dto;
	}
	
	public static BrandType getEntityFromDto(BrandTypeDTO dto) {
		BrandType entity = new BrandType();
		entity.setBrandTypeId(dto.getBrandTypeId());
		entity.setBrandTypeName(dto.getBrandTypeName());
		entity.setDateCre(dto.getDateCre());
		entity.setUserId(dto.getUserId());
		return entity;
	}
}
