package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.ClientType;
import co.com.core.dto.financial.account.ClientTypeDTO;

public class ClientTypeUtil {

	public static ClientTypeDTO getDtoFromEntity(ClientType entity) {
		ClientTypeDTO dto = new ClientTypeDTO();
		dto.setClientTypeId(entity.getClientTypeId());
		dto.setClientTypeName(entity.getClientTypeName());
		
		return dto;
	}
	
	public static ClientType getEntityFromDto(ClientTypeDTO dto) {
		ClientType entity = new ClientType();
		entity.setClientTypeId(dto.getClientTypeId());
		entity.setClientTypeName(dto.getClientTypeName());
		return entity;
	}
}
