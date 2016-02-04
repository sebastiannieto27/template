package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.PageUtil;
import co.com.core.dao.PageDAO;
import co.com.core.domain.Page;
import co.com.core.dto.PageDTO;
import co.com.core.services.IPageService;

public class PageServiceImpl implements IPageService {

	private static final Logger logger = Logger.getLogger(PageServiceImpl.class);
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

	@Override
	public PageDTO getPageByURL(String url) {
		PageDTO dto = null;
		List<Page> pageList = pageDAO.getPageByURL(url);
		if(pageList!=null && pageList.size() > 0) {
			for(Page page : pageList) {
				dto = PageUtil.getDtoFromEntity(page);
			}
		} else {
			logger.info("Zero pages found related to : " + url);
		}
		
		return dto;
	}
}
