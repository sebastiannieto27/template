package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import co.com.core.commons.FileUploader;
import co.com.core.commons.LoadBundle;
import co.com.core.commons.SessionUtil;
import co.com.core.commons.converter.UploadedFileUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.dto.UploadedFileDTO;
import co.com.core.dto.UserDTO;
import co.com.core.services.IUploadedFileService;


public class UploadedFileController {

	IUploadedFileService uploadedFileService;
	List<UploadedFileDTO> items;
	private UploadedFileDTO selected;
	private String downloadPath;
	
	private static final Logger logger = Logger.getLogger(UploadedFileController.class);
	
	public static final String PREFIX = "tempPlainFile";
    public static final String SUFFIX = ".xlsx";
	
	public void init() {
		downloadPath = LoadBundle.getApplicationProperty("fileUploadPath");
		items = uploadedFileService.getAll();
	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				uploadedFileService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [UploadedFileController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = uploadedFileService.getAll();
			}
		}
	}
	
	public void downloadFile() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
	    File file = new File("/Users/dienieto/Documents/DocumentsDiego/projects/friogan/images/upload/jsfReporte (2).pdf");
	    HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();  

	    response.setHeader("Content-Disposition", "attachment;filename=jsfReporte (2).pdf");  
	    response.setContentLength((int) file.length());  
	    FileInputStream input= null;  
	    try {
	        int i= 0;
	        input = new FileInputStream(file);  
	        byte[] buffer = new byte[1024];
	        while ((i = input.read(buffer)) != -1) {  
	            response.getOutputStream().write(buffer);  
	            response.getOutputStream().flush();  
	        }               
	        facesContext.responseComplete();
	        facesContext.renderResponse();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(input != null) {
	                input.close();
	            }
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
	    }

	}
	
    //public UploadedFileDTO upload(FileUploadEvent event, boolean alternativePath) {  
	public UploadedFileDTO upload(FileUploadEvent event) {  
    	UploadedFileDTO resultDto = null;
    	try {
    		FacesContext context = FacesContext.getCurrentInstance();
        	UploadedFile file = event.getFile();
        	//common upload path
        	String path  = null;
        	/*if(alternativePath) {
        		path = LoadBundle.getApplicationProperty("serverUploadPath");
        	} else {
        		path = LoadBundle.getApplicationProperty("fileUploadPath");
        	}*/
        	
        	path = LoadBundle.getApplicationProperty("fileUploadPath");
        	
        	//creates the file
        	boolean success = FileUploader.uploadFile(event, path);
        	
        	if(success) {
        		UserDTO userDto = SessionUtil.getSessionUser();
    			if(userDto!=null) {
    				UploadedFileDTO dto = new UploadedFileDTO();
    				dto.setUserId(UserUtil.getEntityFromDto(userDto));
    				dto.setCreationDate(new Timestamp(new Date().getTime()));
    				dto.setSize((int) file.getSize());
    				dto.setName(file.getFileName());
    				
    				co.com.core.domain.UploadedFile entity = uploadedFileService.create(dto);
    				
    				resultDto = UploadedFileUtil.getDtoFromEntity(entity);
    				
    				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
    			} else {
    				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("fileUploadError"), null));
    				logger.error("Error uploading the file: " + file.getFileName() + " UserDto is null");
    			}
        		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("fileUploadSuccess"), null));
        	} else {
        		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("fileUploadError"), null));
        	}
    	} catch(Exception ex) {
    		logger.error("Throwed Exception [UploadedFileController.upload]: " +ex.getMessage());
    	}
    	return resultDto;
    } 
	
	public UploadedFileDTO uploadUseFile(FileUploadEvent event) {  
    	UploadedFileDTO resultDto = null;
    	try {
    		FacesContext context = FacesContext.getCurrentInstance();
        	UploadedFile uploadedFile = event.getFile();

        	InputStream inputStream = uploadedFile.getInputstream();
        	File tempFile = getTemporaryFile(inputStream);
        	Workbook workbook = new XSSFWorkbook(tempFile);
        	
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
        	
    	} catch(Exception ex) {
    		logger.error("Throwed Exception [UploadedFileController.upload]: " +ex.getMessage());
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
	
	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	public IUploadedFileService getUploadedFileService() {
		return uploadedFileService;
	}

	public void setUploadedFileService(IUploadedFileService UploadedFileService) {
		this.uploadedFileService = UploadedFileService;
	}

	public List<UploadedFileDTO> getItems() {
		return items;
	}

	public void setItems(List<UploadedFileDTO> items) {
		this.items = items;
	}

	public UploadedFileDTO getSelected() {
		return selected;
	}

	public void setSelected(UploadedFileDTO selected) {
		this.selected = selected;
	}
}
