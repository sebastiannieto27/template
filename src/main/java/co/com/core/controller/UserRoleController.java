package co.com.core.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.domain.Role;
import co.com.core.domain.User;
import co.com.core.dto.UserRoleDTO;
import co.com.core.services.IUserRoleService;


public class UserRoleController {

	IUserRoleService userRoleService;
	List<UserRoleDTO> items;
	private UserRoleDTO selected;
	private Integer userIdSelected;
	private Integer roleIdSelected;

	private static final Logger logger = Logger.getLogger(UserRoleController.class);
	
	public void init() {
		items = userRoleService.getAll();
	}

	public void saveNew() {
		try {
			User user = new User(userIdSelected);
			selected.setUserId(user);
			
			Role role = new Role(roleIdSelected);
			selected.setRoleId(role);
			
			userRoleService.createUserRole(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Página"));
		} catch (Exception ex) {
			logger.error("Throwed Exception [UserRoleController.saveNew]: " +ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Página"));
		} finally {
			items = userRoleService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				userRoleService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [UserRoleController.delete]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Página"));
			} finally {
				items = userRoleService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			try {
				User user = new User(userIdSelected);
				selected.setUserId(user);
				
				Role role = new Role(roleIdSelected);
				selected.setRoleId(role);
				
				userRoleService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [UserRoleController.save]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Página"));
			} finally {
				items = userRoleService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new UserRoleDTO();
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public List<UserRoleDTO> getItems() {
		return items;
	}

	public void setItems(List<UserRoleDTO> items) {
		this.items = items;
	}

	public UserRoleDTO getSelected() {
		return selected;
	}

	public void setSelected(UserRoleDTO selected) {
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
}
