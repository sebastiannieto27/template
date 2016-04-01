package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.Brand;
import co.com.core.dto.cms.BrandDTO;

public class BrandUtil {

	public static BrandDTO getDtoFromEntity(Brand entity) {
		BrandDTO dto = new BrandDTO();
		dto.setBrandAddress(entity.getBrandAddress());
		dto.setBrandBigImg(entity.getBrandBigImg());
		dto.setBrandId(entity.getBrandId());
		dto.setBrandName(entity.getBrandName());
		dto.setBrandOpenHours(entity.getBrandOpenHours());
		dto.setBrandThumbImg(entity.getBrandThumbImg());
		dto.setBrandTypeId(entity.getBrandTypeId());
		dto.setDateCre(entity.getDateCre());
		dto.setUserId(entity.getUserId());
		return dto;
	}
	
	public static Brand getEntityFromDto(BrandDTO dto) {
		Brand entity = new Brand();
		entity.setBrandAddress(dto.getBrandAddress());
		entity.setBrandBigImg(dto.getBrandBigImg());
		entity.setBrandId(dto.getBrandId());
		entity.setBrandName(dto.getBrandName());
		entity.setBrandOpenHours(dto.getBrandOpenHours());
		entity.setBrandThumbImg(dto.getBrandThumbImg());
		entity.setBrandTypeId(dto.getBrandTypeId());
		entity.setDateCre(dto.getDateCre());
		entity.setUserId(dto.getUserId());
		return entity;
	}
}
