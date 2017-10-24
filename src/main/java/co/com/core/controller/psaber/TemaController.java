package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import co.com.core.commons.converter.psaber.PreguntaUtil;
import co.com.core.commons.converter.psaber.TemaUtil;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.Tema;
import co.com.core.dto.psaber.PreguntaDTO;
import co.com.core.dto.psaber.PreguntaTemaDTO;
import co.com.core.dto.psaber.TemaDTO;
import co.com.core.lazy.loader.psaber.TemaLazyLoader;
import co.com.core.services.psaber.ITemaService;


public class TemaController {

	private static final Logger logger = Logger.getLogger(TemaController.class);
	
	private ITemaService temaService;
	private List<TemaDTO> items;
	private TemaDTO selected;
	
	private Integer areaId;
	
	private String searchName;
	
	private LazyDataModel<TemaDTO> lazyModel;
	
	private PreguntaDTO selectedPregunta;
	private PreguntaTemaDTO selectedPreguntaTema;
	private List<PreguntaTemaDTO> temaItems;
	
	private List<TemaDTO> temaList;
	private List<PreguntaTemaDTO> deleteTemaItems;
	
	private boolean checkValue;
	private boolean preguntaTemaCheckValue;
	
	public void init() {
		temaList = new ArrayList<>();
		temaItems = new ArrayList<>();
		lazyModel = new TemaLazyLoader(temaService);
	}
	
	public void rowSelection(SelectEvent event) {
		logger.info("Event: " + event.getObject());
	}
	
	/*public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("nombre", searchName);
		}
		
		items = TemaService.getAllFilter(filter);
	}*/

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			if(areaId==null || areaId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("areaRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
			Area area = new Area(areaId);
			selected.setAreaId(area);
			
			temaService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
			init();
		} catch (Exception ex) {
			logger.error("Throwed Exception [TemaController.saveNew]: " +ex.getMessage());
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
				Area area = new Area(areaId);
				selected.setAreaId(area);
				
				temaService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
				init();
			} catch (Exception ex) {
				logger.error("Throwed Exception [TemaController.save]: " +ex.getMessage());
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
				temaService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [TemaController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

	public void prepareEdit() {
		this.areaId = selected.getAreaId().getAreaId();
	}
	
	public void prepareCreate() {
		selected = new TemaDTO();
	}

	/*********************************************************************************************************************************
	*************************************************TEMA MANAGE****************************************************************************/
	/**
	 * Find the Tema items related to the Pregunta
	 * @param preguntaDto
	 */
	public void findTemaByPregunta(PreguntaDTO dto) {
		this.selectedPregunta = dto;
		try {
			temaItems = temaService.findTemaByPregunta(dto);
			String temaIds = getTemaIds();
			temaList = temaService.getNotAssignedTema(temaIds);
		} catch(Exception ex) {
			logger.error("Error finding temas by Pregunta: " + ex.getMessage());
		}
	}
	
	/**
	 * add the selected tema to the list
	 */
	public void addTemaToPregunta() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(temaList!=null && temaList.size() > 0) {
				for(TemaDTO item : temaList) {
					PreguntaTemaDTO dto = new PreguntaTemaDTO();
					dto.setPreguntaId(PreguntaUtil.getEntityFromDto(this.selectedPregunta));
					dto.setTemaId(TemaUtil.getEntityFromDto(item));
					temaService.createPreguntaTema(dto);
				}
			}
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("addItemSuccess"), null));
		} catch(Exception ex) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("addItemError"), null));
			logger.error("Throwed Exception [PreguntaController.addTemaToPregunta]: " +ex.getMessage());
		} finally {
			temaList = new ArrayList<>();
			findTemaByPregunta(selectedPregunta);
		}
	}
	
	/**
	 * create a string with the tema ids
	 * @return
	 */
	private String getTemaIds() {
		int counter = 0;
		StringBuilder ids = new StringBuilder();
		if(temaItems!=null && temaItems.size() > 0) {
			for(PreguntaTemaDTO dto:  temaItems) {
				if(counter > 0) {
					ids.append(",");
				}
				ids.append(dto.getTemaId().getTemaId());
				counter++;
			}
		}
		return ids.toString();
	}
	
	/**
	 * add the item to the creation list
	 * @param dto
	 */
	public void addRemoveTemaList(TemaDTO dto) {
		try {
			if(checkValue) {
				if(!temaList.contains(dto)) {
					temaList.add(dto);
				}
			} else {
				if(temaList.contains(dto)) {
					temaList.remove(dto);
				}
			}
		} catch(Exception ex) {
			logger.error("Error addRemoveTemaList: " + ex.getMessage());
		}
	}
	
	/**
	 * add the item to the deletion list
	 * @param PreguntaMenu
	 */
	public void addRemovePreguntaTema(PreguntaTemaDTO dto) {

		try {
			if(preguntaTemaCheckValue) {
				if(!deleteTemaItems.contains(dto)) {
					deleteTemaItems.add(dto);
				}
			} else {
				if(deleteTemaItems.contains(dto)) {
					deleteTemaItems.remove(dto);
				}
			}
		} catch(Exception ex) {
			logger.error("Error addRemovePreguntaTema: " + ex.getMessage());
		}
	}
	
	public void removeTemaFromPregunta() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(deleteTemaItems!=null && deleteTemaItems.size() > 0) {
				for(PreguntaTemaDTO dto : deleteTemaItems) {
					temaService.deletePreguntaTema(dto);
				}
			}
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("removeItemSucces"), null));
		} catch(Exception ex) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("removeItemError"), null));
			logger.error("Throwed Exception [PreguntaController.removeMenuFromRol]: " +ex.getMessage());
		}  finally {
			deleteTemaItems = new ArrayList<>();
			findTemaByPregunta(this.selectedPregunta);
		}
	}
	
	
	public ITemaService getTemaService() {
		return temaService;
	}

	public void setTemaService(ITemaService TemaService) {
		this.temaService = TemaService;
	}

	public List<TemaDTO> getItems() {
		return items;
	}

	public void setItems(List<TemaDTO> items) {
		this.items = items;
	}

	public TemaDTO getSelected() {
		return selected;
	}

	public void setSelected(TemaDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public LazyDataModel<TemaDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<TemaDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	public PreguntaDTO getSelectedPregunta() {
		return selectedPregunta;
	}

	public void setSelectedPregunta(PreguntaDTO selectedPregunta) {
		this.selectedPregunta = selectedPregunta;
	}

	public PreguntaTemaDTO getSelectedPreguntaTema() {
		return selectedPreguntaTema;
	}

	public void setSelectedPreguntaTema(PreguntaTemaDTO selectedPreguntaTema) {
		this.selectedPreguntaTema = selectedPreguntaTema;
	}

	public List<PreguntaTemaDTO> getTemaItems() {
		return temaItems;
	}

	public void setTemaItems(List<PreguntaTemaDTO> temaItems) {
		this.temaItems = temaItems;
	}

	public boolean isCheckValue() {
		return checkValue;
	}

	public void setCheckValue(boolean checkValue) {
		this.checkValue = checkValue;
	}

	public boolean isPreguntaTemaCheckValue() {
		return preguntaTemaCheckValue;
	}

	public void setPreguntaTemaCheckValue(boolean preguntaTemaCheckValue) {
		this.preguntaTemaCheckValue = preguntaTemaCheckValue;
	}

	public List<TemaDTO> getTemaList() {
		return temaList;
	}

	public void setTemaList(List<TemaDTO> temaList) {
		this.temaList = temaList;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
}
