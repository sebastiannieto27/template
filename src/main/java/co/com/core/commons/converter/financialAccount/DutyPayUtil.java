package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.DutyPay;
import co.com.core.dto.financial.account.DutyPayDTO;

public class DutyPayUtil {

	public static DutyPayDTO getDtoFromEntity(DutyPay entity) {
		DutyPayDTO dto = new DutyPayDTO();
		dto.setDutyApyId(entity.getDutyApyId());
		dto.setBranchClientId(entity.getBranchClientId());
		dto.setDutyPayDate(entity.getDutyPayDate());
		dto.setDutyPayNum(entity.getDutyPayNum());
		dto.setDutyPayValue(entity.getDutyPayValue());
		return dto;
	}
	
	public static DutyPay getEntityFromDto(DutyPayDTO dto) {
		DutyPay entity = new DutyPay();
		entity.setDutyApyId(dto.getDutyApyId());
		entity.setBranchClientId(dto.getBranchClientId());
		entity.setDutyPayDate(dto.getDutyPayDate());
		entity.setDutyPayNum(dto.getDutyPayNum());
		entity.setDutyPayValue(dto.getDutyPayValue());
		return entity;
	}
}
