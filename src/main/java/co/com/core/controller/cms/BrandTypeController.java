package co.com.core.controller.cms;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.commons.SessionUtil;
import co.com.core.dto.cms.BrandTypeDTO;
import co.com.core.services.cms.IBrandTypeService;


public class BrandTypeController {

	IBrandTypeService brandService;
	List<BrandTypeDTO> items;
	private BrandTypeDTO selected;
	
	private static final Logger logger = Logger.getLogger(BrandTypeController.class);
	
	public void init() {
		items = brandService.getAll();
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			logger.error(selected);
			Integer userId = SessionUtil.getSessionUserId();
			selected.setUserId(userId);
			selected.setDateCre(new Date());
			brandService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [BrandTypeController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = brandService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				brandService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BrandTypeController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = brandService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				brandService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BrandTypeController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = brandService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new BrandTypeDTO();
	}

	public IBrandTypeService getBrandTypeService() {
		return brandService;
	}

	public void setBrandTypeService(IBrandTypeService BrandTypeService) {
		this.brandService = BrandTypeService;
	}

	public List<BrandTypeDTO> getItems() {
		return items;
	}

	public void setItems(List<BrandTypeDTO> items) {
		this.items = items;
	}

	public BrandTypeDTO getSelected() {
		return selected;
	}

	public void setSelected(BrandTypeDTO selected) {
		this.selected = selected;
	}
}
