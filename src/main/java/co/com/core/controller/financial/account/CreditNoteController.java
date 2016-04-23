package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.domain.financial.account.BillHead;
import co.com.core.domain.financial.account.BranchClient;
import co.com.core.domain.financial.account.CreditNoteType;
import co.com.core.dto.financial.account.CreditNoteDTO;
import co.com.core.services.financial.account.ICreditNoteService;

public class CreditNoteController {

private static final Logger logger = Logger.getLogger(CreditNoteController.class);
	
	private ICreditNoteService creditNoteService;
	private List<CreditNoteDTO> items;
	private CreditNoteDTO selected;
	
	//filters
	private String creditNotNum = null;
	private Integer branchClientIdSearch;
	private Integer billHeadIdSearch;
	private Integer creditNoteTypeIdSearch;
   
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(creditNotNum)) {
			filter.put("creditNotNum", creditNotNum);
		}
		
		if(branchClientIdSearch!=null && branchClientIdSearch!=0) {
			BranchClient branchClient = new BranchClient(branchClientIdSearch);
			filter.put("branchClientId", branchClient);
		}
		
		if(billHeadIdSearch!=null && billHeadIdSearch!=0) {
			BillHead billHead = new BillHead(billHeadIdSearch);
			filter.put("branchClientId", billHead);
		}
		
		if(creditNoteTypeIdSearch!=null && creditNoteTypeIdSearch!=0) {
			 CreditNoteType creditNoteTypeId = new CreditNoteType(creditNoteTypeIdSearch);
			filter.put("creditNoteTypeId", creditNoteTypeId);
		}
		items = creditNoteService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			creditNoteService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [CreditNoteController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = creditNoteService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				creditNoteService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CreditNoteController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = creditNoteService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				creditNoteService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CreditNoteController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = creditNoteService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new CreditNoteDTO();
	}

	public ICreditNoteService getCreditNoteService() {
		return creditNoteService;
	}

	public void setCreditNoteService(ICreditNoteService CreditNoteService) {
		this.creditNoteService = CreditNoteService;
	}

	public List<CreditNoteDTO> getItems() {
		return items;
	}

	public void setItems(List<CreditNoteDTO> items) {
		this.items = items;
	}

	public CreditNoteDTO getSelected() {
		return selected;
	}

	public void setSelected(CreditNoteDTO selected) {
		this.selected = selected;
	}

	public String getCreditNotNum() {
		return creditNotNum;
	}

	public void setCreditNotNum(String creditNotNum) {
		this.creditNotNum = creditNotNum;
	}

	public Integer getBranchClientIdSearch() {
		return branchClientIdSearch;
	}

	public void setBranchClientIdSearch(Integer branchClientIdSearch) {
		this.branchClientIdSearch = branchClientIdSearch;
	}

	public Integer getBillHeadIdSearch() {
		return billHeadIdSearch;
	}

	public void setBillHeadIdSearch(Integer billHeadIdSearch) {
		this.billHeadIdSearch = billHeadIdSearch;
	}

	public Integer getCreditNoteTypeIdSearch() {
		return creditNoteTypeIdSearch;
	}

	public void setCreditNoteTypeIdSearch(Integer creditNoteTypeIdSearch) {
		this.creditNoteTypeIdSearch = creditNoteTypeIdSearch;
	}

	
}
