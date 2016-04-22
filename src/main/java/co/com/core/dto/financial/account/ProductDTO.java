package co.com.core.dto.financial.account;


public class ProductDTO {

	private Integer productId;
    private String productName;
    private String productDesc;
    private String productIntCode;
    
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductIntCode() {
		return productIntCode;
	}
	public void setProductIntCode(String productIntCode) {
		this.productIntCode = productIntCode;
	}
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName="
				+ productName + ", productDesc=" + productDesc
				+ ", productIntCode=" + productIntCode + "]";
	}
}
