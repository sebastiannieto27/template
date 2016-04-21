package co.com.core.dto.financial.account;

import co.com.core.domain.financial.account.Client;

public class BranchClientDTO {
	private Integer branchClientId;
    private String branchClName;
    private String branchClIntCode;
    private String branchClAddress;
    private String branchClPhone;
    private Client clientId;
	public Integer getBranchClientId() {
		return branchClientId;
	}
	public void setBranchClientId(Integer branchClientId) {
		this.branchClientId = branchClientId;
	}
	public String getBranchClName() {
		return branchClName;
	}
	public void setBranchClName(String branchClName) {
		this.branchClName = branchClName;
	}
	public String getBranchClIntCode() {
		return branchClIntCode;
	}
	public void setBranchClIntCode(String branchClIntCode) {
		this.branchClIntCode = branchClIntCode;
	}
	public String getBranchClAddress() {
		return branchClAddress;
	}
	public void setBranchClAddress(String branchClAddress) {
		this.branchClAddress = branchClAddress;
	}
	public String getBranchClPhone() {
		return branchClPhone;
	}
	public void setBranchClPhone(String branchClPhone) {
		this.branchClPhone = branchClPhone;
	}
	public Client getClientId() {
		return clientId;
	}
	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "BranchClientDTO [branchClientId=" + branchClientId
				+ ", branchClName=" + branchClName + ", branchClIntCode="
				+ branchClIntCode + ", branchClAddress=" + branchClAddress
				+ ", branchClPhone=" + branchClPhone + ", clientId=" + clientId
				+ "]";
	}
}
