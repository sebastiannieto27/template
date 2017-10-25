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

import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.lazy.loader.psaber.ArchivoPruebaLazyLoader;
import co.com.core.services.psaber.IArchivoPruebaService;


public class ArchivoPruebaController {

	private static final Logger logger = Logger.getLogger(ArchivoPruebaController.class);
	
	private IArchivoPruebaService archivoPruebaService;
	private List<ArchivoPruebaDTO> items;
	private ArchivoPruebaDTO selected;
	
	private Integer archivoPruebaExcelId;
	private ArchivoPruebaDTO archivoPruebaExcel;
	
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

	public void procesarArchivoExcel() {
		
		try {
			FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\diego.nieto\\Documents\\DiegoNieto\\template\\Respuesta_Prueba.xlsx"));
	        Workbook workbook = new XSSFWorkbook(excelFile);
	        Sheet datatypeSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = datatypeSheet.iterator();
	        
	        while (iterator.hasNext()) {
	        	Row currentRow = iterator.next();
	            Iterator<Cell> cellIterator = currentRow.iterator();
	            while (cellIterator.hasNext()) {
	            	Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
                    	logger.info(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    	logger.info(currentCell.getNumericCellValue() + "--");
                    }
	            }
	        }
		} catch(FileNotFoundException fne) {
			logger.error("Error trying to get the excel file: " + fne.getMessage());
		} catch (IOException e) {
			logger.error("Error in the excel processing: " + e.getMessage());
		} catch(Exception e) {
			logger.error("Exception processing excel file: " + e.getMessage());
		} 
	}
	
	public void mostrarInformacionArchivo(ValueChangeEvent event) {
		Integer id = (Integer) event.getNewValue();
		archivoPruebaExcel = archivoPruebaService.getByArchivoPruebaId(id);
		logger.info(archivoPruebaExcel);
	}
	/**
	 * **************************************************************************************************
	 * *****************************ARCHIVO PRUEBA ADMIN*************************************************
	 * **************************************************************************************************
	 */
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

	public Integer getArchivoPruebaExcelId() {
		return archivoPruebaExcelId;
	}

	public void setArchivoPruebaExcelId(Integer archivoPruebaExcelId) {
		this.archivoPruebaExcelId = archivoPruebaExcelId;
	}

	public ArchivoPruebaDTO getArchivoPruebaExcel() {
		return archivoPruebaExcel;
	}

	public void setArchivoPruebaExcel(ArchivoPruebaDTO archivoPruebaExcel) {
		this.archivoPruebaExcel = archivoPruebaExcel;
	}
	
	
}
