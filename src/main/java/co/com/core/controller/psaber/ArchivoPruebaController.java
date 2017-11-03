package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.util.Log;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.UploadedFile;

import com.google.gson.Gson;

import co.com.core.commons.EsquemaRespuesta;
import co.com.core.commons.ItemRespuesta;
import co.com.core.commons.RespuestaExamenProcesado;
import co.com.core.commons.converter.UserUtil;
import co.com.core.commons.converter.psaber.ArchivoPruebaProcesadoUtil;
import co.com.core.commons.converter.psaber.ArchivoPruebaUtil;
import co.com.core.commons.converter.psaber.RespuestaExamenUtil;
import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.dto.UploadedFileDTO;
import co.com.core.dto.UserDTO;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.AreaArchivoPruebaDTO;
import co.com.core.dto.psaber.RespuestaExamenDTO;
import co.com.core.lazy.loader.psaber.ArchivoPruebaLazyLoader;
import co.com.core.services.IUserService;
import co.com.core.services.psaber.IArchivoPruebaProcesadoService;
import co.com.core.services.psaber.IArchivoPruebaService;
import co.com.core.services.psaber.IAreaService;
import co.com.core.services.psaber.IRespuestaExamenService;


public class ArchivoPruebaController {

	private static final Logger logger = Logger.getLogger(ArchivoPruebaController.class);
	public static final String PREFIX = "respuestasUsuario";
    public static final String SUFFIX = ".xlsx";
    
	private IArchivoPruebaService archivoPruebaService;
	private IAreaService areaService;
	private IRespuestaExamenService respuestaExamenService; 
	private IArchivoPruebaProcesadoService archivoPruebaProcesadoService;
	private IUserService userService;
	private ResultadoExamenUsuarioController resultadoExamenUsuarioController;
	
	private List<ArchivoPruebaDTO> items;
	private ArchivoPruebaDTO selected;
	
	private Integer archivoPruebaExcelId;
	private ArchivoPruebaDTO archivoPruebaExcel;
	
	private String searchName;
	
	private LazyDataModel<ArchivoPruebaDTO> lazyModel;
	
	RespuestaExamenDTO respuestaExamenDto;
	
	public void init() {
		lazyModel = new ArchivoPruebaLazyLoader(archivoPruebaService);
		Log.error(lazyModel);
	}

	public void procesarArchivoExcel(File excelFile) {
		
		try {
			SimpleDateFormat dt = new SimpleDateFormat("dd-yyyy-mm'-'hh:mm");
			Date today = new Date();
			String fileName = PREFIX + dt.format(today) + SUFFIX;
	        Workbook workbook = new XSSFWorkbook(excelFile);
	        Sheet datatypeSheet = workbook.getSheetAt(0);
	        Gson gson = new Gson();
	        
	        //get the archvioPrueba dto
	        archivoPruebaExcel = archivoPruebaService.getByArchivoPruebaId(archivoPruebaExcelId);
	        
	        //find all the areas configured to the archivo prueba
	        List<AreaArchivoPruebaDTO> areaArchivoList = areaService.findAreaByArchivoPrueba(archivoPruebaExcel);
	        
	        //Creates an ArchivoPruebaProcesado entry
	        ArchivoPruebaProcesado archivoPruebaProcesadoEntity = new ArchivoPruebaProcesado();
	        archivoPruebaProcesadoEntity.setArchivoPruebaId(ArchivoPruebaUtil.getEntityFromDto(archivoPruebaExcel));
	        archivoPruebaProcesadoEntity.setFecCre(new Date());
	        archivoPruebaProcesadoEntity.setNombreArchivo(fileName);
	        ArchivoPruebaProcesado newArchivoPruebaProcesado = archivoPruebaProcesadoService.create(ArchivoPruebaProcesadoUtil.getDtoFromEntity(archivoPruebaProcesadoEntity));
	        
	        if(newArchivoPruebaProcesado != null) {
	        	if(areaArchivoList!=null && areaArchivoList.size() > 0) {
		        	
		        	//order the rows by user
		        	List<List<Row>> rowsByUser = divideExcelFileByRows(datatypeSheet);
		        	
		        	for(List<Row> rowList : rowsByUser) {
		        		
		        		//objeto padre del json respuesta por usuario
		        		RespuestaExamenProcesado respuestaExamenProcesado = new RespuestaExamenProcesado();
		        		
		        		RespuestaExamen respuestaExamen = new RespuestaExamen();
		        		respuestaExamen.setArchivoPruebaProcesadoId(newArchivoPruebaProcesado);
		        		
		        		List<EsquemaRespuesta> respuestaUsuarioList = new ArrayList<>();
		        		
			        	int rowNumber = 0;
			    		for(AreaArchivoPruebaDTO dto : areaArchivoList ) {
			    			EsquemaRespuesta respuestaObj = new EsquemaRespuesta();
			    			
			    			respuestaObj.setAreaId(dto.getAreaId().getAreaId());
			    			
			    			List<ItemRespuesta> itemList = new ArrayList<>();
			    			
			    			double nroDocumento = 0;
			    			rowNumber = 0;
			    			for(Row userRow : rowList) {

			    					if(userRow.getCell(1) != null && !userRow.getCell(1).toString().isEmpty()) {
			    	        			nroDocumento = userRow.getCell(1).getNumericCellValue();
			    	        			int intNroDoc = (int) nroDocumento;
			    	        			UserDTO userDto = userService.getUserByDocNum(String.valueOf(intNroDoc));
			    	        			respuestaExamen.setUserId(UserUtil.getEntityFromDto(userDto));
			    	        		}
			    	        		
			    	        		String nroPregunta = userRow.getCell(2).getStringCellValue();
			    	        		String respuesta = userRow.getCell(dto.getNroColumna()).getStringCellValue();
			    	        		
			    	        		ItemRespuesta itemRespuesta = new ItemRespuesta();
			    	        		
			    	        		itemRespuesta.setPregunta(nroPregunta);
			    	        		itemRespuesta.setRespuesta(respuesta);
			    	        		
			    	        		itemList.add(itemRespuesta);
			    	        	}
		    					rowNumber++;
			    			
			    			respuestaObj.setItem(itemList);
			    			
			    			respuestaUsuarioList.add(respuestaObj);
			    			respuestaExamenProcesado.setRespuestaExamen(respuestaUsuarioList);
			    			logger.info("OBJ: " + respuestaObj);
			    		}
			    		
			    		String objRespuestaExamen = gson.toJson(respuestaExamenProcesado);
			    		//Blob b = new javax.sql.rowset.serial.SerialBlob(objRespuestaExamen.getBytes());
			    		//Creates an ArchivoPruebaProcesado entry
			    		respuestaExamen.setRespuesta(objRespuestaExamen);
			    		respuestaExamen.setProcesado((short) 0);
			    		respuestaExamenService.create(RespuestaExamenUtil.getDtoFromEntity(respuestaExamen));
			    		logger.info("JSON: " + objRespuestaExamen);
			        }
		        }
	        	
	        	resultadoExamenUsuarioController.procesarRespuestaArchivo(ArchivoPruebaProcesadoUtil.getDtoFromEntity(newArchivoPruebaProcesado));
	        }
	        
		} catch (IOException e) {
			logger.error("Error in the excel processing: " + e.getMessage());
		} catch(Exception e) {
			logger.error("Exception processing excel file: " + e.getMessage());
		} 
	}
	
	
	private List<List<Row>> divideExcelFileByRows(Sheet datatypeSheet) {
		List<List<Row>> excelRows = new ArrayList<List<Row>>();
		
		Iterator<Row> rowiTterator = datatypeSheet.iterator();
		
		int nroDocRwoNumber = 0;
		double nroDocumento = 0;
		List<Row> rowList = new ArrayList<>();
		while (rowiTterator.hasNext()) {
			Row currentRow = rowiTterator.next();
			if(nroDocRwoNumber !=0) {
        		if(currentRow.getCell(1) != null && !currentRow.getCell(1).toString().isEmpty()) {
        			if(currentRow.getCell(1).getNumericCellValue() != nroDocumento && nroDocRwoNumber!=1) {
            			excelRows.add(rowList);
            			rowList = new ArrayList<>();
        			}
        			nroDocumento = currentRow.getCell(1).getNumericCellValue();
        		}
        		
        		rowList.add(currentRow);
        		
        		if(currentRow.getRowNum()==datatypeSheet.getLastRowNum()) {
        			excelRows.add(rowList);
        			return excelRows;
        		}
        	}
        	nroDocRwoNumber++;
		}
		logger.info("---" + excelRows);
		return excelRows;
	} 
	
	public UploadedFileDTO uploadAndUseFile(FileUploadEvent event) {  
    	
		FacesContext context = FacesContext.getCurrentInstance();
		UploadedFileDTO resultDto = null;
		
		if(archivoPruebaExcelId != null && archivoPruebaExcelId !=0) {
	    	try {
	        	UploadedFile uploadedFile = event.getFile();

	        	InputStream inputStream = uploadedFile.getInputstream();
	        	File tempFile = getTemporaryFile(inputStream);
	        	procesarArchivoExcel(tempFile);
	        	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("fileSuccessfullyProcessed"), null));	        	
	    	} catch(Exception ex) {
	    		logger.error("Throwed Exception [ArchivoPruebaController.uploadAndUseFile]: " +ex.getMessage());
	    	}
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("archivoPrubeaRequiredMessage"), null));
		}
		

    	return resultDto;
    } 
	
    public static File getTemporaryFile (InputStream in) throws IOException {
        final File tempFile = File.createTempFile(PREFIX, SUFFIX);
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return tempFile;
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

	public IAreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(IAreaService areaService) {
		this.areaService = areaService;
	}

	public IRespuestaExamenService getRespuestaExamenService() {
		return respuestaExamenService;
	}

	public void setRespuestaExamenService(IRespuestaExamenService respuestaExamenService) {
		this.respuestaExamenService = respuestaExamenService;
	}

	public IArchivoPruebaProcesadoService getArchivoPruebaProcesadoService() {
		return archivoPruebaProcesadoService;
	}

	public void setArchivoPruebaProcesadoService(IArchivoPruebaProcesadoService archivoPruebaProcesadoService) {
		this.archivoPruebaProcesadoService = archivoPruebaProcesadoService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ResultadoExamenUsuarioController getResultadoExamenUsuarioController() {
		return resultadoExamenUsuarioController;
	}

	public void setResultadoExamenUsuarioController(ResultadoExamenUsuarioController resultadoExamenUsuarioController) {
		this.resultadoExamenUsuarioController = resultadoExamenUsuarioController;
	}
}
