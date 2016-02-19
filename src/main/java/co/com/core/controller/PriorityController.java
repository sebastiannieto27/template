package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.dto.PriorityDTO;
import co.com.core.services.IPriorityService;


public class PriorityController {

	private IPriorityService priorityService;
	private List<PriorityDTO> items;
	private PriorityDTO selected;
	
	private static final Logger logger = Logger.getLogger(PriorityController.class);
	
	public void init() {
		items = priorityService.getAll();
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			priorityService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [PriorityController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = priorityService.getAll();
		}

	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				priorityService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [PriorityController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = priorityService.getAll();
			}
		}
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				priorityService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [PriorityController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = priorityService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new PriorityDTO();
	}

	public IPriorityService getPriorityService() {
		return priorityService;
	}

	public void setPriorityService(IPriorityService PriorityService) {
		this.priorityService = PriorityService;
	}

	public List<PriorityDTO> getItems() {
		return items;
	}

	public void setItems(List<PriorityDTO> items) {
		this.items = items;
	}

	public PriorityDTO getSelected() {
		return selected;
	}

	public void setSelected(PriorityDTO selected) {
		this.selected = selected;
	}
}
