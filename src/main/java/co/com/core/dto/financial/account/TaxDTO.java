package co.com.core.dto.financial.account;


public class TaxDTO {
	
	private Integer taxId;
    private String taxName;
    private Integer taxPercentage;
    private Long taxValue;
    private String taxIntCode;
    
	public Integer getTaxId() {
		return taxId;
	}
	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public Integer getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(Integer taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	public Long getTaxValue() {
		return taxValue;
	}
	public void setTaxValue(Long taxValue) {
		this.taxValue = taxValue;
	}
	public String getTaxIntCode() {
		return taxIntCode;
	}
	public void setTaxIntCode(String taxIntCode) {
		this.taxIntCode = taxIntCode;
	}
	@Override
	public String toString() {
		return "TaxDTO [taxId=" + taxId + ", taxName=" + taxName
				+ ", taxPercentage=" + taxPercentage + ", taxValue=" + taxValue
				+ ", taxIntCode=" + taxIntCode + "]";
	}
}
