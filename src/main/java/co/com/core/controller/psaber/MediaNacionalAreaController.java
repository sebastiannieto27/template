package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.primefaces.model.LazyDataModel;

import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.Area;
import co.com.core.dto.psaber.MediaNacionalAreaDTO;
import co.com.core.lazy.loader.psaber.MediaNacionalAreaLazyLoader;
import co.com.core.services.psaber.IMediaNacionalAreaService;


public class MediaNacionalAreaController {

	private static final Logger logger = Logger.getLogger(MediaNacionalAreaController.class);
	
	private IMediaNacionalAreaService mediaNacionalAreaService;
	private List<MediaNacionalAreaDTO> items;
	private MediaNacionalAreaDTO selected;
	

	private Integer areaId;
	private Integer archivoPruebaId;
	
	private LazyDataModel<MediaNacionalAreaDTO> lazyModel;
	
	public void init() {
		lazyModel = new MediaNacionalAreaLazyLoader(mediaNacionalAreaService);
		Log.error(lazyModel);
	}
	
	
	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			if(areaId==null || areaId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("areaRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
			
			if(archivoPruebaId==null || archivoPruebaId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("archivoPrubeaRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
			
			ArchivoPrueba archivoPrueba = new ArchivoPrueba(archivoPruebaId);
			selected.setArchivoPruebaId(archivoPrueba);
			
			Area area = new Area(areaId);
			selected.setAreaId(area);
			mediaNacionalAreaService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [MediaNacionalAreaController.saveNew]: " +ex.getMessage());
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
				if(areaId==null || areaId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("areaRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				
				if(archivoPruebaId==null || archivoPruebaId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("archivoPrubeaRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				
				ArchivoPrueba archivoPrueba = new ArchivoPrueba(archivoPruebaId);
				selected.setArchivoPruebaId(archivoPrueba);
				
				Area area = new Area(areaId);
				selected.setAreaId(area);
				
				mediaNacionalAreaService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MediaNacionalAreaController.save]: " +ex.getMessage());
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
				mediaNacionalAreaService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MediaNacionalAreaController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

	public void prepareCreate() {
		selected = new MediaNacionalAreaDTO();
	}

	public IMediaNacionalAreaService getMediaNacionalAreaService() {
		return mediaNacionalAreaService;
	}

	public void setMediaNacionalAreaService(IMediaNacionalAreaService MediaNacionalAreaService) {
		this.mediaNacionalAreaService = MediaNacionalAreaService;
	}

	public List<MediaNacionalAreaDTO> getItems() {
		return items;
	}

	public void setItems(List<MediaNacionalAreaDTO> items) {
		this.items = items;
	}

	public MediaNacionalAreaDTO getSelected() {
		return selected;
	}

	public void setSelected(MediaNacionalAreaDTO selected) {
		this.selected = selected;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getArchivoPruebaId() {
		return archivoPruebaId;
	}

	public void setArchivoPruebaId(Integer archivoPruebaId) {
		this.archivoPruebaId = archivoPruebaId;
	}

	public LazyDataModel<MediaNacionalAreaDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<MediaNacionalAreaDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
}
