package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import co.com.core.commons.converter.psaber.ArchivoPruebaUtil;
import co.com.core.commons.converter.psaber.AreaUtil;
import co.com.core.domain.psaber.Area;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.AreaArchivoPruebaDTO;
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
	
	private ArchivoPruebaDTO selectedArchivoPrueba;
	private AreaArchivoPruebaDTO selectedAreaArchivoPrueba;
	private List<AreaArchivoPruebaDTO> areaItems;
	
	private List<AreaDTO> areaList;
	private List<AreaDTO> areaListSelected;
	private List<AreaArchivoPruebaDTO> deleteAreaItems;
	
	private boolean checkValue;
	private boolean areaArchivoPruebaCheckValue;
	private Integer nroColumna;
	
	public void init() {
		areaList = new ArrayList<>();
		areaListSelected = new ArrayList<>();
		lazyModel = new AreaLazyLoader(areaService);
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

	/*********************************************************************************************************************************
	*************************************************AREA-ARCHIVO PRUEBA MANAGE****************************************************************************/
	/**
	 * Find the Area items related to the ArchivoPrueba
	 * @param archivoPruebaDto
	 */
	public void findAreaByArchivoPrueba(ArchivoPruebaDTO dto) {
		this.selectedArchivoPrueba = dto;
		try {
			areaItems = areaService.findAreaByArchivoPrueba(dto);
			String areaIds = getAreaIds();
			areaList = areaService.getNotAssignedArea(areaIds);
		} catch(Exception ex) {
			logger.error("Error finding areas by ArchivoPrueba: " + ex.getMessage());
		}
	}
	
	/**
	 * add the selected area to the list
	 */
	public void addAreaToArchivoPrueba(AreaDTO areaDto) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(nroColumna != null && nroColumna != 0) {
				AreaArchivoPruebaDTO dto = new AreaArchivoPruebaDTO();
				dto.setArchivoPruebaId(ArchivoPruebaUtil.getEntityFromDto(this.selectedArchivoPrueba));
				dto.setAreaId(AreaUtil.getEntityFromDto(areaDto));
				dto.setNroColumna(nroColumna);
				areaService.createAreaArchivoPrueba(dto);
						
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("addItemSuccess"), null));
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("nroColumnaRequiredMessage"), null));
			}
		} catch(Exception ex) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("addItemError"), null));
			logger.error("Throwed Exception [ArchivoPruebaController.addareaToArchivoPrueba]: " +ex.getMessage());
		} finally {
			nroColumna = 0;
			areaListSelected = new ArrayList<>();
			findAreaByArchivoPrueba(selectedArchivoPrueba);
		}
	}
	
	/**
	 * create a string with the area ids
	 * @return
	 */
	private String getAreaIds() {
		int counter = 0;
		StringBuilder ids = new StringBuilder();
		if(areaItems!=null && areaItems.size() > 0) {
			for(AreaArchivoPruebaDTO dto:  areaItems) {
				if(counter > 0) {
					ids.append(",");
				}
				ids.append(dto.getAreaId().getAreaId());
				counter++;
			}
		}
		return ids.toString();
	}
	
	/**
	 * add the item to the creation list
	 * @param dto
	 */
	public void addRemoveAreaList(AreaDTO dto) {
		try {
			if(checkValue) {
				if(!areaListSelected.contains(dto)) {
					areaListSelected.add(dto);
				}
			} else {
				if(areaListSelected.contains(dto)) {
					areaListSelected.remove(dto);
				}
			}
		} catch(Exception ex) {
			logger.error("Error addRemoveareaList: " + ex.getMessage());
		}
	}
	
	/**
	 * add the item to the deletion list
	 * @param ArchivoPruebaMenu
	 */
	public void addRemoveAreaArchivoPrueba(AreaArchivoPruebaDTO dto) {

		try {
			if(areaArchivoPruebaCheckValue) {
				if(!deleteAreaItems.contains(dto)) {
					deleteAreaItems.add(dto);
				}
			} else {
				if(deleteAreaItems.contains(dto)) {
					deleteAreaItems.remove(dto);
				}
			}
		} catch(Exception ex) {
			logger.error("Error addRemoveAreaArchivoPrueba: " + ex.getMessage());
		}
	}
	
	public void removeAreaFromArchivoPrueba() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(deleteAreaItems!=null && deleteAreaItems.size() > 0) {
				for(AreaArchivoPruebaDTO dto : deleteAreaItems) {
					areaService.deleteAreaArchivoPrueba(dto);
				}
			}
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("removeItemSucces"), null));
		} catch(Exception ex) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("removeItemError"), null));
			logger.error("Throwed Exception [ArchivoPruebaController.removeMenuFromRol]: " +ex.getMessage());
		}  finally {
			deleteAreaItems = new ArrayList<>();
			findAreaByArchivoPrueba(this.selectedArchivoPrueba);
		}
	}
	
	public void ordenColumna(ValueChangeEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			Integer value = Integer.parseInt(event.getNewValue().toString());
			logger.info("Value: " + value);
		} catch(NumberFormatException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, geProperty("fieldMustBeNumber"), null));
		}
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

	public ArchivoPruebaDTO getSelectedArchivoPrueba() {
		return selectedArchivoPrueba;
	}

	public void setSelectedArchivoPrueba(ArchivoPruebaDTO selectedArchivoPrueba) {
		this.selectedArchivoPrueba = selectedArchivoPrueba;
	}

	public AreaArchivoPruebaDTO getSelectedAreaArchivoPrueba() {
		return selectedAreaArchivoPrueba;
	}

	public void setSelectedAreaArchivoPrueba(AreaArchivoPruebaDTO selectedAreaArchivoPrueba) {
		this.selectedAreaArchivoPrueba = selectedAreaArchivoPrueba;
	}

	public List<AreaArchivoPruebaDTO> getAreaItems() {
		return areaItems;
	}

	public void setAreaItems(List<AreaArchivoPruebaDTO> areaItems) {
		this.areaItems = areaItems;
	}

	public List<AreaDTO> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<AreaDTO> areaList) {
		this.areaList = areaList;
	}

	public List<AreaArchivoPruebaDTO> getDeleteAreaItems() {
		return deleteAreaItems;
	}

	public void setDeleteAreaItems(List<AreaArchivoPruebaDTO> deleteAreaItems) {
		this.deleteAreaItems = deleteAreaItems;
	}

	public boolean isCheckValue() {
		return checkValue;
	}

	public void setCheckValue(boolean checkValue) {
		this.checkValue = checkValue;
	}

	public boolean isAreaArchivoPruebaCheckValue() {
		return areaArchivoPruebaCheckValue;
	}

	public void setAreaArchivoPruebaCheckValue(boolean areaArchivoPruebaCheckValue) {
		this.areaArchivoPruebaCheckValue = areaArchivoPruebaCheckValue;
	}

	public Integer getNroColumna() {
		return nroColumna;
	}

	public void setNroColumna(Integer nroColumna) {
		this.nroColumna = nroColumna;
	}
	
	
}
