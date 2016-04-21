package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.dto.financial.account.ClientDTO;
import co.com.core.services.financial.account.IClientService;

public class ClientController {

private static final Logger logger = Logger.getLogger(ClientController.class);
	
	private IClientService clientService;
	private List<ClientDTO> items;
	private ClientDTO selected;
	
	//filters
	private String searchName;
	private String searchIntCode;
	private String searchClientNumId;
	private String searchClientMail;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("clientName", searchName);
		}
		
		if(StringUtils.hasText(searchIntCode)) {
			filter.put("clientIntCode", searchIntCode);
		}
		
		if(StringUtils.hasText(searchClientNumId)) {
			filter.put("clientNumId", searchClientNumId);
		}
		
		if(StringUtils.hasText(searchClientMail)) {
			filter.put("clientMail", searchClientMail);
		}
			
		items = clientService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			clientService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [ClientController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = clientService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				clientService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ClientController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = clientService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				clientService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ClientController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = clientService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new ClientDTO();
	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService ClientService) {
		this.clientService = ClientService;
	}

	public List<ClientDTO> getItems() {
		return items;
	}

	public void setItems(List<ClientDTO> items) {
		this.items = items;
	}

	public ClientDTO getSelected() {
		return selected;
	}

	public void setSelected(ClientDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchIntCode() {
		return searchIntCode;
	}

	public void setSearchIntCode(String searchIntCode) {
		this.searchIntCode = searchIntCode;
	}

	public String getSearchClientNumId() {
		return searchClientNumId;
	}

	public void setSearchClientNumId(String searchClientNumId) {
		this.searchClientNumId = searchClientNumId;
	}

	public String getSearchClientMail() {
		return searchClientMail;
	}

	public void setSearchClientMail(String searchClientMail) {
		this.searchClientMail = searchClientMail;
	}
}
