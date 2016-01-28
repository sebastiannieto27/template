package co.com.core.commons.converter;

import co.com.core.domain.Page;
import co.com.core.dto.PageDTO;

public class PageUtil {

	public static PageDTO getDtoFromEntity(Page entity) {
		PageDTO PageDto = new PageDTO();
		PageDto.setPageId(entity.getPageId());
		PageDto.setPageName(entity.getPageName());
		PageDto.setUrl(entity.getUrl());
		return PageDto;
	}
	
	public static Page getEntityFromDto(PageDTO dto) {
		Page Page = new Page();
		Page.setPageId(dto.getPageId());
		Page.setPageName(dto.getPageName());
		Page.setUrl(dto.getUrl());
		return Page;
	}
}
