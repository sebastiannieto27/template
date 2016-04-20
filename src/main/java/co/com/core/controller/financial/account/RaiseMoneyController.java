package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.domain.financial.account.BranchClient;
import co.com.core.domain.financial.account.RaiseMoneyType;
import co.com.core.dto.financial.account.RaiseMoneyDTO;
import co.com.core.services.financial.account.IRaiseMoneyService;

public class RaiseMoneyController {

private static final Logger logger = Logger.getLogger(RaiseMoneyController.class);
	
	private IRaiseMoneyService raiseMoneyService;
	private List<RaiseMoneyDTO> items;
	private RaiseMoneyDTO selected;
	
	//filters
	private Integer branchClientSearch;
	private Integer raiseMoneyTypeSearch;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(branchClientSearch!=null && branchClientSearch!=0) {
			BranchClient branchClient = new BranchClient(branchClientSearch);
			filter.put("branchClient", branchClient);
		}
		if(raiseMoneyTypeSearch!=null && raiseMoneyTypeSearch!=0) {
			RaiseMoneyType raiseMoneyType = new RaiseMoneyType(raiseMoneyTypeSearch);
			filter.put("raiseMoneyType", raiseMoneyType);
		}
		
		items = raiseMoneyService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			raiseMoneyService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [RaiseMoneyController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = raiseMoneyService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				raiseMoneyService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = raiseMoneyService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				raiseMoneyService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = raiseMoneyService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new RaiseMoneyDTO();
	}

	public IRaiseMoneyService getRaiseMoneyService() {
		return raiseMoneyService;
	}

	public void setRaiseMoneyService(IRaiseMoneyService RaiseMoneyService) {
		this.raiseMoneyService = RaiseMoneyService;
	}

	public List<RaiseMoneyDTO> getItems() {
		return items;
	}

	public void setItems(List<RaiseMoneyDTO> items) {
		this.items = items;
	}

	public RaiseMoneyDTO getSelected() {
		return selected;
	}

	public void setSelected(RaiseMoneyDTO selected) {
		this.selected = selected;
	}

	public Integer getBranchClientSearch() {
		return branchClientSearch;
	}

	public void setBranchClientSearch(Integer branchClientSearch) {
		this.branchClientSearch = branchClientSearch;
	}

	public Integer getRaiseMoneyTypeSearch() {
		return raiseMoneyTypeSearch;
	}

	public void setRaiseMoneyTypeSearch(Integer raiseMoneyTypeSearch) {
		this.raiseMoneyTypeSearch = raiseMoneyTypeSearch;
	}
}
