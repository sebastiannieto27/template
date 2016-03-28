package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import co.com.core.commons.LoadBundle;
import co.com.core.dto.UploadedFileDTO;
import co.com.core.services.IUploadedFileService;


public class UploadedFileController {

	IUploadedFileService uploadedFileService;
	List<UploadedFileDTO> items;
	private UploadedFileDTO selected;
	private String downloadPath;
	
	private static final Logger logger = Logger.getLogger(UploadedFileController.class);
	
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
