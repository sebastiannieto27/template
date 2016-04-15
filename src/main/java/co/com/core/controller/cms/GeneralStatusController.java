package co.com.core.controller.cms;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.commons.SessionUtil;
import co.com.core.dto.cms.GeneralStatusDTO;
import co.com.core.services.cms.IGeneralStatusService;


public class GeneralStatusController {

	IGeneralStatusService generalStatusService;
	List<GeneralStatusDTO> items;
	private GeneralStatusDTO selected;
	
	private static final Logger logger = Logger.getLogger(GeneralStatusController.class);
	
	public void init() {
		items = generalStatusService.getAll();
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			generalStatusService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [GeneralStatusController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = generalStatusService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				generalStatusService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [GeneralStatusController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = generalStatusService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				generalStatusService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [GeneralStatusController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = generalStatusService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new GeneralStatusDTO();
	}

	public IGeneralStatusService getGeneralStatusService() {
		return generalStatusService;
	}

	public void setGeneralStatusService(IGeneralStatusService GeneralStatusService) {
		this.generalStatusService = GeneralStatusService;
	}

	public List<GeneralStatusDTO> getItems() {
		return items;
	}

	public void setItems(List<GeneralStatusDTO> items) {
		this.items = items;
	}

	public GeneralStatusDTO getSelected() {
		return selected;
	}

	public void setSelected(GeneralStatusDTO selected) {
		this.selected = selected;
	}
}
