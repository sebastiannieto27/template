package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.NewsType;
import co.com.core.dto.cms.NewsTypeDTO;

public class NewsTypeUtil {

	public static NewsTypeDTO getDtoFromEntity(NewsType entity) {
		NewsTypeDTO dto = new NewsTypeDTO();
		dto.setNewsTypeId(entity.getNewsTypeId());
		dto.setNewsTypeName(entity.getNewsTypeName());
		return dto;
	}
	
	public static NewsType getEntityFromDto(NewsTypeDTO dto) {
		NewsType entity = new NewsType();
		entity.setNewsTypeId(dto.getNewsTypeId());
		entity.setNewsTypeName(dto.getNewsTypeName());
		return entity;
	}
}
