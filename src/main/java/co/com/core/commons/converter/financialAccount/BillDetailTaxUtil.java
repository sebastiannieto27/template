package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.BillDetailTax;
import co.com.core.dto.financial.account.BillDetailTaxDTO;

public class BillDetailTaxUtil {

	public static BillDetailTaxDTO getDtoFromEntity(BillDetailTax entity) {
		BillDetailTaxDTO dto = new BillDetailTaxDTO();
		dto.setBillDetailTaxId(entity.getBillDetailTaxId());
		dto.setBillDetailId(entity.getBillDetailId());
		dto.setBillDetailTaxVal(entity.getBillDetailTaxVal());
		dto.setTaxId(entity.getTaxId());
		
		return dto;
	}
	
	public static BillDetailTax getEntityFromDto(BillDetailTaxDTO dto) {
		BillDetailTax entity = new BillDetailTax();
		entity.setBillDetailTaxId(dto.getBillDetailTaxId());
		entity.setBillDetailId(dto.getBillDetailId());
		entity.setBillDetailTaxVal(dto.getBillDetailTaxVal());
		entity.setTaxId(dto.getTaxId());
		return entity;
	}
}
