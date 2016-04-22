package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.CreditNoteType;

public interface CreditNoteTypeDAO {

	public List<CreditNoteType> getAllFilter(Map<String, Object> filter);
	
	public List<CreditNoteType> getAll();
	
	public CreditNoteType create(CreditNoteType entity);
	
	public void delete(CreditNoteType entity);
	
	public void update(CreditNoteType entity);
}
