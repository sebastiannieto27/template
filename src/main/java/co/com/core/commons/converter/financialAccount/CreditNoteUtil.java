package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.CreditNote;
import co.com.core.dto.financial.account.CreditNoteDTO;

public class CreditNoteUtil {

	public static CreditNoteDTO getDtoFromEntity(CreditNote entity) {
		CreditNoteDTO dto = new CreditNoteDTO();
		dto.setCreditNoteId(entity.getCreditNoteId());
		dto.setBillHeadId(entity.getBillHeadId());
		dto.setBranchClientId(entity.getBranchClientId());
		dto.setCreditNotDate(entity.getCreditNotDate());
		dto.setCreditNoteTypeId(entity.getCreditNoteTypeId());
		dto.setCreditNotNum(entity.getCreditNotNum());
		dto.setCreditNotValue(entity.getCreditNotValue());
		return dto;
	}
	
	public static CreditNote getEntityFromDto(CreditNoteDTO dto) {
		CreditNote entity = new CreditNote();
		entity.setCreditNoteId(dto.getCreditNoteId());
		entity.setBillHeadId(dto.getBillHeadId());
		entity.setBranchClientId(dto.getBranchClientId());
		entity.setCreditNotDate(dto.getCreditNotDate());
		entity.setCreditNoteTypeId(dto.getCreditNoteTypeId());
		entity.setCreditNotNum(dto.getCreditNotNum());
		entity.setCreditNotValue(dto.getCreditNotValue());
		return entity;
	}
}
