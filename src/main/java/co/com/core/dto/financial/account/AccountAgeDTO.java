package co.com.core.dto.financial.account;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import co.com.core.domain.financial.account.BranchClient;
import co.com.core.domain.financial.account.Client;

public class AccountAgeDTO {
	
    private Integer accountAgeId;
    private BranchClient branchClientId;
    private Client clientId;
    
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
