package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.CreditNoteType;
import co.com.core.dto.financial.account.CreditNoteTypeDTO;

public class CreditNoteTypeUtil {

	public static CreditNoteTypeDTO getDtoFromEntity(CreditNoteType entity) {
		CreditNoteTypeDTO dto = new CreditNoteTypeDTO();
		dto.setCreditNoteTypeId(entity.getCreditNoteTypeId());
		dto.setCreditNotTypeName(entity.getCreditNotTypeName());
		return dto;
	}
	
	public static CreditNoteType getEntityFromDto(CreditNoteTypeDTO dto) {
		CreditNoteType entity = new CreditNoteType();
		entity.setCreditNoteTypeId(dto.getCreditNoteTypeId());
		entity.setCreditNotTypeName(dto.getCreditNotTypeName());
		return entity;
	}
}
