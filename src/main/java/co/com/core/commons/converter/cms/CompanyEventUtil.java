package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.CompanyEvent;
import co.com.core.dto.cms.CompanyEventDTO;

public class CompanyEventUtil {

	public static CompanyEventDTO getDtoFromEntity(CompanyEvent entity) {
		CompanyEventDTO dto = new CompanyEventDTO();
		dto.setCompanyEventId(entity.getCompanyEventId());
		dto.setCompanyEventTitle(entity.getCompanyEventTitle());
		dto.setCompanyEventLocation(entity.getCompanyEventLocation());
		dto.setCompanyEventDesc(entity.getCompanyEventDesc());
		dto.setCompanyEventThumbImg(entity.getCompanyEventThumbImg());
		dto.setCompanyEventBigImg(entity.getCompanyEventBigImg());
		dto.setDateCre(entity.getDateCre());
		dto.setUserId(entity.getUserId());
		return dto;
	}
	
	public static CompanyEvent getEntityFromDto(CompanyEventDTO dto) {
		CompanyEvent entity = new CompanyEvent();
		entity.setCompanyEventId(dto.getCompanyEventId());
		entity.setCompanyEventTitle(dto.getCompanyEventTitle());
		entity.setCompanyEventLocation(dto.getCompanyEventLocation());
		entity.setCompanyEventDesc(dto.getCompanyEventDesc());
		entity.setCompanyEventThumbImg(dto.getCompanyEventThumbImg());
		entity.setCompanyEventBigImg(dto.getCompanyEventBigImg());
		entity.setDateCre(dto.getDateCre());
		entity.setUserId(dto.getUserId());
		return entity;
	}
}
