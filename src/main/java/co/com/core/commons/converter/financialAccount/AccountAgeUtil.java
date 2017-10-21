package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.AccountAge;
import co.com.core.dto.financial.account.AccountAgeDTO;

public class AccountAgeUtil {

	public static AccountAgeDTO getDtoFromEntity(AccountAge entity) {
		AccountAgeDTO dto = new AccountAgeDTO();
		dto.setAccountAgeId(entity.getAccountAgeId());
		dto.setBranchClientId(entity.getBranchClientId());
		dto.setClientId(entity.getClientId());
		return dto;
	}
	
	public static AccountAge getEntityFromDto(AccountAgeDTO dto) {
		AccountAge entity = new AccountAge();
		entity.setAccountAgeId(dto.getAccountAgeId());
		entity.setBranchClientId(dto.getBranchClientId());
		entity.setClientId(dto.getClientId());
		return entity;
	}
}
