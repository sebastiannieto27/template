package co.com.core.commons.converter.financialAccount;

import co.com.core.domain.financial.account.Tax;
import co.com.core.dto.financial.account.TaxDTO;

public class TaxUtil {

	public static TaxDTO getDtoFromEntity(Tax entity) {
		TaxDTO dto = new TaxDTO();
		dto.setTaxId(entity.getTaxId());
		dto.setTaxIntCode(entity.getTaxIntCode());
		dto.setTaxName(entity.getTaxName());
		dto.setTaxPercentage(entity.getTaxPercentage());
		dto.setTaxValue(entity.getTaxValue());
		return dto;
	}
	
	public static Tax getEntityFromDto(TaxDTO dto) {
		Tax entity = new Tax();
		entity.setTaxId(dto.getTaxId());
		entity.setTaxIntCode(dto.getTaxIntCode());
		entity.setTaxName(dto.getTaxName());
		entity.setTaxPercentage(dto.getTaxPercentage());
		entity.setTaxValue(dto.getTaxValue());
		return entity;
	}
}
