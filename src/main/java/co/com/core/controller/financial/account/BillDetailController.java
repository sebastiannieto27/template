package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.domain.financial.account.BillHead;
import co.com.core.domain.financial.account.Product;
import co.com.core.dto.financial.account.BillDetailDTO;
import co.com.core.services.financial.account.IBillDetailService;

public class BillDetailController {

private static final Logger logger = Logger.getLogger(BillDetailController.class);
	
	private IBillDetailService billDetailService;
	private List<BillDetailDTO> items;
	private BillDetailDTO selected;
	
	//filters
    private Integer billHeadIdSearch;
    private Integer productIdSearch;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(productIdSearch!=null && productIdSearch!=0) {
			Product productId = new Product(productIdSearch);
			filter.put("productId", productId);
		}
		if(billHeadIdSearch!=null && billHeadIdSearch!=0) {
			BillHead billHead = new BillHead(billHeadIdSearch);
			filter.put("billHeadId", billHead);
		}
		
		items = billDetailService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			billDetailService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [BillDetailController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = billDetailService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				billDetailService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BillDetailController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = billDetailService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				billDetailService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BillDetailController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = billDetailService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new BillDetailDTO();
	}

	public List<BillDetailDTO> getItems() {
		return items;
	}

	public void setItems(List<BillDetailDTO> items) {
		this.items = items;
	}

	public BillDetailDTO getSelected() {
		return selected;
	}

	public void setSelected(BillDetailDTO selected) {
		this.selected = selected;
	}

	public IBillDetailService getBillDetailService() {
		return billDetailService;
	}

	public void setBillDetailService(IBillDetailService billDetailService) {
		this.billDetailService = billDetailService;
	}

	public Integer getBillHeadIdSearch() {
		return billHeadIdSearch;
	}

	public void setBillHeadIdSearch(Integer billHeadIdSearch) {
		this.billHeadIdSearch = billHeadIdSearch;
	}

	public Integer getProductIdSearch() {
		return productIdSearch;
	}

	public void setProductIdSearch(Integer productIdSearch) {
		this.productIdSearch = productIdSearch;
	}

	
}
