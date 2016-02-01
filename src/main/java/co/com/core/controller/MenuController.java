package co.com.core.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.core.commons.converter.UserUtil;
import co.com.core.domain.Menu;
import co.com.core.domain.Page;
import co.com.core.domain.User;
import co.com.core.dto.MenuDTO;
import co.com.core.dto.UserDTO;
import co.com.core.services.IMenuService;

public class MenuController {

	private List<Menu> menuList; 
	private MenuModel model;
	private MenuModel generalModel;
	private String userName;
	
	private LoginController login;
	private IMenuService menuService;
	
	List<MenuDTO> items;
	private MenuDTO selected;
	private Integer parentMenuId;
	private Integer pageId;
	
	private static final Logger logger = Logger.getLogger(MenuController.class);
	
	public void init() {
		model = new DefaultMenuModel();
		items = menuService.getAll();
	}
	
	public void loadMenu(UserDTO userDto) {
		User user = UserUtil.getEntityFromDto(userDto);
		List<MenuDTO> menuList = menuService.getUserMenu(user);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				if(!menu.getSubmenu()) {
					DefaultSubMenu subMenu = new DefaultSubMenu(menu.getMenuName());
					for(MenuDTO menuItem : menuList) {
						if(menuItem.getSubmenu() && menuItem.getParentMenuId()!=null) {
							if(menuItem.getParentMenuId().getMenuId() == menu.getMenuId() ) {
								DefaultMenuItem item = new DefaultMenuItem(menuItem.getMenuName());
								if(menuItem.getPageId()!=null) {
									item.setUrl(menuItem.getPageId().getUrl());
									//TODO item.setIcon(icon);
								}
								subMenu.addElement(item);
							}
						}
					}
					model.addElement(subMenu);
				} 
			}
		}
	}

	public void loadGeneralMenu() {
		generalModel = new DefaultMenuModel();
		List<MenuDTO> menuList = menuService.getMenuGeneral();
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				if(!menu.getSubmenu()) {
					DefaultSubMenu subMenu = new DefaultSubMenu(menu.getMenuName());
					for(MenuDTO menuItem : menuList) {
						if(menuItem.getSubmenu() && menuItem.getParentMenuId()!=null) {
							if(menuItem.getParentMenuId().getMenuId() == menu.getMenuId() ) {
								DefaultMenuItem item = new DefaultMenuItem(menuItem.getMenuName());
								item.setUrl(menuItem.getPageId().getUrl());
								//TODO item.setIcon(icon);
								subMenu.addElement(item);
							}
						}
					}
					generalModel.addElement(subMenu);
				} 
			}
		}
	}
	
	/*************************ADMIN********************************/
	
	public void prepareEdit() {
		selected = new MenuDTO();
	}

	public void prepareCreate() {
		selected = new MenuDTO();
	}
	
	public void saveNew() {
		try {
			
			Page page = new Page(pageId);
			
			if(parentMenuId != null && parentMenuId !=0) {
				Menu parent = new Menu(parentMenuId);
				selected.setParentMenuId(parent);
			}
			selected.setPageId(page);
			menuService.createMenu(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Menu"));
		} catch (Exception ex) {
			logger.error("Throwed Exception [MenuController.saveNew]: " +ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Menu"));
		} finally {
			items = menuService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				menuService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Menu"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MenuController.delete]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Menu"));
			} finally {
				items = menuService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			try {
				Page page = new Page(pageId);
				
				if(parentMenuId != null && parentMenuId !=0) {
					Menu parent = new Menu(parentMenuId);
					selected.setParentMenuId(parent);
				}
				selected.setPageId(page);
				
				menuService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Menu"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MenuController.save]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Menu"));
			} finally {
				items = menuService.getAll();
			}
		}
	}
	
	public List<MenuDTO> getItems() {
		return items;
	}

	public void setItems(List<MenuDTO> items) {
		this.items = items;
	}

	public MenuDTO getSelected() {
		return selected;
	}

	public void setSelected(MenuDTO selected) {
		this.selected = selected;
	}

	public LoginController getLogin() {
		return login;
	}

	public void setLogin(LoginController login) {
		this.login = login;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public MenuModel getGeneralModel() {
		return generalModel;
	}

	public void setGeneralModel(MenuModel generalModel) {
		this.generalModel = generalModel;
	}

	public Integer getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
