package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.dto.MessageStatusDTO;
import co.com.core.services.IMessageStatusService;


public class MessageStatusController {

	IMessageStatusService messageStatusService;
	List<MessageStatusDTO> items;
	private MessageStatusDTO selected;
	
	private static final Logger logger = Logger.getLogger(MessageStatusController.class);
	
	public void init() {
		items = messageStatusService.getAll();
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			messageStatusService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [MessageStatusController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = messageStatusService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				messageStatusService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MessageStatusController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = messageStatusService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				messageStatusService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MessageStatusController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = messageStatusService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new MessageStatusDTO();
	}

	public IMessageStatusService getMessageStatusService() {
		return messageStatusService;
	}

	public void setMessageStatusService(IMessageStatusService MessageStatusService) {
		this.messageStatusService = MessageStatusService;
	}

	public List<MessageStatusDTO> getItems() {
		return items;
	}

	public void setItems(List<MessageStatusDTO> items) {
		this.items = items;
	}

	public MessageStatusDTO getSelected() {
		return selected;
	}

	public void setSelected(MessageStatusDTO selected) {
		this.selected = selected;
	}
}
