package co.com.core.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import co.com.core.commons.EncryptDecrypt;
import co.com.core.commons.converter.RoleUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.dto.PagePermissionDTO;
import co.com.core.dto.RoleDTO;
import co.com.core.dto.RolePermissionDTO;
import co.com.core.dto.UserDTO;
import co.com.core.dto.UserRoleDTO;
import co.com.core.services.IRoleService;
import co.com.core.services.IUserRoleService;
import co.com.core.services.IUserService;

public class UserController {
	private IUserService userService;
	private IUserRoleService userRoleService;
	private IRoleService roleService;
	private List<UserDTO> items;
	private UserDTO selected;
	private LazyDataModel<UserDTO> lazyModel;
	private static final Logger logger = Logger.getLogger(UserController.class);
	private static final String DEFAULT_PASSWORD = "12345";
	
	/**
	 * user-role
	 */
	private List<RoleDTO> notAssignedRoleItems; 
	private List<RoleDTO> roleAssignItems; 
	private List<UserRoleDTO> userRoleQueryItems; 
	private boolean roleCheckValue;
	private RoleDTO selectedRole;
	
	private List<UserRoleDTO> deleteUserRoleItems;
	private UserRoleDTO selectedUserRole;
	private boolean userRoleCheckValue;
	
	/**
	 * Find the menu items related to the Role
	 * @param roleDto
	 */
	public void findNotAssignedRolesByUser(UserDTO userDto) {
		this.selected = userDto;
		try {
			deleteUserRoleItems = new ArrayList<UserRoleDTO>();
			roleAssignItems = new ArrayList<RoleDTO>();
			userRoleQueryItems = userRoleService.findByUser(userDto);
			String roleIds = getRoleIds();
			notAssignedRoleItems = roleService.getNotAssignedRole(roleIds);
		} catch(Exception ex) {
			logger.error("Error finding permissions by role: " + ex.getMessage());
		}
	}
	
	/**
	 * create a string with the ids
	 * @return
	 */
	private String getRoleIds() {
		int counter = 0;
		StringBuilder ids = new StringBuilder();
		if(userRoleQueryItems!=null && userRoleQueryItems.size() > 0) {
			for(UserRoleDTO dto:  userRoleQueryItems) {
				if(counter > 0) {
					ids.append(",");
				}
				ids.append(dto.getRoleId().getRoleId());
				counter++;
			}
		}
		return ids.toString();
	}
	/**
	 * adds/removes items to the creation list
	 * @param role
	 */
	public void addRemoveRoleList(RoleDTO role) {
		try {
			if(roleCheckValue) {
				if(!roleAssignItems.contains(role)) {
					roleAssignItems.add(role);
				}
			} else {
				if(roleAssignItems.contains(role)) {
					roleAssignItems.remove(role);
				}
			}
		} catch(Exception ex) {
			logger.error("Error UserController.addRemoveRoleList: " + ex.getMessage());
		}
	}
	
	public void addRoleToUser() {
		try {
			if(roleAssignItems!=null && roleAssignItems.size() > 0) {
				for(RoleDTO role : roleAssignItems) {
					UserRoleDTO dto = new UserRoleDTO();
					dto.setRoleId(RoleUtil.getEntityFromDto(role));
					dto.setUserId(UserUtil.getEntityFromDto(selected));
					userRoleService.createUserRole(dto);
				}
			}
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserController.addRoleToUser]: " +ex.getMessage());
		} finally {
			roleAssignItems = new ArrayList<RoleDTO>();
			findNotAssignedRolesByUser(selected);
		}
	}
	
	public void addRemoveUserRole(UserRoleDTO userRoleDto){
		try {
			if(userRoleCheckValue) {
				if(!deleteUserRoleItems.contains(userRoleDto)) {
					deleteUserRoleItems.add(userRoleDto);
				}
			} else {
				if(deleteUserRoleItems.contains(userRoleDto)) {
					deleteUserRoleItems.remove(userRoleDto);
				}
			}
		} catch(Exception ex) {
			logger.error("Error addRemoveUserRole: " + ex.getMessage());
		}
	}
	
	public void removeRoleFromUser() {
		try {
			if(deleteUserRoleItems!=null && deleteUserRoleItems.size() > 0) {
				for(UserRoleDTO dto : deleteUserRoleItems) {
					userRoleService.delete(dto);
				}
			}
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserController.removeRoleFromUser]: " +ex.getMessage());
		}  finally {
			deleteUserRoleItems = new ArrayList<UserRoleDTO>();
			findNotAssignedRolesByUser(selected);
		}
	}
	
	public void init() {
		items = userService.getAll();
		//lazyModel = new UserLazyLoader(userService);
	}

	
	
	
	public void saveNew() {
		try {
			String encryptedPasswd = EncryptDecrypt.encrypt(selected.getPassword());
			selected.setPassword(encryptedPasswd);
			userService.createUser(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Usuario"));
		} catch (Exception ex) {
			logger.error("Throwed Exception [UserController.saveNew]: " +ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Usuario"));
		} finally {
			items = userService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				userService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Usuario"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [UserController.delete]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Usuario"));
			} finally {
				items = userService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			try {
				String encryptedPasswd = EncryptDecrypt.encrypt(selected.getPassword());
				selected.setPassword(encryptedPasswd);
				userService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Usuario"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [UserController.save]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Usuario"));
			} finally {
				items = userService.getAll();
			}
		}
	}

	public void resetPassword(UserDTO userDto) {
		String encryptedPasswd = EncryptDecrypt.encrypt(DEFAULT_PASSWORD);
		userDto.setPassword(encryptedPasswd);
		userService.update(userDto);
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Contraseña Actualizada", "Usuario"));
	}
	
	public void selectOne() {
		System.out.println("selected: " + selected);
	}
	
	public void prepareCreate() {
		selected = new UserDTO();
	}
	
	public LazyDataModel<UserDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<UserDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public List<UserDTO> getItems() {
		return items;
	}

	public void setItems(List<UserDTO> items) {
		this.items = items;
	}

	public UserDTO getSelected() {
		return selected;
	}

	public void setSelected(UserDTO selected) {
		this.selected = selected;
	}

	public boolean isRoleCheckValue() {
		return roleCheckValue;
	}

	public void setRoleCheckValue(boolean roleCheckValue) {
		this.roleCheckValue = roleCheckValue;
	}

	public boolean isUserRoleCheckValue() {
		return userRoleCheckValue;
	}

	public void setUserRoleCheckValue(boolean userRoleCheckValue) {
		this.userRoleCheckValue = userRoleCheckValue;
	}

	public List<RoleDTO> getNotAssignedRoleItems() {
		return notAssignedRoleItems;
	}

	public void setNotAssignedRoleItems(List<RoleDTO> notAssignedRoleItems) {
		this.notAssignedRoleItems = notAssignedRoleItems;
	}

	public RoleDTO getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(RoleDTO selectedRole) {
		this.selectedRole = selectedRole;
	}

	public UserRoleDTO getSelectedUserRole() {
		return selectedUserRole;
	}

	public void setSelectedUserRole(UserRoleDTO selectedUserRole) {
		this.selectedUserRole = selectedUserRole;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public List<UserRoleDTO> getUserRoleQueryItems() {
		return userRoleQueryItems;
	}

	public void setUserRoleQueryItems(List<UserRoleDTO> userRoleQueryItems) {
		this.userRoleQueryItems = userRoleQueryItems;
	}
	
}
