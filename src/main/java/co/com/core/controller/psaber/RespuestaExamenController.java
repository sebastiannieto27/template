package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.util.Log;
import org.primefaces.model.LazyDataModel;

import co.com.core.dto.psaber.RespuestaExamenDTO;
import co.com.core.lazy.loader.psaber.RespuestaExamenLazyLoader;
import co.com.core.services.psaber.IRespuestaExamenService;


public class RespuestaExamenController {

	private static final Logger logger = Logger.getLogger(RespuestaExamenController.class);
	
	private IRespuestaExamenService respuestaExamenService;
	private List<RespuestaExamenDTO> items;
	private RespuestaExamenDTO selected;
	
	private String searchName;
	
	private LazyDataModel<RespuestaExamenDTO> lazyModel;
	
	public void init() {
		lazyModel = new RespuestaExamenLazyLoader(respuestaExamenService);
		Log.error(lazyModel);
	}
	
	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			respuestaExamenService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [RespuestaExamenController.saveNew]: " +ex.getMessage());
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
				respuestaExamenService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenController.save]: " +ex.getMessage());
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
				respuestaExamenService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

	public void prepareCreate() {
		selected = new RespuestaExamenDTO();
	}

	public IRespuestaExamenService getRespuestaExamenService() {
		return respuestaExamenService;
	}

	public void setRespuestaExamenService(IRespuestaExamenService RespuestaExamenService) {
		this.respuestaExamenService = RespuestaExamenService;
	}

	public List<RespuestaExamenDTO> getItems() {
		return items;
	}

	public void setItems(List<RespuestaExamenDTO> items) {
		this.items = items;
	}

	public RespuestaExamenDTO getSelected() {
		return selected;
	}

	public void setSelected(RespuestaExamenDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public LazyDataModel<RespuestaExamenDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<RespuestaExamenDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}
}
