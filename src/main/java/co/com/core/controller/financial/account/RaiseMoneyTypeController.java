package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.dto.financial.account.RaiseMoneyTypeDTO;
import co.com.core.services.financial.account.IRaiseMoneyTypeService;

public class RaiseMoneyTypeController {

private static final Logger logger = Logger.getLogger(RaiseMoneyTypeController.class);
	
	private IRaiseMoneyTypeService raiseMoneyTypeService;
	private List<RaiseMoneyTypeDTO> items;
	private RaiseMoneyTypeDTO selected;
	
	//filters
	private String searchName;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("raiseMonTypeName", searchName);
		}
		
		items = raiseMoneyTypeService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			raiseMoneyTypeService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [RaiseMoneyTypeController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = raiseMoneyTypeService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				raiseMoneyTypeService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyTypeController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = raiseMoneyTypeService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				raiseMoneyTypeService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyTypeController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = raiseMoneyTypeService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new RaiseMoneyTypeDTO();
	}

	public IRaiseMoneyTypeService getRaiseMoneyTypeService() {
		return raiseMoneyTypeService;
	}

	public void setRaiseMoneyTypeService(IRaiseMoneyTypeService RaiseMoneyTypeService) {
		this.raiseMoneyTypeService = RaiseMoneyTypeService;
	}

	public List<RaiseMoneyTypeDTO> getItems() {
		return items;
	}

	public void setItems(List<RaiseMoneyTypeDTO> items) {
		this.items = items;
	}

	public RaiseMoneyTypeDTO getSelected() {
		return selected;
	}

	public void setSelected(RaiseMoneyTypeDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
}
