package co.com.core.controller.financial.account;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.dto.financial.account.PaymentDTO;
import co.com.core.services.financial.account.IPaymentService;

public class PaymentController {

	private static final Logger logger = Logger.getLogger(PaymentController.class);
	
	private IPaymentService paymentService;
	private List<PaymentDTO> items;
	private PaymentDTO selected;

	private Integer branchClientSearch;
	private Integer paymentTypeSearch;
	private String searchClientIdNumber;
	private String searchClientInternalCode;
	private Date startDate;
	private Date endDate;
	
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		items = paymentService.getAllFilter(filter);
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

	public List<PaymentDTO> getItems() {
		return items;
	}

	public void setItems(List<PaymentDTO> items) {
		this.items = items;
	}

	public IPaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(IPaymentService accountStatusService) {
		this.paymentService = accountStatusService;
	}

	public PaymentDTO getSelected() {
		return selected;
	}

	public void setSelected(PaymentDTO selected) {
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

	public Integer getPaymentTypeSearch() {
		return paymentTypeSearch;
	}

	public void setPaymentTypeSearch(Integer paymentTypeSearch) {
		this.paymentTypeSearch = paymentTypeSearch;
	}
	
}
