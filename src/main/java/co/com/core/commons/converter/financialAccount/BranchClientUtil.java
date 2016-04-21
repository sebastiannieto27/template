package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.BranchClient;
import co.com.core.dto.financial.account.BranchClientDTO;

public class BranchClientUtil {

	public static BranchClientDTO getDtoFromEntity(BranchClient entity) {
		BranchClientDTO dto = new BranchClientDTO();
		dto.setBranchClientId(entity.getBranchClientId());
		dto.setBranchClAddress(entity.getBranchClAddress());
		dto.setBranchClIntCode(entity.getBranchClIntCode());
		dto.setBranchClName(entity.getBranchClName());
		dto.setBranchClPhone(entity.getBranchClPhone());
		dto.setClientId(entity.getClientId());
		
		return dto;
	}
	
	public static BranchClient getEntityFromDto(BranchClientDTO dto) {
		BranchClient entity = new BranchClient();
		entity.setBranchClientId(dto.getBranchClientId());
		entity.setBranchClAddress(dto.getBranchClAddress());
		entity.setBranchClIntCode(dto.getBranchClIntCode());
		entity.setBranchClName(dto.getBranchClName());
		entity.setBranchClPhone(dto.getBranchClPhone());
		entity.setClientId(dto.getClientId());
		return entity;
	}
}
