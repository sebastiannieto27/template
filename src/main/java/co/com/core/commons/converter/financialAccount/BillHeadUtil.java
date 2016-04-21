package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.BillHead;
import co.com.core.dto.financial.account.BillHeadDTO;

public class BillHeadUtil {

	public static BillHeadDTO getDtoFromEntity(BillHead entity) {
		BillHeadDTO dto = new BillHeadDTO();
		dto.setBillHeadId(entity.getBillHeadId());
		dto.setBillHeadDate(entity.getBillHeadDate());
		dto.setBillHeadDiscValue(entity.getBillHeadDiscValue());
		dto.setBillHeadDue(entity.getBillHeadDue());
		dto.setBillHeadNum(entity.getBillHeadNum());
		dto.setBillHeadTaxValue(entity.getBillHeadTaxValue());
		dto.setBillHeadTotalValue(entity.getBillHeadTotalValue());
		dto.setBranchClientId(entity.getBranchClientId());
		dto.setGeneralStatusId(entity.getGeneralStatusId());
		return dto;
	}
	
	public static BillHead getEntityFromDto(BillHeadDTO dto) {
		BillHead entity = new BillHead();
		entity.setBillHeadId(dto.getBillHeadId());
		entity.setBillHeadDate(dto.getBillHeadDate());
		entity.setBillHeadDiscValue(dto.getBillHeadDiscValue());
		entity.setBillHeadDue(dto.getBillHeadDue());
		entity.setBillHeadNum(dto.getBillHeadNum());
		entity.setBillHeadTaxValue(dto.getBillHeadTaxValue());
		entity.setBillHeadTotalValue(dto.getBillHeadTotalValue());
		entity.setBranchClientId(dto.getBranchClientId());
		entity.setGeneralStatusId(dto.getGeneralStatusId());
		return entity;
	}
}
