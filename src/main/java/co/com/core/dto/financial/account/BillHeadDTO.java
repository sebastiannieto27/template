package co.com.core.dto.financial.account;

import java.util.Date;

import co.com.core.domain.cms.GeneralStatus;
import co.com.core.domain.financial.account.BranchClient;

public class BillHeadDTO {
	private Integer billHeadId;
    private Long billHeadTotalValue;
    private Long billHeadTaxValue;
    private Long billHeadDiscValue;
    private String billHeadNum;
    private Date billHeadDate;
    private Date billHeadDue;
    private BranchClient branchClientId;
    private GeneralStatus generalStatusId;
	public Integer getBillHeadId() {
		return billHeadId;
	}
	public void setBillHeadId(Integer billHeadId) {
		this.billHeadId = billHeadId;
	}
	public Long getBillHeadTotalValue() {
		return billHeadTotalValue;
	}
	public void setBillHeadTotalValue(Long billHeadTotalValue) {
		this.billHeadTotalValue = billHeadTotalValue;
	}
	public Long getBillHeadTaxValue() {
		return billHeadTaxValue;
	}
	public void setBillHeadTaxValue(Long billHeadTaxValue) {
		this.billHeadTaxValue = billHeadTaxValue;
	}
	public Long getBillHeadDiscValue() {
		return billHeadDiscValue;
	}
	public void setBillHeadDiscValue(Long billHeadDiscValue) {
		this.billHeadDiscValue = billHeadDiscValue;
	}
	public String getBillHeadNum() {
		return billHeadNum;
	}
	public void setBillHeadNum(String billHeadNum) {
		this.billHeadNum = billHeadNum;
	}
	public Date getBillHeadDate() {
		return billHeadDate;
	}
	public void setBillHeadDate(Date billHeadDate) {
		this.billHeadDate = billHeadDate;
	}
	public Date getBillHeadDue() {
		return billHeadDue;
	}
	public void setBillHeadDue(Date billHeadDue) {
		this.billHeadDue = billHeadDue;
	}
	public BranchClient getBranchClientId() {
		return branchClientId;
	}
	public void setBranchClientId(BranchClient branchClientId) {
		this.branchClientId = branchClientId;
	}
	public GeneralStatus getGeneralStatusId() {
		return generalStatusId;
	}
	public void setGeneralStatusId(GeneralStatus generalStatusId) {
		this.generalStatusId = generalStatusId;
	}
	@Override
	public String toString() {
		return "BillHeadDTO [billHeadId=" + billHeadId
				+ ", billHeadTotalValue=" + billHeadTotalValue
				+ ", billHeadTaxValue=" + billHeadTaxValue
				+ ", billHeadDiscValue=" + billHeadDiscValue + ", billHeadNum="
				+ billHeadNum + ", billHeadDate=" + billHeadDate
				+ ", billHeadDue=" + billHeadDue + ", branchClientId="
				+ branchClientId + ", generalStatusId=" + generalStatusId + "]";
	}
}
