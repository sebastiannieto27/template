package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.dto.financial.account.ClientTypeDTO;
import co.com.core.services.financial.account.IClientTypeService;

public class ClientTypeController {

private static final Logger logger = Logger.getLogger(ClientTypeController.class);
	
	private IClientTypeService clientTypeService;
	private List<ClientTypeDTO> items;
	private ClientTypeDTO selected;
	
	//filters
	private String searchName;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("clientTypeName", searchName);
		}
		
		items = clientTypeService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			clientTypeService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [ClientTypeController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = clientTypeService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				clientTypeService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ClientTypeController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = clientTypeService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				clientTypeService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ClientTypeController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = clientTypeService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new ClientTypeDTO();
	}

	public IClientTypeService getClientTypeService() {
		return clientTypeService;
	}

	public void setClientTypeService(IClientTypeService ClientTypeService) {
		this.clientTypeService = ClientTypeService;
	}

	public List<ClientTypeDTO> getItems() {
		return items;
	}

	public void setItems(List<ClientTypeDTO> items) {
		this.items = items;
	}

	public ClientTypeDTO getSelected() {
		return selected;
	}

	public void setSelected(ClientTypeDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

}
