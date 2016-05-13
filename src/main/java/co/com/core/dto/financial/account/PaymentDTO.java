package co.com.core.dto.financial.account;

import java.util.Date;

public class PaymentDTO {

	private String paymentNumber;
	private Date paymentDate;
	private double paymentValue;
	private String description;
	private String paymentType;
	
	public String getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getPaymentValue() {
		return paymentValue;
	}
	public void setPaymentValue(double paymentValue) {
		this.paymentValue = paymentValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "PaymentsDTO [paymentNumber=" + paymentNumber + ", paymentDate="
				+ paymentDate + ", paymentValue=" + paymentValue
				+ ", description=" + description + "]";
	}
}
