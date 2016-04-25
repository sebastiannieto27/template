package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.BillDetail;
import co.com.core.dto.financial.account.BillDetailDTO;

public class BillDetailUtil {

	public static BillDetailDTO getDtoFromEntity(BillDetail entity) {
		BillDetailDTO dto = new BillDetailDTO();
		dto.setBillDetailId(entity.getBillDetailId());
		dto.setBillDetailAmount(entity.getBillDetailAmount());
		dto.setBillDetailTotValue(entity.getBillDetailTotValue());
		dto.setBillDetailUnitVal(entity.getBillDetailUnitVal());
		dto.setBillHeadId(entity.getBillHeadId());
		dto.setProductId(entity.getProductId());
		
		return dto;
	}
	
	public static BillDetail getEntityFromDto(BillDetailDTO dto) {
		BillDetail entity = new BillDetail();
		entity.setBillDetailId(dto.getBillDetailId());
		entity.setBillDetailAmount(dto.getBillDetailAmount());
		entity.setBillDetailTotValue(dto.getBillDetailTotValue());
		entity.setBillDetailUnitVal(dto.getBillDetailUnitVal());
		entity.setBillHeadId(dto.getBillHeadId());
		entity.setProductId(dto.getProductId());
		return entity;
	}
}
