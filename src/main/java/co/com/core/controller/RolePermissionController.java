package co.com.core.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.domain.PagePermission;
import co.com.core.domain.Permission;
import co.com.core.domain.Role;
import co.com.core.dto.RolePermissionDTO;
import co.com.core.services.IRolePermissionService;


public class RolePermissionController {

	IRolePermissionService rolePermissionService;
	List<RolePermissionDTO> items;
	private RolePermissionDTO selected;
	private Integer selectedPermissionId;
	private Integer selectedRoleId;
	
	private static final Logger logger = Logger.getLogger(RolePermissionController.class);
	
	public void init() {
		items = rolePermissionService.getAll();
	}

	public void saveNew() {
		try {
			PagePermission permission = new PagePermission(selectedPermissionId);//TODO
			selected.setPagePermissionId(permission);
			
			Role role = new Role(selectedRoleId);
			selected.setRoleId(role);
			
			rolePermissionService.create(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Página"));
		} catch (Exception ex) {
			logger.error("Throwed Exception [RolePermissionController.saveNew]: " +ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Página"));
		} finally {
			items = rolePermissionService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				rolePermissionService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RolePermissionController.delete]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Página"));
			} finally {
				items = rolePermissionService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			try {

				PagePermission permission = new PagePermission(selectedPermissionId);
				selected.setPagePermissionId(permission);//TODO
				
				Role role = new Role(selectedRoleId);
				selected.setRoleId(role);
				
				rolePermissionService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RolePermissionController.save]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Página"));
			} finally {
				items = rolePermissionService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new RolePermissionDTO();
	}

	public IRolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}

	public void setRolePermissionService(IRolePermissionService RolePermissionService) {
		this.rolePermissionService = RolePermissionService;
	}

	public List<RolePermissionDTO> getItems() {
		return items;
	}

	public void setItems(List<RolePermissionDTO> items) {
		this.items = items;
	}

	public RolePermissionDTO getSelected() {
		return selected;
	}

	public void setSelected(RolePermissionDTO selected) {
		this.selected = selected;
	}

	public Integer getSelectedRoleId() {
		return selectedRoleId;
	}

	public void setSelectedRoleId(Integer selectedRoleId) {
		this.selectedRoleId = selectedRoleId;
	}

	public Integer getSelectedPermissionId() {
		return selectedPermissionId;
	}

	public void setSelectedPermissionId(Integer selectedPermissionId) {
		this.selectedPermissionId = selectedPermissionId;
	}

	
}
