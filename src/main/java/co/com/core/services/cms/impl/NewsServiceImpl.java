package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.BranchUtil;
import co.com.core.commons.converter.cms.NewsUtil;
import co.com.core.dao.cms.NewsDAO;
import co.com.core.domain.cms.Branch;
import co.com.core.domain.cms.News;
import co.com.core.dto.cms.BranchDTO;
import co.com.core.dto.cms.NewsDTO;
import co.com.core.services.cms.INewsService;

public class NewsServiceImpl implements INewsService {

	private static final Logger logger = Logger.getLogger(NewsServiceImpl.class);
	NewsDAO newsDAO;
	
	@Override
	public List<NewsDTO> getAll() {
		List<NewsDTO> Newss = new ArrayList<NewsDTO>();
		List<News> entityList = newsDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(News News : entityList) {
				Newss.add(NewsUtil.getDtoFromEntity(News));
			}
		}
		return Newss;
	}

	@Override
	public List<NewsDTO> getAllFilter(Map<String, Object> filter) {
		List<NewsDTO> dtoList = new ArrayList<NewsDTO>();
		List<News> entityList = newsDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(News news : entityList) {
				dtoList.add(NewsUtil.getDtoFromEntity(news));
			}
		}
		return dtoList;
	}
	
	@Override
	public void create(NewsDTO dto) {
		newsDAO.create(NewsUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(NewsDTO dto) {
		newsDAO.delete(NewsUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(NewsDTO dto) {
		newsDAO.update(NewsUtil.getEntityFromDto(dto));
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(NewsDAO NewsDAO) {
		this.newsDAO = NewsDAO;
	}
}
