package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.BranchType;
import co.com.core.dto.cms.BranchTypeDTO;

public class BranchTypeUtil {

	public static BranchTypeDTO getDtoFromEntity(BranchType entity) {
		BranchTypeDTO dto = new BranchTypeDTO();
		dto.setBranchTypeId(entity.getBranchTypeId());
		dto.setBranchTypeName(entity.getBranchTypeName());
		return dto;
	}
	
	public static BranchType getEntityFromDto(BranchTypeDTO dto) {
		BranchType entity = new BranchType();
		entity.setBranchTypeId(dto.getBranchTypeId());
		entity.setBranchTypeName(dto.getBranchTypeName());
		return entity;
	}
}
