package co.com.core.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.dto.MenuDTO;
import co.com.core.dto.RoleDTO;
import co.com.core.dto.RoleMenuDTO;
import co.com.core.services.IRoleMenuService;
import co.com.core.services.IRoleService;


public class RoleController {

	IRoleService roleService;
	IRoleMenuService roleMenuService;
	List<RoleDTO> items;
	List<RoleMenuDTO> roleItems;
	private RoleDTO selected;
	private Integer userIdSelected;
	private Integer roleIdSelected;
	private RoleDTO selectedRoleMenu;
	
	private List<MenuDTO> menuList;
	private boolean checkValue;
	
	private static final Logger logger = Logger.getLogger(RoleController.class);
	
	public void init() {
		menuList = new ArrayList<MenuDTO>();
		items = roleService.getAll();
	}

	public void findMenuByRole(RoleDTO roleDto) {
		selectedRoleMenu = roleDto;
		try {
			roleItems = roleMenuService.findMenuByRole(roleDto);
		} catch(Exception ex) {
			logger.error("Error finding menus by role: " + ex.getMessage());
		}
	}
	
	public void addMenuToRol() {
		
		if(menuList!=null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				logger.error("::::::::::::" + menu);
				
			}
		}
		
		logger.error("::::::::::::" + selectedRoleMenu);
	}
	
	public void addRemoveMenu(MenuDTO menu) {

		try {
			if(checkValue) {
				if(!menuList.contains(menu)) {
					menuList.add(menu);
				}
			} else {
				if(menuList.contains(menu)) {
					menuList.remove(menu);
				}
			}
		} catch(Exception ex) {
			logger.error("Error adding menu to list: " + ex.getMessage());
		}
	}
	
	public void saveNew() {
		try {
			roleService.createRole(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Página"));
		} catch (Exception ex) {
			logger.error("Throwed Exception [RoleController.saveNew]: " +ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Página"));
		} finally {
			items = roleService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				logger.error("ROLE DTO: " + selected);
				roleService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RoleController.delete]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Página"));
			} finally {
				items = roleService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			try {
				roleService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RoleController.save]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Página"));
			} finally {
				items = roleService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new RoleDTO();
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService RoleService) {
		this.roleService = RoleService;
	}

	public List<RoleDTO> getItems() {
		return items;
	}

	public void setItems(List<RoleDTO> items) {
		this.items = items;
	}

	public RoleDTO getSelected() {
		return selected;
	}

	public void setSelected(RoleDTO selected) {
		this.selected = selected;
	}

	public Integer getUserIdSelected() {
		return userIdSelected;
	}

	public void setUserIdSelected(Integer userIdSelected) {
		this.userIdSelected = userIdSelected;
	}

	public Integer getRoleIdSelected() {
		return roleIdSelected;
	}

	public void setRoleIdSelected(Integer roleIdSelected) {
		this.roleIdSelected = roleIdSelected;
	}

	public boolean isCheckValue() {
		return checkValue;
	}

	public void setCheckValue(boolean checkValue) {
		this.checkValue = checkValue;
	}

	public RoleDTO getSelectedRoleMenu() {
		return selectedRoleMenu;
	}

	public void setSelectedRoleMenu(RoleDTO selectedRoleMenu) {
		this.selectedRoleMenu = selectedRoleMenu;
	}

	public IRoleMenuService getRoleMenuService() {
		return roleMenuService;
	}

	public void setRoleMenuService(IRoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public List<RoleMenuDTO> getRoleItems() {
		return roleItems;
	}

	public void setRoleItems(List<RoleMenuDTO> roleItems) {
		this.roleItems = roleItems;
	}
	
}
