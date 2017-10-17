package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.commons.converter.psaber.MateriaUtil;
import co.com.core.domain.psaber.Materia;
import co.com.core.domain.psaber.Componente;
import co.com.core.dto.psaber.MateriaDTO;
import co.com.core.services.psaber.IMateriaService;


public class MateriaController {

	private static final Logger logger = Logger.getLogger(MateriaController.class);
	
	private IMateriaService MateriaService;
	private List<MateriaDTO> items;
	private MateriaDTO selected;
	
	private Integer selectedComponenteId;
	
	private String searchName;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("nombre", searchName);
		}
		
		items = MateriaService.getAllFilter(filter);
	}

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			if(selectedComponenteId==null && selectedComponenteId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("componenteRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
					
			//set the Componente
			Componente componenteId = new Componente(selectedComponenteId);
			selected.setComponenteId(componenteId);
			
			MateriaService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [MateriaController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = MateriaService.getAll();
		}
		return true;
	}

	public boolean save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(selectedComponenteId==null && selectedComponenteId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("componenteRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				//set the Componente
				Componente componenteId = new Componente(selectedComponenteId);
				selected.setComponenteId(componenteId);
				
				Materia entity = MateriaUtil.getEntityFromDto(selected);
				
				MateriaService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MateriaController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = MateriaService.getAll();
			}
		}
		return true;
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				MateriaService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MateriaController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = MateriaService.getAll();
			}
		}
	}

	public void prepareEdit() {
		this.selectedComponenteId = selected.getComponenteId().getComponenteId();
	}
	
	public void prepareCreate() {
		selected = new MateriaDTO();
	}

	public IMateriaService getMateriaService() {
		return MateriaService;
	}

	public void setMateriaService(IMateriaService MateriaService) {
		this.MateriaService = MateriaService;
	}

	public List<MateriaDTO> getItems() {
		return items;
	}

	public void setItems(List<MateriaDTO> items) {
		this.items = items;
	}

	public MateriaDTO getSelected() {
		return selected;
	}

	public void setSelected(MateriaDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Integer getSelectedComponenteId() {
		return selectedComponenteId;
	}

	public void setSelectedComponenteId(Integer selectedComponenteId) {
		this.selectedComponenteId = selectedComponenteId;
	}
}
