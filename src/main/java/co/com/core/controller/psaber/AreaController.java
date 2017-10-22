package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.primefaces.model.LazyDataModel;

import co.com.core.commons.converter.psaber.AreaUtil;
import co.com.core.domain.psaber.Area;
import co.com.core.dto.psaber.AreaDTO;
import co.com.core.lazy.loader.psaber.AreaLazyLoader;
import co.com.core.services.psaber.IAreaService;


public class AreaController {

	private static final Logger logger = Logger.getLogger(AreaController.class);
	
	private IAreaService areaService;
	private List<AreaDTO> items;
	private AreaDTO selected;
	
	private String searchName;
	
	private LazyDataModel<AreaDTO> lazyModel;
	
	public void init() {
		lazyModel = new AreaLazyLoader(areaService);
		Log.error(lazyModel);
	}
	
	/*public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("nombre", searchName);
		}
		
		items = AreaService.getAllFilter(filter);
	}*/

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			areaService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [AreaController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			init();
		}
		return true;
	}

	public boolean save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				
				Area entity = AreaUtil.getEntityFromDto(selected);
				
				areaService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [AreaController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				init();
			}
		}
		return true;
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				areaService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [AreaController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

	public void prepareCreate() {
		selected = new AreaDTO();
	}

	public IAreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(IAreaService AreaService) {
		this.areaService = AreaService;
	}

	public List<AreaDTO> getItems() {
		return items;
	}

	public void setItems(List<AreaDTO> items) {
		this.items = items;
	}

	public AreaDTO getSelected() {
		return selected;
	}

	public void setSelected(AreaDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public LazyDataModel<AreaDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<AreaDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	
}
