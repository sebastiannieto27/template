package co.com.core.commons.converter.cms;

import co.com.core.domain.cms.Service;
import co.com.core.dto.cms.ServiceDTO;

public class ServiceUtil {

	public static ServiceDTO getDtoFromEntity(Service entity) {
		ServiceDTO dto = new ServiceDTO();
		dto.setServiceId(entity.getServiceId());
		dto.setServiceName(entity.getServiceName());
		dto.setServiceDesc(entity.getServiceDesc());
		dto.setGeneralStatusId(entity.getGeneralStatusId());
		dto.setServiceImgPath(entity.getServiceImgPath());
		dto.setServiceThumbImgPath(entity.getServiceThumbImgPath());
		dto.setDateCre(entity.getDateCre());
		dto.setUserId(entity.getUserId());
		return dto;
	}
	
	public static Service getEntityFromDto(ServiceDTO dto) {
		Service entity = new Service();
		entity.setServiceId(dto.getServiceId());
		entity.setServiceName(dto.getServiceName());
		entity.setServiceDesc(dto.getServiceDesc());
		entity.setServiceImgPath(dto.getServiceImgPath());
		entity.setServiceThumbImgPath(dto.getServiceThumbImgPath());		
		entity.setGeneralStatusId(dto.getGeneralStatusId());
		entity.setDateCre(dto.getDateCre());
		entity.setUserId(dto.getUserId());
		return entity;
	}
}
