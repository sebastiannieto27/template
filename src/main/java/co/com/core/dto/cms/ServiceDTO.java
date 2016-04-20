package co.com.core.dto.cms;

import java.util.Date;

import co.com.core.domain.User;
import co.com.core.domain.cms.GeneralStatus;

public class ServiceDTO {
	
	private Integer serviceId;
    private String serviceName;
    private String serviceDesc;
    private String serviceImgPath;
    private String serviceThumbImgPath;
    private Date dateCre;
    private User userId;
    private GeneralStatus generalStatusId;
    
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
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
	public GeneralStatus getGeneralStatusId() {
		return generalStatusId;
	}
	public void setGeneralStatusId(GeneralStatus generalStatusId) {
		this.generalStatusId = generalStatusId;
	}
	
	public String getServiceImgPath() {
		return serviceImgPath;
	}
	public void setServiceImgPath(String serviceImgPath) {
		this.serviceImgPath = serviceImgPath;
	}
	public String getServiceThumbImgPath() {
		return serviceThumbImgPath;
	}
	public void setServiceThumbImgPath(String serviceThumbImgPath) {
		this.serviceThumbImgPath = serviceThumbImgPath;
	}
	@Override
	public String toString() {
		return "ServiceDTO [serviceId=" + serviceId + ", serviceName="
				+ serviceName + ", serviceDesc=" + serviceDesc + ", dateCre="
				+ dateCre + ", userId=" + userId + ", generalStatusId="
				+ generalStatusId + "]";
	}
}
