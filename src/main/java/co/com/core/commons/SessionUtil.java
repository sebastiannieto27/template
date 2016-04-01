package co.com.core.commons;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import co.com.core.dto.UserDTO;

public class SessionUtil {
	 
	public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
 
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
 
    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }
 
    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("userid");
        else
            return null;
    }
    
    public static UserDTO getSessionUser() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	UserDTO userDto = (UserDTO) context.getExternalContext().getSessionMap().get("user");
    	return userDto;
    }
    
    public static Integer getSessionUserId() {
    	FacesContext context = FacesContext.getCurrentInstance();
		UserDTO userDto = (UserDTO) context.getExternalContext().getSessionMap().get("user");
		if(userDto.getUserId()!=null) {
			return userDto.getUserId();
		}
		return null;
    }
    
}
