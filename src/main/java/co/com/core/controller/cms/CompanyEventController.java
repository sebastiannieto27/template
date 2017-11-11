package co.com.core.controller.cms;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import co.com.core.commons.query.FilterBean;
import co.com.core.controller.UploadedFileController;
import co.com.core.dto.UploadedFileDTO;
import co.com.core.dto.UserDTO;
import co.com.core.dto.cms.CompanyEventDTO;
import co.com.core.dto.cms.NewsDTO;
import co.com.core.services.cms.ICompanyEventService;


public class CompanyEventController {

	private static final Logger logger = Logger.getLogger(CompanyEventController.class);
	
	private ICompanyEventService companyEventService;
	private List<CompanyEventDTO> items;
	private CompanyEventDTO selected;
	
	private UploadedFileController uploadedFileController;
	private FileUploadEvent thumbnail;
	private FileUploadEvent image;
	private boolean showImageFile;
	private boolean showThumbnailFile;
	private String imagePath;
	private String thumbnailPath;
	private UploadedFileDTO thumbailDto;
	private UploadedFileDTO imageDto;
	
	//filters
	private String searchName;
	private String searchLocation;
	
	private String descriptionForModal;
	
	public void init() {
		
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("companyEventTitle", searchName);
		}
		
		if(StringUtils.hasText(searchLocation)) {
			filter.put("companyEventLocation", searchLocation);
		}
			
		items = companyEventService.getAllFilter(filter);
	}

	
	public void showItemDescription(CompanyEventDTO item) {
		this.descriptionForModal = item.getCompanyEventDesc();
	}
	
	private UploadedFileDTO createUploadedFile(FileUploadEvent event) {
		return null; //uploadedFileController.upload(event, true);
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
		this.thumbailDto.setName(selected.getCompanyEventThumbImg());
		this.imageDto = new UploadedFileDTO();
		this.imageDto.setName(selected.getCompanyEventBigImg());
		this.showImageFile = true;
		this.showThumbnailFile = true;
	}
	
	public void prepareCreate() {
		selected = new CompanyEventDTO();
		this.thumbailDto = new UploadedFileDTO();
		this.imageDto = new UploadedFileDTO();
		this.showImageFile = false;
		this.showThumbnailFile = false;
	}
	
	public void showImagesModal(CompanyEventDTO item) {
		this.thumbailDto = new UploadedFileDTO();
		this.thumbailDto.setName(item.getCompanyEventThumbImg());
		this.imageDto = new UploadedFileDTO();
		this.imageDto.setName(item.getCompanyEventBigImg());
		this.showImageFile = true;
		this.showThumbnailFile = true;
	}
	
	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			if(this.thumbnail!=null) {
				selected.setCompanyEventBigImg(this.image.getFile().getFileName());
			}
			if(this.image!=null) {
				selected.setCompanyEventThumbImg(this.thumbnail.getFile().getFileName());
			}
			
			UserDTO userDto = SessionUtil.getSessionUser();
			selected.setUserId(UserUtil.getEntityFromDto(userDto));
			selected.setDateCre(new Date());
			companyEventService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [CompanyEventController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = companyEventService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				companyEventService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CompanyEventController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = companyEventService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(this.thumbnail!=null) {
					selected.setCompanyEventBigImg(this.image.getFile().getFileName());
				}
				if(this.image!=null) {
					selected.setCompanyEventThumbImg(this.thumbnail.getFile().getFileName());
				}
				companyEventService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CompanyEventController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = companyEventService.getAll();
			}
		}
	}

	

	public ICompanyEventService getCompanyEventService() {
		return companyEventService;
	}

	public void setCompanyEventService(ICompanyEventService CompanyEventService) {
		this.companyEventService = CompanyEventService;
	}

	public List<CompanyEventDTO> getItems() {
		return items;
	}

	public void setItems(List<CompanyEventDTO> items) {
		this.items = items;
	}

	public CompanyEventDTO getSelected() {
		return selected;
	}

	public void setSelected(CompanyEventDTO selected) {
		this.selected = selected;
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

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public UploadedFileController getUploadedFileController() {
		return uploadedFileController;
	}

	public void setUploadedFileController(
			UploadedFileController uploadedFileController) {
		this.uploadedFileController = uploadedFileController;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchLocation() {
		return searchLocation;
	}

	public void setSearchLocation(String searchLocation) {
		this.searchLocation = searchLocation;
	}

	public String getDescriptionForModal() {
		return descriptionForModal;
	}

	public void setDescriptionForModal(String descriptionForModal) {
		this.descriptionForModal = descriptionForModal;
	}
	
}
