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

public class CompanyEventDTO {
	 private Integer companyEventId;
	    
	    private String companyEventTitle;
	    
	    private String companyEventLocation;
	   
	    private String companyEventDesc;
	    
	    private String companyEventThumbImg;
	    
	    private String companyEventBigImg;
	    
	    private Date dateCre;
	    
	    private User userId;

		public Integer getCompanyEventId() {
			return companyEventId;
		}

		public void setCompanyEventId(Integer companyEventId) {
			this.companyEventId = companyEventId;
		}

		public String getCompanyEventTitle() {
			return companyEventTitle;
		}

		public void setCompanyEventTitle(String companyEventTitle) {
			this.companyEventTitle = companyEventTitle;
		}

		public String getCompanyEventLocation() {
			return companyEventLocation;
		}

		public void setCompanyEventLocation(String companyEventLocation) {
			this.companyEventLocation = companyEventLocation;
		}

		public String getCompanyEventDesc() {
			return companyEventDesc;
		}

		public void setCompanyEventDesc(String companyEventDesc) {
			this.companyEventDesc = companyEventDesc;
		}

		public String getCompanyEventThumbImg() {
			return companyEventThumbImg;
		}

		public void setCompanyEventThumbImg(String companyEventThumbImg) {
			this.companyEventThumbImg = companyEventThumbImg;
		}

		public String getCompanyEventBigImg() {
			return companyEventBigImg;
		}

		public void setCompanyEventBigImg(String companyEventBigImg) {
			this.companyEventBigImg = companyEventBigImg;
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

		@Override
		public String toString() {
			return "CompanyEventDTO [companyEventId=" + companyEventId
					+ ", companyEventTitle=" + companyEventTitle
					+ ", companyEventLocation=" + companyEventLocation
					+ ", companyEventDesc=" + companyEventDesc
					+ ", companyEventThumbImg=" + companyEventThumbImg
					+ ", companyEventBigImg=" + companyEventBigImg
					+ ", dateCre=" + dateCre + ", userId=" + userId + "]";
		}
	
}
