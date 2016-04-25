package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.domain.financial.account.BillDetail;
import co.com.core.domain.financial.account.Tax;
import co.com.core.dto.financial.account.BillDetailTaxDTO;
import co.com.core.services.financial.account.IBillDetailTaxService;

public class BillDetailTaxController {

private static final Logger logger = Logger.getLogger(BillDetailTaxController.class);
	
	private IBillDetailTaxService billDetailTaxService;
	private List<BillDetailTaxDTO> items;
	private BillDetailTaxDTO selected;
	
	//filters
    private Integer taxIdSearch;
    private Integer billDetailIdSearch;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(taxIdSearch!=null && taxIdSearch!=0) {
			Tax taxId = new Tax(taxIdSearch);
			filter.put("taxId", taxId);
		}
		if(billDetailIdSearch!=null && billDetailIdSearch!=0) {
			BillDetail billDetailId = new BillDetail(taxIdSearch);
			filter.put("billDetailId", billDetailId);
		}
		
		items = billDetailTaxService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			billDetailTaxService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [BillDetailTaxController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = billDetailTaxService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				billDetailTaxService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BillDetailTaxController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = billDetailTaxService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				billDetailTaxService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BillDetailTaxController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = billDetailTaxService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new BillDetailTaxDTO();
	}

	public IBillDetailTaxService getBillDetailTaxService() {
		return billDetailTaxService;
	}

	public void setBillDetailTaxService(IBillDetailTaxService BillDetailTaxService) {
		this.billDetailTaxService = BillDetailTaxService;
	}

	public List<BillDetailTaxDTO> getItems() {
		return items;
	}

	public void setItems(List<BillDetailTaxDTO> items) {
		this.items = items;
	}

	public BillDetailTaxDTO getSelected() {
		return selected;
	}

	public void setSelected(BillDetailTaxDTO selected) {
		this.selected = selected;
	}

	public Integer getTaxIdSearch() {
		return taxIdSearch;
	}

	public void setTaxIdSearch(Integer taxIdSearch) {
		this.taxIdSearch = taxIdSearch;
	}

	public Integer getBillDetailIdSearch() {
		return billDetailIdSearch;
	}

	public void setBillDetailIdSearch(Integer billDetailIdSearch) {
		this.billDetailIdSearch = billDetailIdSearch;
	}
}
