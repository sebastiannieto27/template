package co.com.core.dto.financial.account;

import co.com.core.dto.IBaseDTO;

public class AccountAgeQueryDTO implements IBaseDTO {
	
	private Integer accountAgeId;
    private String internalCode;
    private String clientName;
    private long pendantValue;
    private long totalValue;
    private long ageTypeValue;
    private String billDetailText;
    
	public AccountAgeQueryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountAgeQueryDTO(Integer accountAgeId, String internalCode,
			String clientName, long pendantValue, long totalValue,
			long ageTypeValue, String billDetailText) {
		super();
		this.accountAgeId = accountAgeId;
		this.internalCode = internalCode;
		this.clientName = clientName;
		this.pendantValue = pendantValue;
		this.totalValue = totalValue;
		this.ageTypeValue = ageTypeValue;
		this.billDetailText = billDetailText;
	}

	public String getInternalCode() {
		return internalCode;
	}
	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public long getPendantValue() {
		return pendantValue;
	}
	public void setPendantValue(long pendantValue) {
		this.pendantValue = pendantValue;
	}
	public long getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(long totalValue) {
		this.totalValue = totalValue;
	}
	public long getAgeTypeValue() {
		return ageTypeValue;
	}
	public void setAgeTypeValue(long ageTypeValue) {
		this.ageTypeValue = ageTypeValue;
	}
	
	public Integer getAccountAgeId() {
		return accountAgeId;
	}

	public void setAccountAgeId(Integer accountAgeId) {
		this.accountAgeId = accountAgeId;
	}

	public String getBillDetailText() {
		return billDetailText;
	}

	public void setBillDetailText(String billDetailText) {
		this.billDetailText = billDetailText;
	}

	@Override
	public String toString() {
		return "AccountAgeQueryDTO [accountAgeId=" + accountAgeId
				+ ", internalCode=" + internalCode + ", clientName="
				+ clientName + ", pendantValue=" + pendantValue
				+ ", totalValue=" + totalValue + ", ageTypeValue="
				+ ageTypeValue + ", billDetailText=" + billDetailText + "]";
	}
    

}
