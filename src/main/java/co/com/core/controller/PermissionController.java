package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.domain.Page;
import co.com.core.dto.PermissionDTO;
import co.com.core.services.IPermissionService;


public class PermissionController {

	private IPermissionService permissionService;
	private List<PermissionDTO> items;
	private PermissionDTO selected;
	private static final Logger logger = Logger.getLogger(PermissionController.class);
	
	public void init() {
		items = permissionService.getAll();
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			permissionService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [PermissionController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = permissionService.getAll();
		}

	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				permissionService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [PermissionController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = permissionService.getAll();
			}
		}
	}
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				permissionService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [PermissionController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
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
