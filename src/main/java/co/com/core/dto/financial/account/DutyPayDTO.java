package co.com.core.dto.financial.account;

import java.util.Date;

import co.com.core.domain.financial.account.BranchClient;

public class DutyPayDTO {

    private Integer dutyApyId;
    private Long dutyPayValue;
    private String dutyPayNum;
    private Date dutyPayDate;
    private BranchClient branchClientId;
    
	public Integer getDutyApyId() {
		return dutyApyId;
	}
	public void setDutyApyId(Integer dutyApyId) {
		this.dutyApyId = dutyApyId;
	}
	public Long getDutyPayValue() {
		return dutyPayValue;
	}
	public void setDutyPayValue(Long dutyPayValue) {
		this.dutyPayValue = dutyPayValue;
	}
	public String getDutyPayNum() {
		return dutyPayNum;
	}
	public void setDutyPayNum(String dutyPayNum) {
		this.dutyPayNum = dutyPayNum;
	}
	public Date getDutyPayDate() {
		return dutyPayDate;
	}
	public void setDutyPayDate(Date dutyPayDate) {
		this.dutyPayDate = dutyPayDate;
	}
	public BranchClient getBranchClientId() {
		return branchClientId;
	}
	public void setBranchClientId(BranchClient branchClientId) {
		this.branchClientId = branchClientId;
	}
	@Override
	public String toString() {
		return "DutyPayDTO [dutyApyId=" + dutyApyId + ", dutyPayValue="
				+ dutyPayValue + ", dutyPayNum=" + dutyPayNum
				+ ", dutyPayDate=" + dutyPayDate + ", branchClientId="
				+ branchClientId + "]";
	}
}
