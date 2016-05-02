package co.com.core.dto.financial.account;


public class AccountAgeTypeDTO {
	
    private Integer accountAgeTypeId;
    private String accountAgeTypeName;
    private int accountAgeTypeBegin;
    private int accountAgeTypeEnd;
    
    
    
	public AccountAgeTypeDTO() {
		super();
	}

	public AccountAgeTypeDTO(Integer accountAgeTypeId,
			String accountAgeTypeName, int accountAgeTypeBegin,
			int accountAgeTypeEnd) {
		super();
		this.accountAgeTypeId = accountAgeTypeId;
		this.accountAgeTypeName = accountAgeTypeName;
		this.accountAgeTypeBegin = accountAgeTypeBegin;
		this.accountAgeTypeEnd = accountAgeTypeEnd;
	}
	
	public Integer getAccountAgeTypeId() {
		return accountAgeTypeId;
	}
	public void setAccountAgeTypeId(Integer accountAgeTypeId) {
		this.accountAgeTypeId = accountAgeTypeId;
	}
	public String getAccountAgeTypeName() {
		return accountAgeTypeName;
	}
	public void setAccountAgeTypeName(String accountAgeTypeName) {
		this.accountAgeTypeName = accountAgeTypeName;
	}
	public int getAccountAgeTypeBegin() {
		return accountAgeTypeBegin;
	}
	public void setAccountAgeTypeBegin(int accountAgeTypeBegin) {
		this.accountAgeTypeBegin = accountAgeTypeBegin;
	}
	public int getAccountAgeTypeEnd() {
		return accountAgeTypeEnd;
	}
	public void setAccountAgeTypeEnd(int accountAgeTypeEnd) {
		this.accountAgeTypeEnd = accountAgeTypeEnd;
	}
    
    
}
