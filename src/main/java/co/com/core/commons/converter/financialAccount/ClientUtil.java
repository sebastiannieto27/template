package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.Client;
import co.com.core.dto.financial.account.ClientDTO;

public class ClientUtil {

	public static ClientDTO getDtoFromEntity(Client entity) {
		ClientDTO dto = new ClientDTO();
		dto.setClientId(entity.getClientId());
		dto.setClientIntCode(entity.getClientIntCode());
		dto.setClientName(entity.getClientName());
		dto.setClientAddress(entity.getClientAddress());
		dto.setClientDv(entity.getClientDv());
		dto.setClientMail(entity.getClientMail());
		dto.setClientNumId(entity.getClientNumId());
		dto.setClientTypeId(entity.getClientTypeId());
		
		return dto;
	}
	
	public static Client getEntityFromDto(ClientDTO dto) {
		Client entity = new Client();
		entity.setClientId(dto.getClientId());
		entity.setClientIntCode(dto.getClientIntCode());
		entity.setClientName(dto.getClientName());
		entity.setClientAddress(dto.getClientAddress());
		entity.setClientDv(dto.getClientDv());
		entity.setClientMail(dto.getClientMail());
		entity.setClientNumId(dto.getClientNumId());
		entity.setClientTypeId(dto.getClientTypeId());
		return entity;
	}
}
