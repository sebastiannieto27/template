package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.UserUtil;
import co.com.core.dto.UploadedFileDTO;
import co.com.core.dto.UserDTO;
import co.com.core.services.IUploadedFileService;


public class UploadedFileController {

	IUploadedFileService uploadedFileService;
	List<UploadedFileDTO> items;
	private UploadedFileDTO selected;
	
	private static final Logger logger = Logger.getLogger(UploadedFileController.class);
	
	public void init() {
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
