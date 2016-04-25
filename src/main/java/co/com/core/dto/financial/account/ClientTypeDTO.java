package co.com.core.dto.financial.account;


public class ClientTypeDTO {
    private Integer clientTypeId;
    private String clientTypeName;
	public Integer getClientTypeId() {
		return clientTypeId;
	}
	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}
	public String getClientTypeName() {
		return clientTypeName;
	}
	public void setClientTypeName(String clientTypeName) {
		this.clientTypeName = clientTypeName;
	}
	@Override
	public String toString() {
		return "ClientTypeDTO [clientTypeId=" + clientTypeId
				+ ", clientTypeName=" + clientTypeName + "]";
	}
    
    
}
