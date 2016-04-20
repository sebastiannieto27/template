package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.Branch;
import co.com.core.dto.cms.BranchDTO;

public class BranchUtil {

	public static BranchDTO getDtoFromEntity(Branch entity) {
		BranchDTO dto = new BranchDTO();
		dto.setBranchAddress(entity.getBranchAddress());
		dto.setBranchBigImg(entity.getBranchBigImg());
		dto.setBranchId(entity.getBranchId());
		dto.setBranchName(entity.getBranchName());
		dto.setBranchOpenHours(entity.getBranchOpenHours());
		dto.setBranchThumbImg(entity.getBranchThumbImg());
		dto.setBranchTypeId(entity.getBranchTypeId());
		dto.setDateCre(entity.getDateCre());
		dto.setUserId(entity.getUserId());
		dto.setBranchMainPhone(entity.getBranchMainPhone());
		dto.setBranchAltPhone(entity.getBranchAltPhone());
		dto.setBranchInternalCode(entity.getBranchInternalCode());
		dto.setGeneralStatusId(entity.getGeneralStatusId());
		
		return dto;
	}
	
	public static Branch getEntityFromDto(BranchDTO dto) {
		Branch entity = new Branch();
		entity.setBranchAddress(dto.getBranchAddress());
		entity.setBranchBigImg(dto.getBranchBigImg());
		entity.setBranchId(dto.getBranchId());
		entity.setBranchName(dto.getBranchName());
		entity.setBranchOpenHours(dto.getBranchOpenHours());
		entity.setBranchThumbImg(dto.getBranchThumbImg());
		entity.setBranchTypeId(dto.getBranchTypeId());
		entity.setDateCre(dto.getDateCre());
		entity.setUserId(dto.getUserId());
		entity.setBranchMainPhone(dto.getBranchMainPhone());
		entity.setBranchAltPhone(dto.getBranchAltPhone());
		entity.setBranchInternalCode(dto.getBranchInternalCode());
		entity.setGeneralStatusId(dto.getGeneralStatusId());
		return entity;
	}
}
