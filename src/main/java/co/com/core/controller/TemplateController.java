package co.com.core.controller;

import javax.faces.context.FacesContext;

import co.com.core.dto.UserDTO;

public class TemplateController {

	public void validateUserSession() {
		System.out.println("Validating session");
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			String viewId = context.getViewRoot().getViewId();
			System.out.println("VIEW ID: "+ viewId);
			if(viewId !=null && !viewId.contains("login")) {
				UserDTO userDto = (UserDTO) context.getExternalContext().getSessionMap().get("user");
				
				if(userDto==null) {
					context.getExternalContext().redirect("/festivities/login.xhtml");
				} else {
					System.out.println("Valid session : " + userDto.getFirstName());
				}
			}

		} catch(Exception ex) {
			System.out.println("SESSION ERROR: " + ex.getMessage());
		}
		
		
	}
}
