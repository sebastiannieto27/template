package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.sql.Timestamp;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import co.com.core.commons.EncryptDecrypt;
import co.com.core.commons.SessionUtil;
import co.com.core.dto.LoginAttemptDTO;
import co.com.core.dto.UserDTO;
import co.com.core.services.ILoginAttemptService;
import co.com.core.services.IUserService;

public class LoginController {

	private String userEmail;
	private String userPassword;
	private Integer userId;
	private boolean isLogged;
	
	private IUserService userService;
	private MenuController menuController;
	private UserDTO userDto;
	
	private ILoginAttemptService loginAttemptService;
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	public void init () {
		menuController.loadGeneralMenu();
	}
	
	public String validateLogin() {

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			String encrypted = EncryptDecrypt.encrypt(userPassword);
			userDto = userService.login(userEmail, encrypted);
			if(userDto != null) {
				//register a valid login attempt
				registerSessionAttemp((short)1, userEmail);
				if(userDto.getActive()) {
					context.getExternalContext().getSessionMap().put("user", userDto);
					this.isLogged = true;
		            menuController.loadMenu(userDto);
		            return "home/profile.xhtml?faces-redirect=true";
				} else {
					this.isLogged = false;
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("inactiveUser"), geProperty("pleaseVerifySummary")));
				}
			} else {
				//register a failed login attempt
				registerSessionAttemp((short)0, userEmail);
				this.isLogged = false;
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("wrongUserPassword"), geProperty("pleaseVerifySummary")));
			}
		} catch(Exception ex) {
			logger.error("Throwed Exception [LoginController.validateLogin]: " +ex.getMessage());
		}
		return null;
	}


	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		this.isLogged = false;	
		return "/login.xhtml?faces-redirect=true";
   }
	
	private void registerSessionAttemp(Short validAttempt, String userMail) {
		try {
			LoginAttemptDTO attempt = new LoginAttemptDTO();
			HttpServletRequest request =  SessionUtil.getRequest();
			
			String userAgent = SessionUtil.getRequest().getHeader("User-Agent");
			attempt.setUserAgent(userAgent);
			
			String ipAddress = request.getHeader("X-FORWARDED-FOR");
			if (ipAddress == null) {
			    ipAddress = request.getRemoteAddr();
			}
			attempt.setIpAddress(ipAddress);
			//current date and time
			attempt.setDateAttempt(new Timestamp(new Date().getTime()));
			attempt.setUserMail(userMail);
			attempt.setValidAttempt(validAttempt);
			loginAttemptService.create(attempt);
		} catch(Exception ex) {
			logger.error("Throwed Exception [LoginController.registerSessionAttemp]: " +ex.getMessage());
		}
		
		
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public MenuController getMenuController() {
		return menuController;
	}

	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	@Override
	public String toString() {
		return "LoginController [userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", isLogged=" + isLogged + "]";
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ILoginAttemptService getLoginAttemptService() {
		return loginAttemptService;
	}

	public void setLoginAttemptService(ILoginAttemptService loginAttemptService) {
		this.loginAttemptService = loginAttemptService;
	}
	
	
}
