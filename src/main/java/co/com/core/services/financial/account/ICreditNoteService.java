package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.CreditNote;
import co.com.core.dto.financial.account.CreditNoteDTO;

public interface ICreditNoteService {

	public List<CreditNoteDTO> getAll(); 

	public List<CreditNoteDTO> getAllFilter(Map<String, Object> filter); 
	
	public CreditNote create(CreditNoteDTO dto);
	
	public void delete(CreditNoteDTO dto);
	
	public void update(CreditNoteDTO dto);

}
