package co.com.core.dto.financial.account;

public class RaiseMoneyTypeDTO {

	private Integer raiseMoneyTypeId;
	private String raiseMonTypeName;

	public Integer getRaiseMoneyTypeId() {
		return raiseMoneyTypeId;
	}

	public void setRaiseMoneyTypeId(Integer raiseMoneyTypeId) {
		this.raiseMoneyTypeId = raiseMoneyTypeId;
	}

	public String getRaiseMonTypeName() {
		return raiseMonTypeName;
	}

	public void setRaiseMonTypeName(String raiseMonTypeName) {
		this.raiseMonTypeName = raiseMonTypeName;
	}

	@Override
	public String toString() {
		return "RaiseMoneyTypeDTO [raiseMoneyTypeId=" + raiseMoneyTypeId
				+ ", raiseMonTypeName=" + raiseMonTypeName + "]";
	}

}
