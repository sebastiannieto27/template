package co.com.core.controller.financial.account;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.dto.financial.account.BillingDTO;
import co.com.core.services.financial.account.IBillingService;

public class BillingController {

	private static final Logger logger = Logger.getLogger(BillingController.class);
	
	private IBillingService billingService;
	private List<BillingDTO> items;
	private BillingDTO selected;

	private Integer branchClientSearch;
	private String searchClientIdNumber;
	private String searchClientInternalCode;
	private Date startDate;
	private Date endDate;
	
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		items = billingService.getAllFilter(filter);
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

	public List<BillingDTO> getItems() {
		return items;
	}

	public void setItems(List<BillingDTO> items) {
		this.items = items;
	}

	public IBillingService getBillingService() {
		return billingService;
	}

	public void setBillingService(IBillingService accountStatusService) {
		this.billingService = accountStatusService;
	}

	public BillingDTO getSelected() {
		return selected;
	}

	public void setSelected(BillingDTO selected) {
		this.selected = selected;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
