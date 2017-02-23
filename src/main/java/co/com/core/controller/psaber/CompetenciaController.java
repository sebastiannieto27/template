package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.commons.converter.psaber.CompetenciaUtil;
import co.com.core.domain.psaber.Competencia;
import co.com.core.domain.psaber.Contenido;
import co.com.core.dto.psaber.CompetenciaDTO;
import co.com.core.services.psaber.ICompetenciaService;


public class CompetenciaController {

	private static final Logger logger = Logger.getLogger(CompetenciaController.class);
	
	private ICompetenciaService competenciaService;
	private List<CompetenciaDTO> items;
	private CompetenciaDTO selected;
	
	private Integer selectedContenidoId;
	
	private String searchName;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("nombre", searchName);
		}
		
		items = competenciaService.getAllFilter(filter);
	}

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			if(selectedContenidoId==null && selectedContenidoId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("contenidoRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
					
			//set the contenido
			Contenido contenidoId = new Contenido(selectedContenidoId);
			selected.setContenidoId(contenidoId);
			
			competenciaService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [CompetenciaController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = competenciaService.getAll();
		}
		return true;
	}

	public boolean save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(selectedContenidoId==null && selectedContenidoId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("contenidoRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				//set the contenido
				Contenido contenidoId = new Contenido(selectedContenidoId);
				selected.setContenidoId(contenidoId);
				
				Competencia entity = CompetenciaUtil.getEntityFromDto(selected);
				
				competenciaService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CompetenciaController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = competenciaService.getAll();
			}
		}
		return true;
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				competenciaService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CompetenciaController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = competenciaService.getAll();
			}
		}
	}

	public void prepareEdit() {
		this.selectedContenidoId = selected.getContenidoId().getContenidoId();
	}
	
	public void prepareCreate() {
		selected = new CompetenciaDTO();
	}

	public ICompetenciaService getCompetenciaService() {
		return competenciaService;
	}

	public void setCompetenciaService(ICompetenciaService CompetenciaService) {
		this.competenciaService = CompetenciaService;
	}

	public List<CompetenciaDTO> getItems() {
		return items;
	}

	public void setItems(List<CompetenciaDTO> items) {
		this.items = items;
	}

	public CompetenciaDTO getSelected() {
		return selected;
	}

	public void setSelected(CompetenciaDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Integer getSelectedContenidoId() {
		return selectedContenidoId;
	}

	public void setSelectedContenidoId(Integer selectedContenidoId) {
		this.selectedContenidoId = selectedContenidoId;
	}
}
