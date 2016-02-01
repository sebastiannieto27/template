package co.com.core.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.domain.Menu;
import co.com.core.domain.Role;
import co.com.core.domain.User;
import co.com.core.dto.RoleMenuDTO;
import co.com.core.services.IRoleMenuService;


public class RoleMenuController {

	IRoleMenuService roleMenuService;
	List<RoleMenuDTO> items;
	private RoleMenuDTO selected;
	private Integer selectedMenuId;
	private Integer selectedRoleId;
	
	private static final Logger logger = Logger.getLogger(RoleMenuController.class);
	
	public void init() {
		items = roleMenuService.getAll();
	}

	public void saveNew() {
		try {
			Menu menu = new Menu(selectedMenuId);
			selected.setMenuId(menu);
			
			Role role = new Role(selectedRoleId);
			selected.setRoleId(role);
			
			roleMenuService.create(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Página"));
		} catch (Exception ex) {
			logger.error("Throwed Exception [RoleMenuController.saveNew]: " +ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Página"));
		} finally {
			items = roleMenuService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				roleMenuService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RoleMenuController.delete]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Página"));
			} finally {
				items = roleMenuService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			try {

				Menu menu = new Menu(selectedMenuId);
				selected.setMenuId(menu);
				
				Role role = new Role(selectedRoleId);
				selected.setRoleId(role);
				
				roleMenuService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RoleMenuController.save]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Página"));
			} finally {
				items = roleMenuService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new RoleMenuDTO();
	}

	public IRoleMenuService getRoleMenuService() {
		return roleMenuService;
	}

	public void setRoleMenuService(IRoleMenuService RoleMenuService) {
		this.roleMenuService = RoleMenuService;
	}

	public List<RoleMenuDTO> getItems() {
		return items;
	}

	public void setItems(List<RoleMenuDTO> items) {
		this.items = items;
	}

	public RoleMenuDTO getSelected() {
		return selected;
	}

	public void setSelected(RoleMenuDTO selected) {
		this.selected = selected;
	}

	public Integer getSelectedRoleId() {
		return selectedRoleId;
	}

	public void setSelectedRoleId(Integer selectedRoleId) {
		this.selectedRoleId = selectedRoleId;
	}

	public Integer getSelectedMenuId() {
		return selectedMenuId;
	}

	public void setSelectedMenuId(Integer selectedMenuId) {
		this.selectedMenuId = selectedMenuId;
	}
}
