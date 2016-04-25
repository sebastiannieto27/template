package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.domain.financial.account.AccountAge;
import co.com.core.domain.financial.account.AccountAgeType;
import co.com.core.dto.financial.account.AccountAgeDetDTO;
import co.com.core.services.financial.account.IAccountAgeDetService;

public class AccountAgeDetController {

private static final Logger logger = Logger.getLogger(AccountAgeDetController.class);
	
	private IAccountAgeDetService accountAgeDetService;
	private List<AccountAgeDetDTO> items;
	private AccountAgeDetDTO selected;
	
	//filters
	private Integer accountAgeIdSearch;
	private Integer accountAgeTypeIdSearch;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(accountAgeIdSearch!=null && accountAgeIdSearch!=0) {
			AccountAge accountAge = new AccountAge(accountAgeIdSearch);
			filter.put("accountAgeId", accountAge);
		}
		if(accountAgeTypeIdSearch!=null && accountAgeTypeIdSearch!=0) {
			AccountAgeType accountAgeType = new AccountAgeType(accountAgeIdSearch);
			filter.put("accountAgeId", accountAgeType);
		}
		
		items = accountAgeDetService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			accountAgeDetService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [AccountAgeDetController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = accountAgeDetService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				accountAgeDetService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [AccountAgeDetController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = accountAgeDetService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				accountAgeDetService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [AccountAgeDetController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = accountAgeDetService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new AccountAgeDetDTO();
	}

	public IAccountAgeDetService getAccountAgeDetService() {
		return accountAgeDetService;
	}

	public void setAccountAgeDetService(IAccountAgeDetService AccountAgeDetService) {
		this.accountAgeDetService = AccountAgeDetService;
	}

	public List<AccountAgeDetDTO> getItems() {
		return items;
	}

	public void setItems(List<AccountAgeDetDTO> items) {
		this.items = items;
	}

	public AccountAgeDetDTO getSelected() {
		return selected;
	}

	public void setSelected(AccountAgeDetDTO selected) {
		this.selected = selected;
	}

	public Integer getAccountAgeIdSearch() {
		return accountAgeIdSearch;
	}

	public void setAccountAgeIdSearch(Integer accountAgeIdSearch) {
		this.accountAgeIdSearch = accountAgeIdSearch;
	}

	public Integer getAccountAgeTypeIdSearch() {
		return accountAgeTypeIdSearch;
	}

	public void setAccountAgeTypeIdSearch(Integer accountAgeTypeIdSearch) {
		this.accountAgeTypeIdSearch = accountAgeTypeIdSearch;
	}

}
