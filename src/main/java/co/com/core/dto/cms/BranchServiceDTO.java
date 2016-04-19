package co.com.core.dto.cms;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import co.com.core.domain.User;
import co.com.core.domain.cms.Branch;
import co.com.core.domain.cms.Service;

public class BranchServiceDTO {
	
	 	private Integer branchServiceId;
	    private Date dateCre;
	    private Service serviceId;
	    private Branch branchId;
	    private User userId;
	    
		public Integer getBranchServiceId() {
			return branchServiceId;
		}
		public void setBranchServiceId(Integer branchServiceId) {
			this.branchServiceId = branchServiceId;
		}
		public Date getDateCre() {
			return dateCre;
		}
		public void setDateCre(Date dateCre) {
			this.dateCre = dateCre;
		}
		public Service getServiceId() {
			return serviceId;
		}
		public void setServiceId(Service serviceId) {
			this.serviceId = serviceId;
		}
		public Branch getBranchId() {
			return branchId;
		}
		public void setBranchId(Branch branchId) {
			this.branchId = branchId;
		}
		public User getUserId() {
			return userId;
		}
		public void setUserId(User userId) {
			this.userId = userId;
		}
		@Override
		public String toString() {
			return "BranchServiceDTO [branchServiceId=" + branchServiceId
					+ ", dateCre=" + dateCre + ", serviceId=" + serviceId
					+ ", branchId=" + branchId + ", userId=" + "]";
		}
    
	
}
