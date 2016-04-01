package co.com.core.dto.cms;

import java.util.Date;

public class BrandTypeDTO {
	
	private Integer brandTypeId;
    private String brandTypeName;
    private int userId;
    private Date dateCre;
    
	public Integer getBrandTypeId() {
		return brandTypeId;
	}
	public void setBrandTypeId(Integer brandTypeId) {
		this.brandTypeId = brandTypeId;
	}
	public String getBrandTypeName() {
		return brandTypeName;
	}
	public void setBrandTypeName(String brandTypeName) {
		this.brandTypeName = brandTypeName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDateCre() {
		return dateCre;
	}
	public void setDateCre(Date dateCre) {
		this.dateCre = dateCre;
	}
	@Override
	public String toString() {
		return "BrandTypeDTO [brandTypeId=" + brandTypeId + ", brandTypeName="
				+ brandTypeName + ", userId=" + userId + ", dateCre=" + dateCre
				+ "]";
	}
}
