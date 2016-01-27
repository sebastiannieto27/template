package co.com.plantilla.services.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.plantilla.commons.converter.PageUtil;
import co.com.plantilla.dao.PageDAO;
import co.com.plantilla.domain.Page;
import co.com.plantilla.dto.PageDTO;
import co.com.plantilla.services.IPageService;

public class PageServiceImpl implements IPageService {

	PageDAO pageDAO;
	
	@Override
	public List<PageDTO> getAll() {
		List<PageDTO> pages = new ArrayList<PageDTO>();
		List<Page> entityList = pageDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Page page : entityList) {
				pages.add(PageUtil.getDtoFromEntity(page));
			}
		}
		return pages;
	}

	@Override
	public void createPage(PageDTO pageDto) {
		pageDAO.createPage(PageUtil.getEntityFromDto(pageDto));
	}

	@Override
	public void delete(PageDTO pageDto) {
		pageDAO.delete(PageUtil.getEntityFromDto(pageDto));
	}

	@Override
	public void update(PageDTO pageDto) {
		pageDAO.update(PageUtil.getEntityFromDto(pageDto));
	}

	public PageDAO getPageDAO() {
		return pageDAO;
	}

	public void setPageDAO(PageDAO pageDAO) {
		this.pageDAO = pageDAO;
	}
}
