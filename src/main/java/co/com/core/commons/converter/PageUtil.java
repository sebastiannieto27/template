package co.com.core.commons.converter;

import co.com.core.domain.Page;
import co.com.core.dto.PageDTO;

public class PageUtil {

	public static PageDTO getDtoFromEntity(Page entity) {
		PageDTO pageDto = new PageDTO();
		pageDto.setPageId(entity.getPageId());
		pageDto.setPageName(entity.getPageName());
		pageDto.setUrl(entity.getUrl());
		pageDto.setRealUrl(entity.getRealUrl());
		return pageDto;
	}
	
	public static Page getEntityFromDto(PageDTO dto) {
		Page page = new Page();
		page.setPageId(dto.getPageId());
		page.setPageName(dto.getPageName());
		page.setUrl(dto.getUrl());
		page.setRealUrl(dto.getRealUrl());
		return page;
	}
}
