package co.com.core.controller.financial.account;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.dto.financial.account.AlbaranDTO;
import co.com.core.services.financial.account.IAlbaranService;

public class AlbaranController {

	private static final Logger logger = Logger.getLogger(AlbaranController.class);
	
	private IAlbaranService billingService;
	private List<AlbaranDTO> items;
	private AlbaranDTO selected;

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

	public List<AlbaranDTO> getItems() {
		return items;
	}

	public void setItems(List<AlbaranDTO> items) {
		this.items = items;
	}

	public IAlbaranService getAlbaranService() {
		return billingService;
	}

	public void setAlbaranService(IAlbaranService accountStatusService) {
		this.billingService = accountStatusService;
	}

	public AlbaranDTO getSelected() {
		return selected;
	}

	public void setSelected(AlbaranDTO selected) {
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
