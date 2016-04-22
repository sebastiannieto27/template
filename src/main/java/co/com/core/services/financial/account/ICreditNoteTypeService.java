package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.CreditNoteType;
import co.com.core.dto.financial.account.CreditNoteTypeDTO;

public interface ICreditNoteTypeService {

	public List<CreditNoteTypeDTO> getAll(); 

	public List<CreditNoteTypeDTO> getAllFilter(Map<String, Object> filter); 
	
	public CreditNoteType create(CreditNoteTypeDTO dto);
	
	public void delete(CreditNoteTypeDTO dto);
	
	public void update(CreditNoteTypeDTO dto);

}
