package co.com.core.controller.financial.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.dto.financial.account.AccountAgeDTO;
import co.com.core.services.financial.account.IAccountAgeService;


public class AccountAgeController {

	private static final Logger logger = Logger.getLogger(AccountAgeController.class);
	
	private IAccountAgeService accountAgeService;
	private List<AccountAgeDTO> items;
	private AccountAgeDTO selected;

	public void init() {
		items = accountAgeService.getAll();
		Map<String, Object> filter = new HashMap<String, Object>();
	}

	public IAccountAgeService getAccountAgeService() {
		return accountAgeService;
	}

	public void setAccountAgeService(IAccountAgeService accountAgeService) {
		this.accountAgeService = accountAgeService;
	}

	public List<AccountAgeDTO> getItems() {
		return items;
	}

	public void setItems(List<AccountAgeDTO> items) {
		this.items = items;
	}

	public AccountAgeDTO getSelected() {
		return selected;
	}

	public void setSelected(AccountAgeDTO selected) {
		this.selected = selected;
	}
	
}
