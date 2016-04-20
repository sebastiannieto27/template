package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.dto.financial.account.TaxDTO;
import co.com.core.services.financial.account.ITaxService;

public class TaxController {

private static final Logger logger = Logger.getLogger(TaxController.class);
	
	private ITaxService taxService;
	private List<TaxDTO> items;
	private TaxDTO selected;
	
	//filters
	private String searchName;
	private String searchIntCode;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("taxName", searchName);
		}
		
		if(StringUtils.hasText(searchIntCode)) {
			filter.put("taxIntCode", searchIntCode);
		}
			
		items = taxService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			taxService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [TaxController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = taxService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				taxService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [TaxController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = taxService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				taxService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [TaxController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = taxService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new TaxDTO();
	}

	public ITaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(ITaxService TaxService) {
		this.taxService = TaxService;
	}

	public List<TaxDTO> getItems() {
		return items;
	}

	public void setItems(List<TaxDTO> items) {
		this.items = items;
	}

	public TaxDTO getSelected() {
		return selected;
	}

	public void setSelected(TaxDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchIntCode() {
		return searchIntCode;
	}

	public void setSearchIntCode(String searchIntCode) {
		this.searchIntCode = searchIntCode;
	}
}
