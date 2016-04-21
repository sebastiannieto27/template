package co.com.core.dto.financial.account;

import co.com.core.domain.financial.account.ClientType;

public class ClientDTO {

	private Integer clientId;
    private String clientIntCode;
    private String clientNumId;
    private String clientName;
    private String clientAddress;
    private Integer clientDv;
    private String clientMail;
    private ClientType clientTypeId;
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getClientIntCode() {
		return clientIntCode;
	}
	public void setClientIntCode(String clientIntCode) {
		this.clientIntCode = clientIntCode;
	}
	public String getClientNumId() {
		return clientNumId;
	}
	public void setClientNumId(String clientNumId) {
		this.clientNumId = clientNumId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public Integer getClientDv() {
		return clientDv;
	}
	public void setClientDv(Integer clientDv) {
		this.clientDv = clientDv;
	}
	public String getClientMail() {
		return clientMail;
	}
	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}
	public ClientType getClientTypeId() {
		return clientTypeId;
	}
	public void setClientTypeId(ClientType clientTypeId) {
		this.clientTypeId = clientTypeId;
	}
	@Override
	public String toString() {
		return "ClientDTO [clientId=" + clientId + ", clientIntCode="
				+ clientIntCode + ", clientNumId=" + clientNumId
				+ ", clientName=" + clientName + ", clientAddress="
				+ clientAddress + ", clientDv=" + clientDv + ", clientMail="
				+ clientMail + ", clientTypeId=" + clientTypeId + "]";
	}
}
