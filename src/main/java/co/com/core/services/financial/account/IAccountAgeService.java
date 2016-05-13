package co.com.core.services.financial.account;

import java.util.List;

import co.com.core.dto.financial.account.AccountAgeDTO;

public interface IAccountAgeService {
	
	public List<AccountAgeDTO> getAll(); 
	
	public void proofConcept();
	
}