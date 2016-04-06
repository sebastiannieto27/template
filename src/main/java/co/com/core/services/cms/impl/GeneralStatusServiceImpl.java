package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.GeneralStatusUtil;
import co.com.core.dao.cms.GeneralStatusDAO;
import co.com.core.domain.cms.GeneralStatus;
import co.com.core.dto.cms.GeneralStatusDTO;
import co.com.core.services.cms.IGeneralStatusService;

public class GeneralStatusServiceImpl implements IGeneralStatusService {

	private static final Logger logger = Logger.getLogger(GeneralStatusServiceImpl.class);
	GeneralStatusDAO generalStatusDAO;
	
	@Override
	public List<GeneralStatusDTO> getAll() {
		List<GeneralStatusDTO> GeneralStatuss = new ArrayList<GeneralStatusDTO>();
		List<GeneralStatus> entityList = generalStatusDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(GeneralStatus GeneralStatus : entityList) {
				GeneralStatuss.add(GeneralStatusUtil.getDtoFromEntity(GeneralStatus));
			}
		}
		return GeneralStatuss;
	}

	@Override
	public List<GeneralStatusDTO> getAllFilter(Map<String, Object> filter) {
		List<GeneralStatusDTO> GeneralStatuss = new ArrayList<GeneralStatusDTO>();
		List<GeneralStatus> entityList = generalStatusDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(GeneralStatus GeneralStatus : entityList) {
				GeneralStatuss.add(GeneralStatusUtil.getDtoFromEntity(GeneralStatus));
			}
		}
		return GeneralStatuss;
	}
	
	@Override
	public GeneralStatus create(GeneralStatusDTO dto) {
		return generalStatusDAO.create(GeneralStatusUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(GeneralStatusDTO dto) {
		generalStatusDAO.delete(GeneralStatusUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(GeneralStatusDTO dto) {
		generalStatusDAO.update(GeneralStatusUtil.getEntityFromDto(dto));
	}

	public GeneralStatusDAO getGeneralStatusDAO() {
		return generalStatusDAO;
	}

	public void setGeneralStatusDAO(GeneralStatusDAO GeneralStatusDAO) {
		this.generalStatusDAO = GeneralStatusDAO;
	}
}
