package co.com.core.dto.financial.account;

public class CreditNoteTypeDTO {
	private Integer creditNoteTypeId;
	private String creditNotTypeName;

	public Integer getCreditNoteTypeId() {
		return creditNoteTypeId;
	}

	public void setCreditNoteTypeId(Integer creditNoteTypeId) {
		this.creditNoteTypeId = creditNoteTypeId;
	}

	public String getCreditNotTypeName() {
		return creditNotTypeName;
	}

	public void setCreditNotTypeName(String creditNotTypeName) {
		this.creditNotTypeName = creditNotTypeName;
	}

	@Override
	public String toString() {
		return "CreditNoteType [creditNoteTypeId=" + creditNoteTypeId
				+ ", creditNotTypeName=" + creditNotTypeName + "]";
	}

}
