package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import co.com.core.commons.converter.psaber.PreguntaUtil;
import co.com.core.domain.psaber.Pregunta;
import co.com.core.dto.psaber.PreguntaDTO;
import co.com.core.lazy.loader.psaber.PreguntaLazyLoader;
import co.com.core.services.psaber.IPreguntaService;


public class PreguntaController {

	private static final Logger logger = Logger.getLogger(PreguntaController.class);
	
	private IPreguntaService preguntaService;
	private List<PreguntaDTO> items;
	private PreguntaDTO selected;
	
	private String searchName;
	
	private LazyDataModel<PreguntaDTO> lazyModel;
	
	public void init() {
		lazyModel = new PreguntaLazyLoader(preguntaService);
	}
	
	public void rowSelection(SelectEvent event) {
		logger.info("Event: " + event.getObject());
	}
	
	/*public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("nombre", searchName);
		}
		
		items = PreguntaService.getAllFilter(filter);
	}*/

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			preguntaService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
			init();
		} catch (Exception ex) {
			logger.error("Throwed Exception [PreguntaController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			//items = preguntaService.getAll();
		}
		return true;
	}

	public boolean save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				
				Pregunta entity = PreguntaUtil.getEntityFromDto(selected);
				
				preguntaService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [PreguntaController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = preguntaService.getAll();
			}
		}
		return true;
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				preguntaService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [PreguntaController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = preguntaService.getAll();
			}
		}
	}

	
	
	public void prepareCreate() {
		selected = new PreguntaDTO();
	}

	public IPreguntaService getPreguntaService() {
		return preguntaService;
	}

	public void setPreguntaService(IPreguntaService PreguntaService) {
		this.preguntaService = PreguntaService;
	}

	public List<PreguntaDTO> getItems() {
		return items;
	}

	public void setItems(List<PreguntaDTO> items) {
		this.items = items;
	}

	public PreguntaDTO getSelected() {
		return selected;
	}

	public void setSelected(PreguntaDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public LazyDataModel<PreguntaDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<PreguntaDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
}
