package co.com.core.dto.financial.account;

import java.util.Date;

public class AlbaranDTO {

	private String albaranNumber;
	private Date albaranDate;
	private double value;
	private String albaranType;
	
	public String getAlbaranNumber() {
		return albaranNumber;
	}
	public void setAlbaranNumber(String albaranNumber) {
		this.albaranNumber = albaranNumber;
	}
	public Date getAlbaranDate() {
		return albaranDate;
	}
	public void setAlbaranDate(Date albaranDate) {
		this.albaranDate = albaranDate;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getAlbaranType() {
		return albaranType;
	}
	public void setAlbaranType(String albaranType) {
		this.albaranType = albaranType;
	}
	@Override
	public String toString() {
		return "AlbaranDTO [albaranNumber=" + albaranNumber + ", albaranDate="
				+ albaranDate + ", value=" + value + ", albaranType="
				+ albaranType + "]";
	}
}
