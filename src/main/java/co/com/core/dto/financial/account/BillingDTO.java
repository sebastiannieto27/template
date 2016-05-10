package co.com.core.dto.financial.account;

import java.util.Date;

public class BillingDTO {

	private String billNumber;
	private Date billDate;
	private double rawValue;
	private double netValue;
	private double ivaTax;
	
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public double getRawValue() {
		return rawValue;
	}
	public void setRawValue(double rawValue) {
		this.rawValue = rawValue;
	}
	public double getNetValue() {
		return netValue;
	}
	public void setNetValue(double netValue) {
		this.netValue = netValue;
	}
	public double getIvaTax() {
		return ivaTax;
	}
	public void setIvaTax(double ivaTax) {
		this.ivaTax = ivaTax;
	}
	@Override
	public String toString() {
		return "BillingDTO [billNumber=" + billNumber + ", billDate="
				+ billDate + ", rawValue=" + rawValue + ", netValue="
				+ netValue + ", ivaTax=" + ivaTax + "]";
	}
}
