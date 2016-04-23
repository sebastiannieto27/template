package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.CreditNote;

public interface CreditNoteDAO {

	public List<CreditNote> getAllFilter(Map<String, Object> filter);
	
	public List<CreditNote> getAll();
	
	public CreditNote create(CreditNote entity);
	
	public void delete(CreditNote entity);
	
	public void update(CreditNote entity);
}
