package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.primefaces.model.LazyDataModel;

import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;
import co.com.core.lazy.loader.psaber.ArchivoPruebaProcesadoLazyLoader;
import co.com.core.services.psaber.IArchivoPruebaProcesadoService;


public class ArchivoPruebaProcesadoController {

	private static final Logger logger = Logger.getLogger(ArchivoPruebaProcesadoController.class);
	
	private IArchivoPruebaProcesadoService ArchivoPruebaProcesadoService;
	private List<ArchivoPruebaProcesadoDTO> items;
	private ArchivoPruebaProcesadoDTO selected;
	
	private String searchName;
	
	private LazyDataModel<ArchivoPruebaProcesadoDTO> lazyModel;
	
	public void init() {
		lazyModel = new ArchivoPruebaProcesadoLazyLoader(ArchivoPruebaProcesadoService);
		Log.error(lazyModel);
	}
	
	
	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			ArchivoPruebaProcesadoService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [ArchivoPruebaProcesadoController.saveNew]: " +ex.getMessage());
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
				ArchivoPruebaProcesadoService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaProcesadoController.save]: " +ex.getMessage());
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
				ArchivoPruebaProcesadoService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaProcesadoController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

	public void prepareCreate() {
		selected = new ArchivoPruebaProcesadoDTO();
	}

	public IArchivoPruebaProcesadoService getArchivoPruebaProcesadoService() {
		return ArchivoPruebaProcesadoService;
	}

	public void setArchivoPruebaProcesadoService(IArchivoPruebaProcesadoService ArchivoPruebaProcesadoService) {
		this.ArchivoPruebaProcesadoService = ArchivoPruebaProcesadoService;
	}

	public List<ArchivoPruebaProcesadoDTO> getItems() {
		return items;
	}

	public void setItems(List<ArchivoPruebaProcesadoDTO> items) {
		this.items = items;
	}

	public ArchivoPruebaProcesadoDTO getSelected() {
		return selected;
	}

	public void setSelected(ArchivoPruebaProcesadoDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public LazyDataModel<ArchivoPruebaProcesadoDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<ArchivoPruebaProcesadoDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
}
