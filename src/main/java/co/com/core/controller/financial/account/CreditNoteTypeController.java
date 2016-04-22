package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.dto.financial.account.CreditNoteTypeDTO;
import co.com.core.services.financial.account.ICreditNoteTypeService;

public class CreditNoteTypeController {

private static final Logger logger = Logger.getLogger(CreditNoteTypeController.class);
	
	private ICreditNoteTypeService creditNoteTypeService;
	private List<CreditNoteTypeDTO> items;
	private CreditNoteTypeDTO selected;
	
	//filters
	private String searchName;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("creditNotTypeName", searchName);
		}
		
		items = creditNoteTypeService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			creditNoteTypeService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [CreditNoteTypeController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = creditNoteTypeService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				creditNoteTypeService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CreditNoteTypeController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = creditNoteTypeService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				creditNoteTypeService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CreditNoteTypeController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = creditNoteTypeService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new CreditNoteTypeDTO();
	}

	public ICreditNoteTypeService getCreditNoteTypeService() {
		return creditNoteTypeService;
	}

	public void setCreditNoteTypeService(ICreditNoteTypeService CreditNoteTypeService) {
		this.creditNoteTypeService = CreditNoteTypeService;
	}

	public List<CreditNoteTypeDTO> getItems() {
		return items;
	}

	public void setItems(List<CreditNoteTypeDTO> items) {
		this.items = items;
	}

	public CreditNoteTypeDTO getSelected() {
		return selected;
	}

	public void setSelected(CreditNoteTypeDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

}
