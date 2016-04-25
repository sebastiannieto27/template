package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.AccountAgeDet;
import co.com.core.dto.financial.account.AccountAgeDetDTO;

public class AccountAgeDetUtil {

	public static AccountAgeDetDTO getDtoFromEntity(AccountAgeDet entity) {
		AccountAgeDetDTO dto = new AccountAgeDetDTO();
		dto.setAccountAgeDetId(entity.getAccountAgeDetId());
		dto.setAccountAgeDetAmo(entity.getAccountAgeDetAmo());
		dto.setAccountAgeDetTotal(entity.getAccountAgeDetTotal());
		dto.setAccountAgeId(entity.getAccountAgeId());
		dto.setAccountAgeTypeId(entity.getAccountAgeTypeId());
		
		return dto;
	}
	
	public static AccountAgeDet getEntityFromDto(AccountAgeDetDTO dto) {
		AccountAgeDet entity = new AccountAgeDet();
		entity.setAccountAgeDetId(dto.getAccountAgeDetId());
		entity.setAccountAgeDetAmo(dto.getAccountAgeDetAmo());
		entity.setAccountAgeDetTotal(dto.getAccountAgeDetTotal());
		entity.setAccountAgeId(dto.getAccountAgeId());
		entity.setAccountAgeTypeId(dto.getAccountAgeTypeId());
		return entity;
	}
}
