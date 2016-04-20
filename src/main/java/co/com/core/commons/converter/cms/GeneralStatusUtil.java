package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.GeneralStatus;
import co.com.core.dto.cms.GeneralStatusDTO;

public class GeneralStatusUtil {

	public static GeneralStatusDTO getDtoFromEntity(GeneralStatus entity) {
		GeneralStatusDTO dto = new GeneralStatusDTO();
		dto.setGeneralStatusId(entity.getGeneralStatusId());
		dto.setGeneralStatusName(entity.getGeneralStatusName());
		return dto;
	}
	
	public static GeneralStatus getEntityFromDto(GeneralStatusDTO dto) {
		GeneralStatus entity = new GeneralStatus();
		entity.setGeneralStatusId(dto.getGeneralStatusId());
		entity.setGeneralStatusName(dto.getGeneralStatusName());
		return entity;
	}
}
