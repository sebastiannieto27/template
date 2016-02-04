package co.com.core.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.MenuUtil;
import co.com.core.commons.converter.PermissionUtil;
import co.com.core.commons.converter.RoleUtil;
import co.com.core.dto.MenuDTO;
import co.com.core.dto.PermissionDTO;
import co.com.core.dto.RoleDTO;
import co.com.core.dto.RoleMenuDTO;
import co.com.core.dto.RolePermissionDTO;
import co.com.core.services.IMenuService;
import co.com.core.services.IPermissionService;
import co.com.core.services.IRoleMenuService;
import co.com.core.services.IRolePermissionService;
import co.com.core.services.IRoleService;


public class RoleController {

	IRoleService roleService;
	IRoleMenuService roleMenuService;
	IMenuService menuService;
	IRolePermissionService rolePermissionService;
	IPermissionService permissionService;
	//Menu
	List<RoleDTO> items;
	List<RoleMenuDTO> roleItems;
	List<MenuDTO> menuItems;
	List<RoleMenuDTO> deleteMenuItems;
	private List<MenuDTO> menuList;
	//Permission
	private List<RolePermissionDTO> permissionItems;
	private List<PermissionDTO> notAssignedPermissionItems;
	private List<PermissionDTO> permissionList;
	private List<RolePermissionDTO> deletePermissionItems;
	
	private PermissionDTO selectedPermission;
	private RolePermissionDTO selectedRolePermission;
	private boolean permissionCheckValue;
	private boolean rolePermissionCheckValue;
	
	private RoleDTO selected;
	private Integer userIdSelected;
	private Integer roleIdSelected;
	private RoleDTO selectedRole;
	private MenuDTO selectedMenu;
	private RoleMenuDTO selectedRoleMenu;
	
	private boolean checkValue;
	private boolean roleMenuCheckValue;
	
	private static final Logger logger = Logger.getLogger(RoleController.class);
	
	/**
	 * Initial method executed when the bean is loaded
	 */
	public void init() {
		menuList = new ArrayList<MenuDTO>();
		deleteMenuItems = new ArrayList<RoleMenuDTO>();
		permissionList = new ArrayList<PermissionDTO>();
		deletePermissionItems = new ArrayList<RolePermissionDTO>();
		items = roleService.getAll();
	}

	/*********************************************************************************************************************************
	*************************************************PERMISSION MANAGE****************************************************************************/
	/**
	 * Find the menu items related to the Role
	 * @param roleDto
	 */
	public void findPermissionByRole(RoleDTO roleDto) {
		this.selectedRole = roleDto;
		try {
			permissionItems = rolePermissionService.findByRole(roleDto);
			String permissionIds = getPermissionIds();
			notAssignedPermissionItems = permissionService.getNotAssignedPermission(permissionIds);
		} catch(Exception ex) {
			logger.error("Error finding permissions by role: " + ex.getMessage());
		}
	}
	
	/**
	 * create a string with the permission ids
	 * @return
	 */
	private String getPermissionIds() {
		int counter = 0;
		StringBuilder ids = new StringBuilder();
		if(permissionItems!=null && permissionItems.size() > 0) {
			for(RolePermissionDTO dto:  permissionItems) {
				if(counter > 0) {
					ids.append(",");
				}
				ids.append(dto.getPermissionId().getPermissionId());
				counter++;
			}
		}
		return ids.toString();
	}
	
	/**
	 * add the item to the creation list
	 * @param permission
	 */
	public void addRemovePermissionList(PermissionDTO permission) {

		try {
			if(permissionCheckValue) {
				if(!permissionList.contains(permission)) {
					permissionList.add(permission);
				}
			} else {
				if(permissionList.contains(permission)) {
					permissionList.remove(permission);
				}
			}
		} catch(Exception ex) {
			logger.error("Error addRemovePermissionList: " + ex.getMessage());
		}
	}
	
	/**
	 * add the selected permission to the list
	 */
	public void addPermissionToRol() {
		try {
			if(permissionList!=null && permissionList.size() > 0) {
				for(PermissionDTO permission : permissionList) {
					RolePermissionDTO dto = new RolePermissionDTO();
					dto.setRoleId(RoleUtil.getEntityFromDto(selectedRole));
					dto.setPermissionId(PermissionUtil.getEntityFromDto(permission));
					rolePermissionService.create(dto);
				}
			}
		} catch(Exception ex) {
			logger.error("Throwed Exception [RoleController.addPermissionToRol]: " +ex.getMessage());
		} finally {
			permissionList = new ArrayList<PermissionDTO>();
			findPermissionByRole(selectedRole);
		}
	}
	
	/**
	 * add the item to the deletion list
	 * @param rolePermission
	 */
	public void addRemoveRolePermission(RolePermissionDTO rolePermission) {

		try {
			if(rolePermissionCheckValue) {
				if(!deletePermissionItems.contains(rolePermission)) {
					deletePermissionItems.add(rolePermission);
				}
			} else {
				if(deletePermissionItems.contains(rolePermission)) {
					deletePermissionItems.remove(rolePermission);
				}
			}
		} catch(Exception ex) {
			logger.error("Error addRemoveRolePermission: " + ex.getMessage());
		}
	}
	
	public void removePermissionFromRol() {
		try {
			if(deletePermissionItems!=null && deletePermissionItems.size() > 0) {
				for(RolePermissionDTO rolePermission : deletePermissionItems) {
					rolePermissionService.delete(rolePermission);
				}
			}
		} catch(Exception ex) {
			logger.error("Throwed Exception [RoleController.removePermissionFromRol]: " +ex.getMessage());
		}  finally {
			deletePermissionItems = new ArrayList<RolePermissionDTO>();
			findPermissionByRole(selectedRole);
		}
	}
	/*********************************************************************************************************************************
	*************************************************ROLE MANAGE****************************************************************************/
	/**
	 * Find the menu items related to the Role
	 * @param roleDto
	 */
	public void findMenuByRole(RoleDTO roleDto) {
		this.selectedRole = roleDto;
		try {
			roleItems = roleMenuService.findMenuByRole(roleDto);
			String menuIds = getMenuIds();
			menuItems = menuService.getNotAssignedMenu(menuIds);
			logger.info("ROLE: " + roleItems);
			logger.info("MENU NOT ADDED: " + roleItems);
		} catch(Exception ex) {
			logger.error("Error finding menus by role: " + ex.getMessage());
		}
	}
	
	/**
	 * add the selected menu to the list
	 */
	public void addMenuToRol() {
		try {
			if(menuList!=null && menuList.size() > 0) {
				for(MenuDTO menu : menuList) {
					RoleMenuDTO dto = new RoleMenuDTO();
					dto.setMenuId(MenuUtil.getEntityFromDto(menu));
					dto.setRoleId(RoleUtil.getEntityFromDto(selectedRole));
					
					roleMenuService.create(dto);
				}
			}
		} catch(Exception ex) {
			logger.error("Throwed Exception [RoleController.addMenuToRol]: " +ex.getMessage());
		} finally {
			menuList = new ArrayList<MenuDTO>();
			findMenuByRole(selectedRole);
		}
	}
	
	/**
	 * create a string with the menu ids
	 * @return
	 */
	private String getMenuIds() {
		int counter = 0;
		StringBuilder ids = new StringBuilder();
		if(roleItems!=null && roleItems.size() > 0) {
			for(RoleMenuDTO dto:  roleItems) {
				if(counter > 0) {
					ids.append(",");
				}
				ids.append(dto.getMenuId().getMenuId());
				counter++;
			}
		}
		return ids.toString();
	}
	
	/**
	 * add the item to the creation list
	 * @param menu
	 */
	public void addRemoveMenuList(MenuDTO menu) {

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
			logger.error("Error addRemoveMenuList: " + ex.getMessage());
		}
	}
	
	/**
	 * add the item to the deletion list
	 * @param roleMenu
	 */
	public void addRemoveRoleMenu(RoleMenuDTO roleMenu) {

		try {
			if(roleMenuCheckValue) {
				if(!deleteMenuItems.contains(roleMenu)) {
					deleteMenuItems.add(roleMenu);
				}
			} else {
				if(deleteMenuItems.contains(roleMenu)) {
					deleteMenuItems.remove(roleMenu);
				}
			}
		} catch(Exception ex) {
			logger.error("Error addRemoveRoleMenu: " + ex.getMessage());
		}
	}
	
	public void removeMenuFromRol() {
		try {
			if(deleteMenuItems!=null && deleteMenuItems.size() > 0) {
				for(RoleMenuDTO roleMenu : deleteMenuItems) {
					roleMenuService.delete(roleMenu);
				}
			}
		} catch(Exception ex) {
			logger.error("Throwed Exception [RoleController.removeMenuFromRol]: " +ex.getMessage());
		}  finally {
			deleteMenuItems = new ArrayList<RoleMenuDTO>();
			findMenuByRole(this.selectedRole);
		}
	}
	/*********************************************************************************************************************************
	*************************************************ADMIN****************************************************************************/
	/**
	 * creates a new entry
	 */
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

	/*
	 * ***********************************************************************************************************************************************
	 * ***************************************************GET & SET**********************************************************************************
	 */
	
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

	public RoleDTO getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(RoleDTO selectedRole) {
		this.selectedRole = selectedRole;
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

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public List<MenuDTO> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuDTO> menuItems) {
		this.menuItems = menuItems;
	}

	public MenuDTO getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(MenuDTO selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	public boolean isRoleMenuCheckValue() {
		return roleMenuCheckValue;
	}

	public void setRoleMenuCheckValue(boolean roleMenuCheckValue) {
		this.roleMenuCheckValue = roleMenuCheckValue;
	}

	public RoleMenuDTO getSelectedRoleMenu() {
		return selectedRoleMenu;
	}

	public void setSelectedRoleMenu(RoleMenuDTO selectedRoleMenu) {
		this.selectedRoleMenu = selectedRoleMenu;
	}

	public IRolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}

	public void setRolePermissionService(
			IRolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}

	public IPermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public List<RolePermissionDTO> getPermissionItems() {
		return permissionItems;
	}

	public void setPermissionItems(List<RolePermissionDTO> permissionItems) {
		this.permissionItems = permissionItems;
	}

	public List<PermissionDTO> getNotAssignedPermissionItems() {
		return notAssignedPermissionItems;
	}

	public void setNotAssignedPermissionItems(
			List<PermissionDTO> notAssignedPermissionItems) {
		this.notAssignedPermissionItems = notAssignedPermissionItems;
	}

	public List<PermissionDTO> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<PermissionDTO> permissionList) {
		this.permissionList = permissionList;
	}

	public PermissionDTO getSelectedPermission() {
		return selectedPermission;
	}

	public void setSelectedPermission(PermissionDTO selectedPermission) {
		this.selectedPermission = selectedPermission;
	}

	public RolePermissionDTO getSelectedRolePermission() {
		return selectedRolePermission;
	}

	public void setSelectedRolePermission(RolePermissionDTO selectedRolePermission) {
		this.selectedRolePermission = selectedRolePermission;
	}

	public boolean isPermissionCheckValue() {
		return permissionCheckValue;
	}

	public void setPermissionCheckValue(boolean permissionCheckValue) {
		this.permissionCheckValue = permissionCheckValue;
	}

	public boolean isRolePermissionCheckValue() {
		return rolePermissionCheckValue;
	}

	public void setRolePermissionCheckValue(boolean rolePermissionCheckValue) {
		this.rolePermissionCheckValue = rolePermissionCheckValue;
	}
	
}
