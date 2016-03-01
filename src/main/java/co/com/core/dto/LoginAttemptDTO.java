package co.com.core.dto;

import java.sql.Timestamp;

import co.com.core.domain.User;

public class LoginAttemptDTO implements IBaseDTO {
	private Integer loginAttemptId;
    private String userAgent;
    private String ipAddress;
    private Timestamp dateAttempt;
    private String userMail;
    private Short validAttempt;
    
	public Integer getLoginAttemptId() {
		return loginAttemptId;
	}
	public void setLoginAttemptId(Integer loginAttemptId) {
		this.loginAttemptId = loginAttemptId;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Timestamp getDateAttempt() {
		return dateAttempt;
	}
	public void setDateAttempt(Timestamp dateAttempt) {
		this.dateAttempt = dateAttempt;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public Short getValidAttempt() {
		return validAttempt;
	}
	public void setValidAttempt(Short validAttempt) {
		this.validAttempt = validAttempt;
	}
	
	@Override
	public String toString() {
		return "LoginAttemptDTO [loginAttemptId=" + loginAttemptId
				+ ", userAgent=" + userAgent + ", ipAddress=" + ipAddress
				+ ", dateAttempt=" + dateAttempt + ", validAttempt="
				+ validAttempt + "]";
	}
}
