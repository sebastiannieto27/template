package co.com.core.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class LoginController {

	/*private String userEmail;
	private String userPassword;
	private Integer userId;
	private boolean isLogged;
	
	private UserBO userBO;
	private MenuController menuController;
	UserDTO userDto;
	
	@PostConstruct
	public void init () {
		menuController.loadGeneralMenu();
	}
	
	public String queryUserByUserName() {
		userDto = userBO.login(userEmail);
		
		try {
			if(userDto != null) {
				if(userDto.getPassword().equals(this.userPassword)) {
					this.isLogged = true;
					HttpSession session = SessionBean.getSession();
					session.setAttribute("loginController", this);
		            session.setAttribute("username", userDto.getEmail());
		            menuController.loadMenu(userDto);
		            
		            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
		                            "Login Successful","Welcome"));
		            FacesContext.getCurrentInstance().getExternalContext().redirect("home/profile.xhtml");
		            
					return "/home.xhtml?faces-redirect=true";
				} else {
					this.isLogged = false;
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
		                            "Incorrect Username and Passowrd", "Please enter correct username and Password"));
					return "/login.xhtml?faces-redirect=true";
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	public String logout() {
	      HttpSession session = SessionBean.getSession();
	    		  //session.invalidate();
	      this.isLogged = false;
	      return "/logout.xhtml?faces-redirect=true";
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

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
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
	*/
	
}
