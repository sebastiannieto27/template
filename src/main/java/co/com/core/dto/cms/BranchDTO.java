package co.com.core.dto.cms;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.core.domain.User;
import co.com.core.domain.cms.BranchType;
import co.com.core.domain.cms.GeneralStatus;

public class BranchDTO {
	private Integer branchId;
    private String branchName;
    private String branchAddress;
    private String branchThumbImg;
    private String branchBigImg;
    private String branchOpenHours;
    private String branchMainPhone;
    private String branchAltPhone;
    private String branchInternalCode;
    private Date dateCre;
    private BranchType branchTypeId;
    private User userId;
    private GeneralStatus generalStatusId;
    
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	public String getBranchThumbImg() {
		return branchThumbImg;
	}
	public void setBranchThumbImg(String branchThumbImg) {
		this.branchThumbImg = branchThumbImg;
	}
	public String getBranchBigImg() {
		return branchBigImg;
	}
	public void setBranchBigImg(String branchBigImg) {
		this.branchBigImg = branchBigImg;
	}
	public String getBranchOpenHours() {
		return branchOpenHours;
	}
	public void setBranchOpenHours(String branchOpenHours) {
		this.branchOpenHours = branchOpenHours;
	}
	public String getBranchMainPhone() {
		return branchMainPhone;
	}
	public void setBranchMainPhone(String branchMainPhone) {
		this.branchMainPhone = branchMainPhone;
	}
	public String getBranchAltPhone() {
		return branchAltPhone;
	}
	public void setBranchAltPhone(String branchAltPhone) {
		this.branchAltPhone = branchAltPhone;
	}
	public String getBranchInternalCode() {
		return branchInternalCode;
	}
	public void setBranchInternalCode(String branchInternalCode) {
		this.branchInternalCode = branchInternalCode;
	}
	public Date getDateCre() {
		return dateCre;
	}
	public void setDateCre(Date dateCre) {
		this.dateCre = dateCre;
	}
	public BranchType getBranchTypeId() {
		return branchTypeId;
	}
	public void setBranchTypeId(BranchType branchTypeId) {
		this.branchTypeId = branchTypeId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public GeneralStatus getGeneralStatusId() {
		return generalStatusId;
	}
	public void setGeneralStatusId(GeneralStatus generalStatusId) {
		this.generalStatusId = generalStatusId;
	}
	@Override
	public String toString() {
		return "BranchDTO [branchId=" + branchId + ", branchName=" + branchName
				+ ", branchAddress=" + branchAddress + ", branchThumbImg="
				+ branchThumbImg + ", branchBigImg=" + branchBigImg
				+ ", branchOpenHours=" + branchOpenHours + ", branchMainPhone="
				+ branchMainPhone + ", branchAltPhone=" + branchAltPhone
				+ ", branchInternalCode=" + branchInternalCode + ", dateCre="
				+ dateCre + ", branchTypeId=" + branchTypeId + ", userId="
				 + ", generalStatusId=" + generalStatusId + "]";
	}
    
	
}
