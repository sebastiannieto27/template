package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.BranchService;
import co.com.core.dto.cms.BranchServiceDTO;

public class BranchServiceUtil {

	public static BranchServiceDTO getDtoFromEntity(BranchService entity) {
		BranchServiceDTO dto = new BranchServiceDTO();
		dto.setBranchServiceId(entity.getBranchServiceId());
		dto.setDateCre(entity.getDateCre());
		dto.setServiceId(entity.getServiceId());
		dto.setBranchId(entity.getBranchId());
		dto.setUserId(entity.getUserId());
		return dto;
	}
	
	public static BranchService getEntityFromDto(BranchServiceDTO dto) {
		BranchService entity = new BranchService();
		entity.setBranchServiceId(dto.getBranchServiceId());
		entity.setDateCre(dto.getDateCre());
		entity.setServiceId(dto.getServiceId());
		entity.setBranchId(dto.getBranchId());
		entity.setUserId(dto.getUserId());
		return entity;
	}
}
