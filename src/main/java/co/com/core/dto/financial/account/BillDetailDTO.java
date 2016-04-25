package co.com.core.dto.financial.account;

import co.com.core.domain.financial.account.BillHead;
import co.com.core.domain.financial.account.Product;

public class BillDetailDTO {
    private Integer billDetailId;
    private Long billDetailUnitVal;
    private Integer billDetailAmount;
    private Long billDetailTotValue;
    private BillHead billHeadId;
    private Product productId;
	public Integer getBillDetailId() {
		return billDetailId;
	}
	public void setBillDetailId(Integer billDetailId) {
		this.billDetailId = billDetailId;
	}
	public Long getBillDetailUnitVal() {
		return billDetailUnitVal;
	}
	public void setBillDetailUnitVal(Long billDetailUnitVal) {
		this.billDetailUnitVal = billDetailUnitVal;
	}
	public Integer getBillDetailAmount() {
		return billDetailAmount;
	}
	public void setBillDetailAmount(Integer billDetailAmount) {
		this.billDetailAmount = billDetailAmount;
	}
	public Long getBillDetailTotValue() {
		return billDetailTotValue;
	}
	public void setBillDetailTotValue(Long billDetailTotValue) {
		this.billDetailTotValue = billDetailTotValue;
	}
	public BillHead getBillHeadId() {
		return billHeadId;
	}
	public void setBillHeadId(BillHead billHeadId) {
		this.billHeadId = billHeadId;
	}
	public Product getProductId() {
		return productId;
	}
	public void setProductId(Product productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "BillDetailDTO [billDetailId=" + billDetailId
				+ ", billDetailUnitVal=" + billDetailUnitVal
				+ ", billDetailAmount=" + billDetailAmount
				+ ", billDetailTotValue=" + billDetailTotValue
				+ ", billHeadId=" + billHeadId + ", productId=" + productId
				+ "]";
	}
}
