package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import co.com.core.domain.Priority;
import co.com.core.dto.EventDTO;
import co.com.core.lazy.loader.EventLazyLoader;
import co.com.core.services.IEventService;



public class EventController {

	private static final Logger logger = Logger.getLogger(EventController.class);
	
	IEventService eventService;
	List<EventDTO> items;
	private EventDTO selected;
	private Integer priorityIdSelected;
	
	private LazyDataModel<EventDTO> lazyModel;
	
	public void init() {
		lazyModel = new EventLazyLoader(eventService);
	}

	public void rowSelection(SelectEvent event) {
		logger.info("Event: " + event.getObject());
	}
	
	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(priorityIdSelected!=null && priorityIdSelected!=0) {
				Priority p = new Priority(priorityIdSelected);
				selected.setPriorityId(p);
				eventService.createEvent(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, geProperty("priorityRequiredMessage"), geProperty("pleaseVerifySummary")));
			}

		} catch (Exception ex) {
			logger.error("Throwed Exception [EventController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = eventService.getAll();
		}

	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(priorityIdSelected!=null && priorityIdSelected!=0) {
					Priority p = new Priority(priorityIdSelected);
					selected.setPriorityId(p);
					eventService.update(selected);
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
				} else {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, geProperty("priorityRequiredMessage"), geProperty("pleaseVerifySummary")));
				}
			} catch (Exception ex) {
				logger.error("Throwed Exception [EventController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = eventService.getAll();
			}
		}
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				eventService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [EventController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = eventService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new EventDTO();
	}

	public void prepareEdit() {
		this.priorityIdSelected = 0;
	}
	
	public List<EventDTO> getAllEvents() {
		return eventService.getAll();
	}
	
	public Integer getPriorityIdSelected() {
		return priorityIdSelected;
	}

	public void setPriorityIdSelected(Integer priorityIdSelected) {
		this.priorityIdSelected = priorityIdSelected;
	}

	public IEventService getEventService() {
		return eventService;
	}

	public void setEventService(IEventService eventService) {
		this.eventService = eventService;
	}

	public List<EventDTO> getItems() {
		return items;
	}

	public void setItems(List<EventDTO> items) {
		this.items = items;
	}

	public EventDTO getSelected() {
		return selected;
	}

	public void setSelected(EventDTO selected) {
		this.selected = selected;
	}

	public LazyDataModel<EventDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<EventDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
}
