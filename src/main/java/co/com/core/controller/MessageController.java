package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import co.com.core.domain.Priority;
import co.com.core.dto.MessageDTO;
import co.com.core.lazy.loader.MessageLazyLoader;
import co.com.core.services.IMessageService;



public class MessageController {

	private static final Logger logger = Logger.getLogger(MessageController.class);
	
	IMessageService messageService;
	List<MessageDTO> items;
	private MessageDTO selected;
	
	private LazyDataModel<MessageDTO> lazyModel;
	
	public void init() {
		lazyModel = new MessageLazyLoader(messageService);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			messageService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [MessageController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = messageService.getAll();
		}

	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				messageService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MessageController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = messageService.getAll();
			}
		}
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				messageService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MessageController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = messageService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new MessageDTO();
	}

	public List<MessageDTO> getAllMessages() {
		return messageService.getAll();
	}
	
	public IMessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService eventService) {
		this.messageService = eventService;
	}

	public List<MessageDTO> getItems() {
		return items;
	}

	public void setItems(List<MessageDTO> items) {
		this.items = items;
	}

	public MessageDTO getSelected() {
		return selected;
	}

	public void setSelected(MessageDTO selected) {
		this.selected = selected;
	}

	public LazyDataModel<MessageDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<MessageDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
}
