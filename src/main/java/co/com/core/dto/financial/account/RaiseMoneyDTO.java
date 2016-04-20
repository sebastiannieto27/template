package co.com.core.dto.financial.account;

import java.util.Date;

import co.com.core.domain.financial.account.BranchClient;
import co.com.core.domain.financial.account.RaiseMoneyType;

public class RaiseMoneyDTO {

	private Integer raiseMoneyId;
	private Long raiseMoneyAmount;
	private String raiseMoneyNum;
	private Date raiseMoneyDate;
	private BranchClient branchClientId;
	private RaiseMoneyType raiseMoneyTypeId;
	
	public Integer getRaiseMoneyId() {
		return raiseMoneyId;
	}
	public void setRaiseMoneyId(Integer raiseMoneyId) {
		this.raiseMoneyId = raiseMoneyId;
	}
	public Long getRaiseMoneyAmount() {
		return raiseMoneyAmount;
	}
	public void setRaiseMoneyAmount(Long raiseMoneyAmount) {
		this.raiseMoneyAmount = raiseMoneyAmount;
	}
	public String getRaiseMoneyNum() {
		return raiseMoneyNum;
	}
	public void setRaiseMoneyNum(String raiseMoneyNum) {
		this.raiseMoneyNum = raiseMoneyNum;
	}
	public Date getRaiseMoneyDate() {
		return raiseMoneyDate;
	}
	public void setRaiseMoneyDate(Date raiseMoneyDate) {
		this.raiseMoneyDate = raiseMoneyDate;
	}
	public BranchClient getBranchClientId() {
		return branchClientId;
	}
	public void setBranchClientId(BranchClient branchClientId) {
		this.branchClientId = branchClientId;
	}
	public RaiseMoneyType getRaiseMoneyTypeId() {
		return raiseMoneyTypeId;
	}
	public void setRaiseMoneyTypeId(RaiseMoneyType raiseMoneyTypeId) {
		this.raiseMoneyTypeId = raiseMoneyTypeId;
	}
	@Override
	public String toString() {
		return "RaiseMoneyDTO [raiseMoneyId=" + raiseMoneyId
				+ ", raiseMoneyAmount=" + raiseMoneyAmount + ", raiseMoneyNum="
				+ raiseMoneyNum + ", raiseMoneyDate=" + raiseMoneyDate
				+ ", branchClientId=" + branchClientId + ", raiseMoneyTypeId="
				+ raiseMoneyTypeId + "]";
	}
}
