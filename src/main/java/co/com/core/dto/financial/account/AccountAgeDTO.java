package co.com.core.dto.financial.account;

import co.com.core.domain.financial.account.BranchClient;
import co.com.core.domain.financial.account.Client;
import co.com.core.dto.IBaseDTO;

public class AccountAgeDTO implements IBaseDTO {
	
    private Integer accountAgeId;
    private BranchClient branchClientId;
    private Client clientId;
    
	public AccountAgeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountAgeDTO(Integer accountAgeId, BranchClient branchClientId,
			Client clientId) {
		super();
		this.accountAgeId = accountAgeId;
		this.branchClientId = branchClientId;
		this.clientId = clientId;
	}
	
	public Integer getAccountAgeId() {
		return accountAgeId;
	}
	public void setAccountAgeId(Integer accountAgeId) {
		this.accountAgeId = accountAgeId;
	}
	public BranchClient getBranchClientId() {
		return branchClientId;
	}
	public void setBranchClientId(BranchClient branchClientId) {
		this.branchClientId = branchClientId;
	}
	public Client getClientId() {
		return clientId;
	}
	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}
	
	@Override
	public String toString() {
		return "AccountAgeDTO [accountAgeId=" + accountAgeId + ", branchClientId=" + branchClientId + ", clientId="
				+ clientId + "]";
	}

}
