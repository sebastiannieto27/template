package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.NewsTypeUtil;
import co.com.core.dao.cms.NewsTypeDAO;
import co.com.core.domain.cms.NewsType;
import co.com.core.dto.cms.NewsTypeDTO;
import co.com.core.services.cms.INewsTypeService;

public class NewsTypeServiceImpl implements INewsTypeService {

	private static final Logger logger = Logger.getLogger(NewsTypeServiceImpl.class);
	NewsTypeDAO newsTypeDAO;
	
	@Override
	public List<NewsTypeDTO> getAll() {
		List<NewsTypeDTO> NewsTypes = new ArrayList<NewsTypeDTO>();
		List<NewsType> entityList = newsTypeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(NewsType NewsType : entityList) {
				NewsTypes.add(NewsTypeUtil.getDtoFromEntity(NewsType));
			}
		}
		return NewsTypes;
	}

	@Override
	public List<NewsTypeDTO> getAllFilter(Map<String, Object> filter) {
		List<NewsTypeDTO> dtoList = new ArrayList<NewsTypeDTO>();
		List<NewsType> entityList = newsTypeDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(NewsType entity : entityList) {
				dtoList.add(NewsTypeUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public void create(NewsTypeDTO dto) {
		newsTypeDAO.create(NewsTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(NewsTypeDTO dto) {
		newsTypeDAO.delete(NewsTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(NewsTypeDTO dto) {
		newsTypeDAO.update(NewsTypeUtil.getEntityFromDto(dto));
	}

	public NewsTypeDAO getNewsTypeDAO() {
		return newsTypeDAO;
	}

	public void setNewsTypeDAO(NewsTypeDAO NewsTypeDAO) {
		this.newsTypeDAO = NewsTypeDAO;
	}
}
