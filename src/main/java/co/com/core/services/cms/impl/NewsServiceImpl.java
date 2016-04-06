package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.NewsUtil;
import co.com.core.dao.cms.NewsDAO;
import co.com.core.domain.cms.News;
import co.com.core.dto.cms.NewsDTO;
import co.com.core.services.cms.INewsService;

public class NewsServiceImpl implements INewsService {

	private static final Logger logger = Logger.getLogger(NewsServiceImpl.class);
	NewsDAO NewsDAO;
	
	@Override
	public List<NewsDTO> getAll() {
		List<NewsDTO> Newss = new ArrayList<NewsDTO>();
		List<News> entityList = NewsDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(News News : entityList) {
				Newss.add(NewsUtil.getDtoFromEntity(News));
			}
		}
		return Newss;
	}

	@Override
	public void create(NewsDTO dto) {
		NewsDAO.create(NewsUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(NewsDTO dto) {
		NewsDAO.delete(NewsUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(NewsDTO dto) {
		NewsDAO.update(NewsUtil.getEntityFromDto(dto));
	}

	public NewsDAO getNewsDAO() {
		return NewsDAO;
	}

	public void setNewsDAO(NewsDAO NewsDAO) {
		this.NewsDAO = NewsDAO;
	}
}
