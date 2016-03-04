package co.com.core.commons.converter;

import co.com.core.domain.UploadedFile;
import co.com.core.dto.UploadedFileDTO;

public class UploadedFileUtil {

	public static UploadedFileDTO getDtoFromEntity(UploadedFile entity) {
		UploadedFileDTO dto = new UploadedFileDTO();
		dto.setCreationDate(entity.getCreationDate());
		dto.setName(entity.getName());
		dto.setSize(entity.getSize());
		dto.setUploadedFileId(entity.getUploadedFileId());
		dto.setUserId(entity.getUserId());
		return dto;
	}
	
	public static UploadedFile getEntityFromDto(UploadedFileDTO dto) {
		UploadedFile entity = new UploadedFile();
		entity.setCreationDate(dto.getCreationDate());
		entity.setName(dto.getName());
		entity.setSize(dto.getSize());
		entity.setUploadedFileId(dto.getUploadedFileId());
		entity.setUserId(dto.getUserId());
		return entity;
	}
}
