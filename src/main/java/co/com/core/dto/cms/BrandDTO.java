package co.com.core.dto.cms;

import java.util.Date;

import co.com.core.domain.User;
import co.com.core.domain.cms.BrandType;

public class BrandDTO {
	
	private Integer brandId;
    private String brandName;
    private String brandAddress;
    private String brandThumbImg;
    private String brandBigImg;
    private String brandOpenHours;
    private Date dateCre;
    private User userId;
    private BrandType brandTypeId;
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandAddress() {
		return brandAddress;
	}
	public void setBrandAddress(String brandAddress) {
		this.brandAddress = brandAddress;
	}
	public String getBrandThumbImg() {
		return brandThumbImg;
	}
	public void setBrandThumbImg(String brandThumbImg) {
		this.brandThumbImg = brandThumbImg;
	}
	public String getBrandBigImg() {
		return brandBigImg;
	}
	public void setBrandBigImg(String brandBigImg) {
		this.brandBigImg = brandBigImg;
	}
	public String getBrandOpenHours() {
		return brandOpenHours;
	}
	public void setBrandOpenHours(String brandOpenHours) {
		this.brandOpenHours = brandOpenHours;
	}
	public Date getDateCre() {
		return dateCre;
	}
	public void setDateCre(Date dateCre) {
		this.dateCre = dateCre;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public BrandType getBrandTypeId() {
		return brandTypeId;
	}
	public void setBrandTypeId(BrandType brandTypeId) {
		this.brandTypeId = brandTypeId;
	}
	@Override
	public String toString() {
		return "BrandDTO [brandId=" + brandId + ", brandName=" + brandName
				+ ", brandAddress=" + brandAddress + ", brandThumbImg="
				+ brandThumbImg + ", brandBigImg=" + brandBigImg
				+ ", brandOpenHours=" + brandOpenHours + ", dateCre=" + dateCre
				+ ", userId=" + userId + ", brandTypeId=" + brandTypeId + "]";
	}
}
