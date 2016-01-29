package co.com.core.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import co.com.core.domain.Priority;
import co.com.core.dto.EventDTO;
import co.com.core.lazy.loader.EventLazyLoader;
import co.com.core.services.IEventService;



public class EventController implements Serializable {

	//private static final Logger logger = Logger.getLogger(EventController.class);
	
	IEventService eventService;
	//PriorityBO priorityBO;
	List<EventDTO> items;
	private EventDTO selected;
	private Integer priorityIdSelected;
	
	private LazyDataModel<EventDTO> lazyModel;
	
	public void init() {
		//items = eventService.getAll();
		lazyModel = new EventLazyLoader(eventService);
	}

	public void saveNew() {
		try {
			Priority p = new Priority(priorityIdSelected);
			selected.setPriorityId(p);
			eventService.createEvent(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Evento"));
		} catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Evento"));
		} finally {
			items = eventService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				eventService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Evento"));
			} catch (Exception ex) {
				ex.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Evento"));
			} finally {
				items = eventService.getAll();
			}
		}
	}

	public void save() {
		//logger.error("SAVE NEW METHOD");
		if (this.selected != null) {
			try {
				//Priority p = priorityBO.getPriorityById(priorityIdSelected);
				//logger.error("priority: " + p.toString());
				//selected.setPriorityId(p);
				eventService.updateHQL(selected);
				//eventBO.update(selected);;
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Evento"));
			} catch (Exception ex) {
				ex.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Evento"));
			} finally {
				items = eventService.getAll();
			}
		}
	}


	public void prepareCreate() {
		selected = new EventDTO();
	}

	public void prepareEdit() {
		this.priorityIdSelected = selected.getPriorityId().getPriorityId();
	}
	
	public List<EventDTO> getAllEvents() {
		return eventService.getAll();
	}
	
	public void onRowSelect(SelectEvent event) {
		System.out.println("--- " + event);
		//EventDTO myEvent = (EventDTO) event.getObject();
		//System.out.println("ON ROW SELECT " + myEvent);
        //FacesMessage msg = new FacesMessage("Event Selected", ((EventDTO) event.getObject()).getEventId().toString());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
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

	/*public PriorityBO getPriorityBO() {
		return priorityBO;
	}

	public void setPriorityBO(PriorityBO priorityBO) {
		this.priorityBO = priorityBO;
	}*/

	public LazyDataModel<EventDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<EventDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
}
