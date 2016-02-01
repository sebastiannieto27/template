package co.com.core.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import co.com.core.commons.EncryptDecrypt;
import co.com.core.dto.UserDTO;
import co.com.core.services.IUserService;

public class LoginController {

	private String userEmail;
	private String userPassword;
	private Integer userId;
	private boolean isLogged;
	
	private IUserService userService;
	private MenuController menuController;
	private UserDTO userDto;
	private EncryptDecrypt decrypter;
	
	public void init () {
		menuController.loadGeneralMenu();
	}
	
	public String validateLogin() {

		try {
			
			String encrypted = EncryptDecrypt.encrypt(userPassword);
			
			userDto = userService.login(userEmail, encrypted);
			
			if(userDto != null) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getSessionMap().put("user", userDto);
				this.isLogged = true;
	            menuController.loadMenu(userDto);
		            
	            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
		                            "Login Successful","Welcome"));
		           // FacesContext.getCurrentInstance().getExternalContext().redirect("home/profile.xhtml");
		            
		            return "home/profile.xhtml?faces-redirect=true";
					//return "home/profile.xhtml";
			} else {
				this.isLogged = false;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
	                            "Incorrect Username and Passowrd", "Please enter correct username and Password"));
				return "/login.xhtml?faces-redirect=true";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		this.isLogged = false;	
		return "/login.xhtml?faces-redirect=true";
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
	
	
}
