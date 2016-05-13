package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.behavior.Behavior;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.dto.financial.account.AccountAgeTypeDTO;
import co.com.core.services.financial.account.IAccountAgeTypeService;

public class AccountAgeTypeController {

private static final Logger logger = Logger.getLogger(AccountAgeTypeController.class);
	
	private IAccountAgeTypeService accountAgeTypeService;
	private List<AccountAgeTypeDTO> items;
	private AccountAgeTypeDTO selected;
	
	//filters
	private String searchName;
	
	public void init() {
		
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("accountAgeTypeName", searchName);
		}
		
		items = accountAgeTypeService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			accountAgeTypeService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [AccountAgeTypeController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = accountAgeTypeService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				accountAgeTypeService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [AccountAgeTypeController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = accountAgeTypeService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				accountAgeTypeService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [AccountAgeTypeController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = accountAgeTypeService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new AccountAgeTypeDTO();
	}
	
	public void prepareEdit() {
	}
	
	public IAccountAgeTypeService getAccountAgeTypeService() {
		return accountAgeTypeService;
	}

	public void setAccountAgeTypeService(IAccountAgeTypeService AccountAgeTypeService) {
		this.accountAgeTypeService = AccountAgeTypeService;
	}

	public List<AccountAgeTypeDTO> getItems() {
		return items;
	}

	public void setItems(List<AccountAgeTypeDTO> items) {
		this.items = items;
	}

	public AccountAgeTypeDTO getSelected() {
		return selected;
	}

	public void setSelected(AccountAgeTypeDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	

}
