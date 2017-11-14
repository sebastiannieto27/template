package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.MediaNacionalAreaUtil;
import co.com.core.dao.psaber.MediaNacionalAreaDAO;
import co.com.core.domain.psaber.MediaNacionalArea;
import co.com.core.dto.psaber.MediaNacionalAreaDTO;
import co.com.core.services.psaber.IMediaNacionalAreaService;

public class MediaNacionalAreaServiceImpl implements IMediaNacionalAreaService {

	private static final Logger logger = Logger.getLogger(MediaNacionalAreaServiceImpl.class);
	MediaNacionalAreaDAO mediaNacionalAreaDAO;
	
	@Override
	public List<MediaNacionalAreaDTO> getAll() {
		List<MediaNacionalAreaDTO> MediaNacionalAreas = new ArrayList<MediaNacionalAreaDTO>();
		List<MediaNacionalArea> entityList = mediaNacionalAreaDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(MediaNacionalArea MediaNacionalArea : entityList) {
				MediaNacionalAreas.add(MediaNacionalAreaUtil.getDtoFromEntity(MediaNacionalArea));
			}
		}
		return MediaNacionalAreas;
	}

	@Override
	public List<MediaNacionalAreaDTO> getAllFilter(Map<String, Object> filter) {
		List<MediaNacionalAreaDTO> MediaNacionalAreas = new ArrayList<MediaNacionalAreaDTO>();
		List<MediaNacionalArea> entityList = mediaNacionalAreaDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(MediaNacionalArea MediaNacionalArea : entityList) {
				MediaNacionalAreas.add(MediaNacionalAreaUtil.getDtoFromEntity(MediaNacionalArea));
			}
		}
		return MediaNacionalAreas;
	}
	
	@Override
	public MediaNacionalArea create(MediaNacionalAreaDTO dto) {
		return mediaNacionalAreaDAO.create(MediaNacionalAreaUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(MediaNacionalAreaDTO dto) {
		mediaNacionalAreaDAO.delete(MediaNacionalAreaUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(MediaNacionalAreaDTO dto) {
		mediaNacionalAreaDAO.update(MediaNacionalAreaUtil.getEntityFromDto(dto));
	}

	public MediaNacionalAreaDAO getMediaNacionalAreaDAO() {
		return mediaNacionalAreaDAO;
	}

	public void setMediaNacionalAreaDAO(MediaNacionalAreaDAO MediaNacionalAreaDAO) {
		this.mediaNacionalAreaDAO = MediaNacionalAreaDAO;
	}
}