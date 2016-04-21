package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.domain.cms.GeneralStatus;
import co.com.core.domain.financial.account.BranchClient;
import co.com.core.dto.financial.account.BillHeadDTO;
import co.com.core.services.financial.account.IBillHeadService;

public class BillHeadController {

private static final Logger logger = Logger.getLogger(BillHeadController.class);
	
	private IBillHeadService billHeadService;
	private List<BillHeadDTO> items;
	private BillHeadDTO selected;
	
	//filters
	private BranchClient branchClientSearch;
	private GeneralStatus generalStatusSearch;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(branchClientSearch!=null) {
			filter.put("branchClientId", branchClientSearch);
		}
		
		if(generalStatusSearch!=null) {
			filter.put("generalStatusId", generalStatusSearch);
		}
			
		items = billHeadService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			billHeadService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [BillHeadController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = billHeadService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				billHeadService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BillHeadController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = billHeadService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				billHeadService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BillHeadController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = billHeadService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new BillHeadDTO();
	}

	public IBillHeadService getBillHeadService() {
		return billHeadService;
	}

	public void setBillHeadService(IBillHeadService BillHeadService) {
		this.billHeadService = BillHeadService;
	}

	public List<BillHeadDTO> getItems() {
		return items;
	}

	public void setItems(List<BillHeadDTO> items) {
		this.items = items;
	}

	public BillHeadDTO getSelected() {
		return selected;
	}

	public void setSelected(BillHeadDTO selected) {
		this.selected = selected;
	}

	public BranchClient getBranchClientSearch() {
		return branchClientSearch;
	}

	public void setBranchClientSearch(BranchClient branchClientSearch) {
		this.branchClientSearch = branchClientSearch;
	}

	public GeneralStatus getGeneralStatusSearch() {
		return generalStatusSearch;
	}

	public void setGeneralStatusSearch(GeneralStatus generalStatusSearch) {
		this.generalStatusSearch = generalStatusSearch;
	}
}
