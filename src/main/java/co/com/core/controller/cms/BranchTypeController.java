package co.com.core.controller.cms;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.dto.cms.BranchTypeDTO;
import co.com.core.services.cms.IBranchTypeService;


public class BranchTypeController {

	IBranchTypeService brandTypeService;
	List<BranchTypeDTO> items;
	private BranchTypeDTO selected;
	private String searchName;
	private static final Logger logger = Logger.getLogger(BranchTypeController.class);
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("branchTypeName", searchName);
		}
		items = brandTypeService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			brandTypeService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [BranchTypeController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = brandTypeService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				brandTypeService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BranchTypeController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = brandTypeService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				brandTypeService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BranchTypeController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = brandTypeService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new BranchTypeDTO();
	}

	public IBranchTypeService getBranchTypeService() {
		return brandTypeService;
	}

	public void setBranchTypeService(IBranchTypeService BranchTypeService) {
		this.brandTypeService = BranchTypeService;
	}

	public List<BranchTypeDTO> getItems() {
		return items;
	}

	public void setItems(List<BranchTypeDTO> items) {
		this.items = items;
	}

	public BranchTypeDTO getSelected() {
		return selected;
	}

	public void setSelected(BranchTypeDTO selected) {
		this.selected = selected;
	}

	public IBranchTypeService getBrandTypeService() {
		return brandTypeService;
	}

	public void setBrandTypeService(IBranchTypeService brandTypeService) {
		this.brandTypeService = brandTypeService;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
}
