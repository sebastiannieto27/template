package co.com.core.controller.cms;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.commons.SessionUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.dto.UserDTO;
import co.com.core.dto.cms.ServiceDTO;
import co.com.core.services.cms.IServiceService;


public class ServiceController {

	IServiceService serviceService;
	List<ServiceDTO> items;
	private ServiceDTO selected;
	
	private static final Logger logger = Logger.getLogger(ServiceController.class);
	
	public void init() {
		items = serviceService.getAll();
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			logger.error(selected);
			UserDTO userDto = SessionUtil.getSessionUser();
			selected.setUserId(UserUtil.getEntityFromDto(userDto));
			selected.setDateCre(new Date());
			serviceService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [ServiceController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = serviceService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				serviceService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ServiceController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = serviceService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				serviceService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ServiceController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = serviceService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new ServiceDTO();
	}

	public IServiceService getServiceService() {
		return serviceService;
	}

	public void setServiceService(IServiceService ServiceService) {
		this.serviceService = ServiceService;
	}

	public List<ServiceDTO> getItems() {
		return items;
	}

	public void setItems(List<ServiceDTO> items) {
		this.items = items;
	}

	public ServiceDTO getSelected() {
		return selected;
	}

	public void setSelected(ServiceDTO selected) {
		this.selected = selected;
	}
}
