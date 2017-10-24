package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.primefaces.model.LazyDataModel;

import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.lazy.loader.psaber.ArchivoPruebaLazyLoader;
import co.com.core.services.psaber.IArchivoPruebaService;


public class ArchivoPruebaController {

	private static final Logger logger = Logger.getLogger(ArchivoPruebaController.class);
	
	private IArchivoPruebaService archivoPruebaService;
	private List<ArchivoPruebaDTO> items;
	private ArchivoPruebaDTO selected;
	
	private String searchName;
	
	private LazyDataModel<ArchivoPruebaDTO> lazyModel;
	
	public void init() {
		lazyModel = new ArchivoPruebaLazyLoader(archivoPruebaService);
		Log.error(lazyModel);
	}
	
	/*public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("nombre", searchName);
		}
		
		items = ArchivoPruebaService.getAllFilter(filter);
	}*/

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			archivoPruebaService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [ArchivoPruebaController.saveNew]: " +ex.getMessage());
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
				archivoPruebaService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaController.save]: " +ex.getMessage());
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
				archivoPruebaService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

	public void prepareCreate() {
		selected = new ArchivoPruebaDTO();
	}

	public IArchivoPruebaService getArchivoPruebaService() {
		return archivoPruebaService;
	}

	public void setArchivoPruebaService(IArchivoPruebaService ArchivoPruebaService) {
		this.archivoPruebaService = ArchivoPruebaService;
	}

	public List<ArchivoPruebaDTO> getItems() {
		return items;
	}

	public void setItems(List<ArchivoPruebaDTO> items) {
		this.items = items;
	}

	public ArchivoPruebaDTO getSelected() {
		return selected;
	}

	public void setSelected(ArchivoPruebaDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public LazyDataModel<ArchivoPruebaDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<ArchivoPruebaDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	
}
