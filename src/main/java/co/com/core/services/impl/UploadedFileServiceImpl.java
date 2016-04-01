package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.UploadedFileUtil;
import co.com.core.dao.UploadedFileDAO;
import co.com.core.domain.UploadedFile;
import co.com.core.dto.UploadedFileDTO;
import co.com.core.services.IUploadedFileService;

public class UploadedFileServiceImpl implements IUploadedFileService {

	private static final Logger logger = Logger.getLogger(UploadedFileServiceImpl.class);
	UploadedFileDAO uploadedFileDAO;
	
	@Override
	public List<UploadedFileDTO> getAll() {
		List<UploadedFileDTO> dtoList = new ArrayList<UploadedFileDTO>();
		List<UploadedFile> entityList = uploadedFileDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(UploadedFile UploadedFile : entityList) {
				dtoList.add(UploadedFileUtil.getDtoFromEntity(UploadedFile));
			}
		}
		return dtoList;
	}

	@Override
	public UploadedFile create(UploadedFileDTO dto) {
		return uploadedFileDAO.create(UploadedFileUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(UploadedFileDTO dto) {
		uploadedFileDAO.delete(UploadedFileUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(UploadedFileDTO dto) {
		uploadedFileDAO.update(UploadedFileUtil.getEntityFromDto(dto));
	}

	public UploadedFileDAO getUploadedFileDAO() {
		return uploadedFileDAO;
	}

	public void setUploadedFileDAO(UploadedFileDAO UploadedFileDAO) {
		this.uploadedFileDAO = UploadedFileDAO;
	}
}
