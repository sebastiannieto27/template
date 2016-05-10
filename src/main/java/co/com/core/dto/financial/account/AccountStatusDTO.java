package co.com.core.dto.financial.account;

public class AccountStatusDTO {

	private Integer accountStatusId;
	private String billDate;
	private String billNumber;
	private String dueDate;
	private int expirationDays;
	private long pendantValue;
	private BranchClientDTO branchClient;
	
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getExpirationDays() {
		return expirationDays;
	}
	public void setExpirationDays(int expirationDays) {
		this.expirationDays = expirationDays;
	}
	public long getPendantValue() {
		return pendantValue;
	}
	public void setPendantValue(long pendantValue) {
		this.pendantValue = pendantValue;
	}
	public BranchClientDTO getBranchClient() {
		return branchClient;
	}
	public void setBranchClient(BranchClientDTO branchClient) {
		this.branchClient = branchClient;
	}
	
	public Integer getAccountStatusId() {
		return accountStatusId;
	}
	public void setAccountStatusId(Integer accountStatusId) {
		this.accountStatusId = accountStatusId;
	}
	@Override
	public String toString() {
		return "AccountStateDTO [billDate=" + billDate + ", billNumber="
				+ billNumber + ", dueDate=" + dueDate + ", expirationDays="
				+ expirationDays + ", pendantValue=" + pendantValue
				+ ", branchClient=" + branchClient + "]";
	}
}
