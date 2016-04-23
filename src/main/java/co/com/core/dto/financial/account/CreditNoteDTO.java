package co.com.core.dto.financial.account;

import java.util.Date;

import co.com.core.domain.financial.account.BillHead;
import co.com.core.domain.financial.account.BranchClient;
import co.com.core.domain.financial.account.CreditNoteType;

public class CreditNoteDTO {
    private Integer creditNoteId;
    private Long creditNotValue;
    private String creditNotNum;
    private Date creditNotDate;
    private BranchClient branchClientId;
    private BillHead billHeadId;
    private CreditNoteType creditNoteTypeId;
    
	public Integer getCreditNoteId() {
		return creditNoteId;
	}
	public void setCreditNoteId(Integer creditNoteId) {
		this.creditNoteId = creditNoteId;
	}
	public Long getCreditNotValue() {
		return creditNotValue;
	}
	public void setCreditNotValue(Long creditNotValue) {
		this.creditNotValue = creditNotValue;
	}
	public String getCreditNotNum() {
		return creditNotNum;
	}
	public void setCreditNotNum(String creditNotNum) {
		this.creditNotNum = creditNotNum;
	}
	public Date getCreditNotDate() {
		return creditNotDate;
	}
	public void setCreditNotDate(Date creditNotDate) {
		this.creditNotDate = creditNotDate;
	}
	public BranchClient getBranchClientId() {
		return branchClientId;
	}
	public void setBranchClientId(BranchClient branchClientId) {
		this.branchClientId = branchClientId;
	}
	public BillHead getBillHeadId() {
		return billHeadId;
	}
	public void setBillHeadId(BillHead billHeadId) {
		this.billHeadId = billHeadId;
	}
	public CreditNoteType getCreditNoteTypeId() {
		return creditNoteTypeId;
	}
	public void setCreditNoteTypeId(CreditNoteType creditNoteTypeId) {
		this.creditNoteTypeId = creditNoteTypeId;
	}
    
    
}
