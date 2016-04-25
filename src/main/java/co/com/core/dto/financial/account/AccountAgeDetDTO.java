package co.com.core.dto.financial.account;

import co.com.core.domain.financial.account.AccountAge;
import co.com.core.domain.financial.account.AccountAgeType;

public class AccountAgeDetDTO {
	private Integer accountAgeDetId;
	private long accountAgeDetTotal;
	private int accountAgeDetAmo;
	private AccountAge accountAgeId;
	private AccountAgeType accountAgeTypeId;
	public Integer getAccountAgeDetId() {
		return accountAgeDetId;
	}
	public void setAccountAgeDetId(Integer accountAgeDetId) {
		this.accountAgeDetId = accountAgeDetId;
	}
	public long getAccountAgeDetTotal() {
		return accountAgeDetTotal;
	}
	public void setAccountAgeDetTotal(long accountAgeDetTotal) {
		this.accountAgeDetTotal = accountAgeDetTotal;
	}
	public int getAccountAgeDetAmo() {
		return accountAgeDetAmo;
	}
	public void setAccountAgeDetAmo(int accountAgeDetAmo) {
		this.accountAgeDetAmo = accountAgeDetAmo;
	}
	public AccountAge getAccountAgeId() {
		return accountAgeId;
	}
	public void setAccountAgeId(AccountAge accountAgeId) {
		this.accountAgeId = accountAgeId;
	}
	public AccountAgeType getAccountAgeTypeId() {
		return accountAgeTypeId;
	}
	public void setAccountAgeTypeId(AccountAgeType accountAgeTypeId) {
		this.accountAgeTypeId = accountAgeTypeId;
	}
	@Override
	public String toString() {
		return "AccountAgeDetDTO [accountAgeDetId=" + accountAgeDetId
				+ ", accountAgeDetTotal=" + accountAgeDetTotal
				+ ", accountAgeDetAmo=" + accountAgeDetAmo + ", accountAgeId="
				+ accountAgeId + ", accountAgeTypeId=" + accountAgeTypeId + "]";
	}
}
