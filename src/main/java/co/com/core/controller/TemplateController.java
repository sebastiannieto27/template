package co.com.core.controller;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.UserUtil;
import co.com.core.domain.User;
import co.com.core.dto.MenuDTO;
import co.com.core.dto.PageDTO;
import co.com.core.dto.UserDTO;
import co.com.core.services.IMenuService;
import co.com.core.services.IPageService;

public class TemplateController {

	private IMenuService menuService;
	private IPageService pageService;
	private static final Logger logger = Logger.getLogger(TemplateController.class);
	
	public void validateUserSession() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			String viewId = context.getViewRoot().getViewId();
			if(viewId !=null && !viewId.contains("login")) {
				UserDTO userDto = (UserDTO) context.getExternalContext().getSessionMap().get("user");
				
				if(userDto==null) {
					context.getExternalContext().redirect("/friogan/login.xhtml");
				} else {
					boolean validPage = validateAllowedPage(userDto, viewId);
					if(!validPage) {
						context.getExternalContext().redirect("/friogan/home/profile.xhtml");
						logger.info("Invalid page access: " + userDto.getFirstName() + "Page: " + viewId);
					}
					logger.info("Valid session: " + userDto.getFirstName() + "Page: " + viewId);
				}
			}

		} catch(Exception ex) {
			logger.error("Exception validating session: " + ex.getMessage());
		}
		
		
	}

	private boolean validateAllowedPage(UserDTO userDto, String viewId) {
		boolean allowedPage = false;
		
		User user = UserUtil.getEntityFromDto(userDto);
		
		List<MenuDTO> menuList = menuService.getUserMenu(user);
		
		PageDTO pageDto = pageService.getPageByURL(viewId);
		
		if(menuList!=null && menuList.size() > 0) {
			if(pageDto!=null) {
				for(MenuDTO menu : menuList) {
					if(menu.getPageId() != null) {
						if(menu.getPageId().getPageId() == pageDto.getPageId()) {
							allowedPage = true;
							logger.info("Allowed page: " + pageDto.getUrl());
						}
					}
				}
			}
		} 
		
		return allowedPage;
	}
	
	public PageDTO getPageFromUrl() {
		PageDTO pageDto = new PageDTO();
		return pageDto;
	}
	
	
	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public IPageService getPageService() {
		return pageService;
	}

	public void setPageService(IPageService pageService) {
		this.pageService = pageService;
	}
	
	
}
