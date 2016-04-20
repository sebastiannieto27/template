package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.RaiseMoneyType;
import co.com.core.dto.financial.account.RaiseMoneyTypeDTO;

public class RaiseMoneyTypeUtil {

	public static RaiseMoneyTypeDTO getDtoFromEntity(RaiseMoneyType entity) {
		RaiseMoneyTypeDTO dto = new RaiseMoneyTypeDTO();
		dto.setRaiseMoneyTypeId(entity.getRaiseMoneyTypeId());
		dto.setRaiseMonTypeName(entity.getRaiseMonTypeName());
		return dto;
	}
	
	public static RaiseMoneyType getEntityFromDto(RaiseMoneyTypeDTO dto) {
		RaiseMoneyType entity = new RaiseMoneyType();
		entity.setRaiseMoneyTypeId(dto.getRaiseMoneyTypeId());
		entity.setRaiseMonTypeName(dto.getRaiseMonTypeName());
		return entity;
	}
}
