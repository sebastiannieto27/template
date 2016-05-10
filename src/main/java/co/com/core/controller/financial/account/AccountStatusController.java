package co.com.core.controller.financial.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.dto.financial.account.AccountStatusDTO;
import co.com.core.dto.financial.account.DutyPayDTO;
import co.com.core.services.financial.account.IAccountStatusService;
import co.com.core.services.financial.account.IDutyPayService;

public class AccountStatusController {

	private static final Logger logger = Logger.getLogger(AccountStatusController.class);
	
	private IAccountStatusService accountStatusService;
	private IDutyPayService dutyPayService;
	private List<AccountStatusDTO> items;
	private AccountStatusDTO selected;

	private List<DutyPayDTO> dutyItems;
	private DutyPayDTO dutySelected;
	
	private Integer branchClientSearch;
	private String searchClientIdNumber;
	private String searchClientInternalCode;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		items = accountStatusService.getAllFilter(filter);
		dutyItems = dutyPayService.getAll();
	}
	
	public Integer getBranchClientSearch() {
		return branchClientSearch;
	}

	public void setBranchClientSearch(Integer branchClientSearch) {
		this.branchClientSearch = branchClientSearch;
	}

	public String getSearchClientIdNumber() {
		return searchClientIdNumber;
	}

	public void setSearchClientIdNumber(String searchClientIdNumber) {
		this.searchClientIdNumber = searchClientIdNumber;
	}

	public String getSearchClientInternalCode() {
		return searchClientInternalCode;
	}

	public void setSearchClientInternalCode(String searchClientInternalCode) {
		this.searchClientInternalCode = searchClientInternalCode;
	}

	public List<AccountStatusDTO> getItems() {
		return items;
	}

	public void setItems(List<AccountStatusDTO> items) {
		this.items = items;
	}

	public IAccountStatusService getAccountStatusService() {
		return accountStatusService;
	}

	public void setAccountStatusService(IAccountStatusService accountStatusService) {
		this.accountStatusService = accountStatusService;
	}

	public IDutyPayService getDutyPayService() {
		return dutyPayService;
	}

	public void setDutyPayService(IDutyPayService dutyPayService) {
		this.dutyPayService = dutyPayService;
	}

	public AccountStatusDTO getSelected() {
		return selected;
	}

	public void setSelected(AccountStatusDTO selected) {
		this.selected = selected;
	}

	public List<DutyPayDTO> getDutyItems() {
		return dutyItems;
	}

	public void setDutyItems(List<DutyPayDTO> dutyItems) {
		this.dutyItems = dutyItems;
	}

	public DutyPayDTO getDutySelected() {
		return dutySelected;
	}

	public void setDutySelected(DutyPayDTO dutySelected) {
		this.dutySelected = dutySelected;
	}
	
}
