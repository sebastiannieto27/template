package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.News;
import co.com.core.dto.cms.NewsDTO;

public class NewsUtil {

	public static NewsDTO getDtoFromEntity(News entity) {
		NewsDTO dto = new NewsDTO();
		dto.setNewId(entity.getNewId());
		dto.setNewsTitle(entity.getNewsTitle());
		dto.setGeneralStatusId(entity.getGeneralStatusId());
		dto.setNewsDateStart(entity.getNewsDateStart());
		dto.setNewsDateExpire(entity.getNewsDateExpire());
		dto.setNewsShortDescr(entity.getNewsShortDescr());
		dto.setNewsLongDesc(entity.getNewsLongDesc());
		dto.setNewsFullImgPath(entity.getNewsFullImgPath());
		dto.setNewsImgPath(entity.getNewsImgPath());
		dto.setNewsThumbImgPath(entity.getNewsThumbImgPath());
		dto.setDateCre(entity.getDateCre());
		dto.setUserId(entity.getUserId());
		dto.setNewsTypeId(entity.getNewsTypeId());
		return dto;
	}
	
	public static News getEntityFromDto(NewsDTO dto) {
		News entity = new News();
		entity.setNewId(dto.getNewId());
		entity.setNewsTitle(dto.getNewsTitle());
		entity.setGeneralStatusId(dto.getGeneralStatusId());
		entity.setNewsDateStart(dto.getNewsDateStart());
		entity.setNewsDateExpire(dto.getNewsDateExpire());
		entity.setNewsShortDescr(dto.getNewsShortDescr());
		entity.setNewsLongDesc(dto.getNewsLongDesc());
		entity.setNewsFullImgPath(dto.getNewsFullImgPath());  
		entity.setNewsImgPath(dto.getNewsImgPath());
		entity.setNewsThumbImgPath(dto.getNewsThumbImgPath());
		entity.setDateCre(dto.getDateCre());
		entity.setUserId(dto.getUserId());
		entity.setNewsTypeId(dto.getNewsTypeId());
		return entity;
	}
}
