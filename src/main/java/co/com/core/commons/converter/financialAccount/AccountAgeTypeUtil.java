package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.AccountAgeType;
import co.com.core.dto.financial.account.AccountAgeTypeDTO;

public class AccountAgeTypeUtil {

	public static AccountAgeTypeDTO getDtoFromEntity(AccountAgeType entity) {
		AccountAgeTypeDTO dto = new AccountAgeTypeDTO();
		dto.setAccountAgeTypeId(entity.getAccountAgeTypeId());
		dto.setAccountAgeTypeName(entity.getAccountAgeTypeName());
		dto.setAccountAgeTypeBegin(entity.getAccountAgeTypeBegin());
		dto.setAccountAgeTypeEnd(entity.getAccountAgeTypeEnd());
		
		return dto;
	}
	
	public static AccountAgeType getEntityFromDto(AccountAgeTypeDTO dto) {
		AccountAgeType entity = new AccountAgeType();
		entity.setAccountAgeTypeId(dto.getAccountAgeTypeId());
		entity.setAccountAgeTypeName(dto.getAccountAgeTypeName());
		entity.setAccountAgeTypeBegin(dto.getAccountAgeTypeBegin());
		entity.setAccountAgeTypeEnd(dto.getAccountAgeTypeEnd());
		return entity;
	}
}
