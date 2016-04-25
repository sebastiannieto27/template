package co.com.core.dto.financial.account;

import co.com.core.domain.financial.account.BillDetail;
import co.com.core.domain.financial.account.Tax;

public class BillDetailTaxDTO {
    private Integer billDetailTaxId;
    private Long billDetailTaxVal;
    private BillDetail billDetailId;
    private Tax taxId;
    
	public Integer getBillDetailTaxId() {
		return billDetailTaxId;
	}
	public void setBillDetailTaxId(Integer billDetailTaxId) {
		this.billDetailTaxId = billDetailTaxId;
	}
	public Long getBillDetailTaxVal() {
		return billDetailTaxVal;
	}
	public void setBillDetailTaxVal(Long billDetailTaxVal) {
		this.billDetailTaxVal = billDetailTaxVal;
	}
	public BillDetail getBillDetailId() {
		return billDetailId;
	}
	public void setBillDetailId(BillDetail billDetailId) {
		this.billDetailId = billDetailId;
	}
	public Tax getTaxId() {
		return taxId;
	}
	public void setTaxId(Tax taxId) {
		this.taxId = taxId;
	}
	@Override
	public String toString() {
		return "BillDetailTaxDTO [billDetailTaxId=" + billDetailTaxId
				+ ", billDetailTaxVal=" + billDetailTaxVal + ", billDetailId="
				+ billDetailId + ", taxId=" + taxId + "]";
	}
}
