package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.primefaces.model.LazyDataModel;

import co.com.core.domain.psaber.Pregunta;
import co.com.core.dto.psaber.RespuestaDTO;
import co.com.core.lazy.loader.psaber.RespuestaLazyLoader;
import co.com.core.services.psaber.IRespuestaService;


public class RespuestaController {

	private static final Logger logger = Logger.getLogger(RespuestaController.class);
	
	private IRespuestaService respuestaService;
	private List<RespuestaDTO> items;
	private RespuestaDTO selected;
	private Integer preguntaId;
	private String searchName;
	
	private LazyDataModel<RespuestaDTO> lazyModel;
	
	public void init() {
		lazyModel = new RespuestaLazyLoader(respuestaService);
		Log.error(lazyModel);
	}
	
	/*public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("nombre", searchName);
		}
		
		items = RespuestaService.getAllFilter(filter);
	}*/

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(preguntaId==null || preguntaId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("preguntaRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
			Pregunta pregunta = new Pregunta(preguntaId);
			selected.setPreguntaId(pregunta);
			respuestaService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [RespuestaController.saveNew]: " +ex.getMessage());
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
				if(preguntaId==null || preguntaId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("preguntaRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				Pregunta pregunta = new Pregunta(preguntaId);
				selected.setPreguntaId(pregunta);
				
				respuestaService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RespuestaController.save]: " +ex.getMessage());
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
				respuestaService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RespuestaController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

	public void prepareEdit() {
		this.preguntaId = selected.getPreguntaId().getPreguntaId();
	}
	
	public void prepareCreate() {
		selected = new RespuestaDTO();
	}

	public IRespuestaService getRespuestaService() {
		return respuestaService;
	}

	public void setRespuestaService(IRespuestaService RespuestaService) {
		this.respuestaService = RespuestaService;
	}

	public List<RespuestaDTO> getItems() {
		return items;
	}

	public void setItems(List<RespuestaDTO> items) {
		this.items = items;
	}

	public RespuestaDTO getSelected() {
		return selected;
	}

	public void setSelected(RespuestaDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public LazyDataModel<RespuestaDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<RespuestaDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}

	public Integer getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(Integer preguntaId) {
		this.preguntaId = preguntaId;
	}
}
