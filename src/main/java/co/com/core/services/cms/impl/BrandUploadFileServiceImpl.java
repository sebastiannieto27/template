package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.BrandUploadFileUtil;
import co.com.core.dao.cms.BrandUploadFileDAO;
import co.com.core.domain.cms.BrandUploadFile;
import co.com.core.dto.cms.BrandUploadFileDTO;
import co.com.core.services.cms.IBrandUploadFileService;

public class BrandUploadFileServiceImpl implements IBrandUploadFileService {

	private static final Logger logger = Logger.getLogger(BrandUploadFileServiceImpl.class);
	BrandUploadFileDAO brandUploadFileDAO;
	
	@Override
	public List<BrandUploadFileDTO> getAll() {
		List<BrandUploadFileDTO> BrandUploadFiles = new ArrayList<BrandUploadFileDTO>();
		List<BrandUploadFile> entityList = brandUploadFileDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(BrandUploadFile entity : entityList) {
				BrandUploadFiles.add(BrandUploadFileUtil.getDtoFromEntity(entity));
			}
		}
		return BrandUploadFiles;
	}

	@Override
	public void create(BrandUploadFileDTO dto) {
		brandUploadFileDAO.create(BrandUploadFileUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BrandUploadFileDTO dto) {
		brandUploadFileDAO.delete(BrandUploadFileUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BrandUploadFileDTO dto) {
		brandUploadFileDAO.update(BrandUploadFileUtil.getEntityFromDto(dto));
	}

	public BrandUploadFileDAO getBrandUploadFileDAO() {
		return brandUploadFileDAO;
	}

	public void setBrandUploadFileDAO(BrandUploadFileDAO BrandUploadFileDAO) {
		this.brandUploadFileDAO = BrandUploadFileDAO;
	}
}
