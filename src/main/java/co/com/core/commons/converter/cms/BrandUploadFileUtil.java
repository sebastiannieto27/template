package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.BrandUploadFile;
import co.com.core.dto.cms.BrandUploadFileDTO;

public class BrandUploadFileUtil {

	public static BrandUploadFileDTO getDtoFromEntity(BrandUploadFile entity) {
		BrandUploadFileDTO dto = new BrandUploadFileDTO();
		dto.setBrandId(entity.getBrandId());
		dto.setBrandUploadFileId(entity.getBrandUploadFileId());
		dto.setUploadedFileId(entity.getUploadedFileId());
		return dto;
	}
	
	public static BrandUploadFile getEntityFromDto(BrandUploadFileDTO dto) {
		BrandUploadFile entity = new BrandUploadFile();
		entity.setBrandId(dto.getBrandId());
		entity.setBrandUploadFileId(dto.getBrandUploadFileId());
		entity.setUploadedFileId(dto.getUploadedFileId());
		return entity;
	}
}
