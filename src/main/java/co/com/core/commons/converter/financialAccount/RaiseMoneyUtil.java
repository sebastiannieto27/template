package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.RaiseMoney;
import co.com.core.dto.financial.account.RaiseMoneyDTO;

public class RaiseMoneyUtil {

	public static RaiseMoneyDTO getDtoFromEntity(RaiseMoney entity) {
		RaiseMoneyDTO dto = new RaiseMoneyDTO();
		dto.setRaiseMoneyId(entity.getRaiseMoneyId());
		dto.setBranchClientId(entity.getBranchClientId());
		dto.setRaiseMoneyAmount(entity.getRaiseMoneyAmount());
		dto.setRaiseMoneyDate(entity.getRaiseMoneyDate());
		dto.setRaiseMoneyNum(entity.getRaiseMoneyNum());
		dto.setRaiseMoneyTypeId(entity.getRaiseMoneyTypeId());
		return dto;
	}
	
	public static RaiseMoney getEntityFromDto(RaiseMoneyDTO dto) {
		RaiseMoney entity = new RaiseMoney();
		entity.setRaiseMoneyId(dto.getRaiseMoneyId());
		entity.setBranchClientId(dto.getBranchClientId());
		entity.setRaiseMoneyAmount(dto.getRaiseMoneyAmount());
		entity.setRaiseMoneyDate(dto.getRaiseMoneyDate());
		entity.setRaiseMoneyNum(dto.getRaiseMoneyNum());
		entity.setRaiseMoneyTypeId(dto.getRaiseMoneyTypeId());
		return entity;
	}
}
