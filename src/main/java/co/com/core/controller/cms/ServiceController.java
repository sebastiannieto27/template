package co.com.core.controller.cms;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.springframework.util.StringUtils;

import co.com.core.commons.ApplicationConstants;
import co.com.core.commons.LoadBundle;
import co.com.core.commons.SessionUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.controller.UploadedFileController;
import co.com.core.domain.cms.GeneralStatus;
import co.com.core.domain.cms.NewsType;
import co.com.core.dto.UploadedFileDTO;
import co.com.core.dto.UserDTO;
import co.com.core.dto.cms.BranchDTO;
import co.com.core.dto.cms.CompanyEventDTO;
import co.com.core.dto.cms.ServiceDTO;
import co.com.core.services.cms.IServiceService;


public class ServiceController {
	
	private static final Logger logger = Logger.getLogger(ServiceController.class);
	
	IServiceService serviceService;
	List<ServiceDTO> items;
	private ServiceDTO selected;
	
	private FileUploadEvent thumbnail;
	private FileUploadEvent image;
	private UploadedFileController uploadedFileController;
	
	private UploadedFileDTO thumbailDto;
	private UploadedFileDTO imageDto;
	private boolean showImageFile;
	private boolean showThumbnailFile;
	
	private Integer selectedGeneralStatusId;

	private String searchName;
	private Integer searchStatusId;
	
	private String descriptionForModal;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("serviceName", searchName);
		}
		
		if(searchStatusId!=null && searchStatusId!=0) {
			GeneralStatus searchStatus = new GeneralStatus(searchStatusId);
			filter.put("generalStatusId", searchStatus);
		}
		items = serviceService.getAllFilter(filter);
	}
	
	private UploadedFileDTO createUploadedFile(FileUploadEvent event) {
		return null;//uploadedFileController.upload(event, true);
	}
	
	public void setThumbnailFileUpload(FileUploadEvent event) {
		this.thumbnail = event;
		thumbailDto = createUploadedFile(this.thumbnail);
		this.showThumbnailFile = true;
	}
	
	public void setImageFileUpload(FileUploadEvent event) {
		this.image = event;
		imageDto = createUploadedFile(this.image);
		this.showImageFile = true;
	}
	
	public String getImagePath() {
		if(this.imageDto!=null) {
			return LoadBundle.getApplicationProperty("imagesContextPath") + this.imageDto.getName();
		}
		return "";
	}
	
	public String getThumbnailPath() {
		if(this.thumbailDto!=null) {
			return LoadBundle.getApplicationProperty("imagesContextPath") + this.thumbailDto.getName();
		}
		return "";
	}
	
	public void prepareEdit() {
		this.thumbailDto = new UploadedFileDTO();
		this.thumbailDto.setName(selected.getServiceThumbImgPath());
		this.imageDto = new UploadedFileDTO();
		this.imageDto.setName(selected.getServiceImgPath());
		this.showImageFile = true;
		this.showThumbnailFile = true;
		this.selectedGeneralStatusId = selected.getGeneralStatusId().getGeneralStatusId();
	}
	
	public void showImagesModal(ServiceDTO item) {
		this.thumbailDto = new UploadedFileDTO();
		this.thumbailDto.setName(item.getServiceThumbImgPath());
		this.imageDto = new UploadedFileDTO();
		this.imageDto.setName(item.getServiceImgPath());
		this.showImageFile = true;
		this.showThumbnailFile = true;
	}
	
	public void showItemDescription(ServiceDTO item) {
		this.descriptionForModal = item.getServiceDesc();
	}
	
	public void prepareCreate() {
		selected = new ServiceDTO();
		this.thumbailDto = new UploadedFileDTO();
		this.imageDto = new UploadedFileDTO();
		this.showImageFile = false;
		this.showThumbnailFile = false;
		this.selectedGeneralStatusId = ApplicationConstants.ZERO_CONSTANT_VALUE;
	}
	
	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			if(selectedGeneralStatusId==null || selectedGeneralStatusId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("statusRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
			
			GeneralStatus status = new GeneralStatus(selectedGeneralStatusId);
			selected.setGeneralStatusId(status);
			if(this.thumbnail!=null) {
				selected.setServiceThumbImgPath(this.thumbnail.getFile().getFileName());
			}
			if(this.image!=null) {
				selected.setServiceImgPath(this.image.getFile().getFileName());
			}
			
			UserDTO userDto = SessionUtil.getSessionUser();
			selected.setUserId(UserUtil.getEntityFromDto(userDto));
			selected.setDateCre(new Date());
			serviceService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [ServiceController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = serviceService.getAll();
		}

		return true;
	}

	public boolean save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				
				if(selectedGeneralStatusId==null || selectedGeneralStatusId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("statusRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				GeneralStatus status = new GeneralStatus(selectedGeneralStatusId);
				selected.setGeneralStatusId(status);
				
				if(this.thumbnail!=null) {
					selected.setServiceThumbImgPath(this.thumbnail.getFile().getFileName());
				}
				if(this.image!=null) {
					selected.setServiceImgPath(this.image.getFile().getFileName());
				}
				serviceService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ServiceController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = serviceService.getAll();
			}
		}
		return true;
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				serviceService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ServiceController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = serviceService.getAll();
			}
		}
	}

	public IServiceService getServiceService() {
		return serviceService;
	}

	public void setServiceService(IServiceService ServiceService) {
		this.serviceService = ServiceService;
	}

	public List<ServiceDTO> getItems() {
		return items;
	}

	public void setItems(List<ServiceDTO> items) {
		this.items = items;
	}

	public ServiceDTO getSelected() {
		return selected;
	}

	public void setSelected(ServiceDTO selected) {
		this.selected = selected;
	}

	public UploadedFileController getUploadedFileController() {
		return uploadedFileController;
	}

	public void setUploadedFileController(
			UploadedFileController uploadedFileController) {
		this.uploadedFileController = uploadedFileController;
	}

	public boolean isShowImageFile() {
		return showImageFile;
	}

	public void setShowImageFile(boolean showImageFile) {
		this.showImageFile = showImageFile;
	}

	public boolean isShowThumbnailFile() {
		return showThumbnailFile;
	}

	public void setShowThumbnailFile(boolean showThumbnailFile) {
		this.showThumbnailFile = showThumbnailFile;
	}

	public Integer getSelectedGeneralStatusId() {
		return selectedGeneralStatusId;
	}

	public void setSelectedGeneralStatusId(Integer selectedGeneralStatusId) {
		this.selectedGeneralStatusId = selectedGeneralStatusId;
	}

	public String getDescriptionForModal() {
		return descriptionForModal;
	}

	public void setDescriptionForModal(String descriptionForModal) {
		this.descriptionForModal = descriptionForModal;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Integer getSearchStatusId() {
		return searchStatusId;
	}

	public void setSearchStatusId(Integer searchStatusId) {
		this.searchStatusId = searchStatusId;
	}
	
}
