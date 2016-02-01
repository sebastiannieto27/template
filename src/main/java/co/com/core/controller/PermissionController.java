package co.com.core.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.dto.PermissionDTO;
import co.com.core.services.IPermissionService;


public class PermissionController {

	IPermissionService permissionService;
	List<PermissionDTO> items;
	private PermissionDTO selected;
	
	private static final Logger logger = Logger.getLogger(PermissionController.class);
	
	public void init() {
		items = permissionService.getAll();
	}

	public void saveNew() {
		try {
			permissionService.create(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Página"));
		} catch (Exception ex) {
			logger.error("Throwed Exception [PermissionController.saveNew]: " +ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Página"));
		} finally {
			items = permissionService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				permissionService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [PermissionController.delete]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Página"));
			} finally {
				items = permissionService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			try {
				permissionService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Página"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [PermissionController.save]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Página"));
			} finally {
				items = permissionService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new PermissionDTO();
	}

	public IPermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(IPermissionService PermissionService) {
		this.permissionService = PermissionService;
	}

	public List<PermissionDTO> getItems() {
		return items;
	}

	public void setItems(List<PermissionDTO> items) {
		this.items = items;
	}

	public PermissionDTO getSelected() {
		return selected;
	}

	public void setSelected(PermissionDTO selected) {
		this.selected = selected;
	}
}
