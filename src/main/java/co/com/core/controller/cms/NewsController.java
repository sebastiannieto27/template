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
import co.com.core.dto.cms.NewsDTO;
import co.com.core.services.cms.INewsService;


public class NewsController {

	private static final Logger logger = Logger.getLogger(NewsController.class);
	
	private INewsService newsService;
	private List<NewsDTO> items;
	private NewsDTO selected;

	private String descriptionForModal;
	
	private String searchTitle;
	private Integer searchNewsTypeId;
	
	private Integer selectedNewsTypeId;
	private Integer selectedGeneralStatusId;
	
	private UploadedFileController uploadedFileController;
	private FileUploadEvent thumbnail;
	private FileUploadEvent image;
	private FileUploadEvent hdImage;
	private boolean showImageFile;
	private boolean showThumbnailFile;
	private boolean showHdImageFile;
	private String imagePath;
	private String thumbnailPath;
	private UploadedFileDTO thumbailDto;
	private UploadedFileDTO imageDto;
	private UploadedFileDTO hdImageDto;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchTitle)) {
			filter.put("newsTitle", searchTitle);
		}
		
		if(searchNewsTypeId!=null && searchNewsTypeId!=0) {
			NewsType searchType = new NewsType(searchNewsTypeId);
			filter.put("newsTypeId", searchType);
		}
		items = newsService.getAllFilter(filter);
	}
	
	public void setHdImageFileUpload(FileUploadEvent event) {
		this.hdImage = event;
		hdImageDto = createUploadedFile(this.hdImage);
		this.showHdImageFile = true;
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
	
	private UploadedFileDTO createUploadedFile(FileUploadEvent event) {
		return null;//uploadedFileController.upload(event, true);
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
	
	public String getHdImagePath() {
		if(this.hdImageDto!=null) {
			return LoadBundle.getApplicationProperty("imagesContextPath") + this.hdImageDto.getName();
		}
		return "";
	}
	
	public void prepareEdit() {
		this.thumbailDto = new UploadedFileDTO();
		this.thumbailDto.setName(selected.getNewsThumbImgPath());
		this.imageDto = new UploadedFileDTO();
		this.imageDto.setName(selected.getNewsImgPath());
		this.hdImageDto = new UploadedFileDTO();
		this.hdImageDto.setName(selected.getNewsFullImgPath());
		this.showImageFile = true;
		this.showThumbnailFile = true;
		this.showHdImageFile = true;
		this.selectedGeneralStatusId = selected.getGeneralStatusId().getGeneralStatusId();
		this.selectedNewsTypeId = selected.getNewsTypeId().getNewsTypeId();
	}
	
	public void showItemDescription(NewsDTO item) {
		this.descriptionForModal = item.getNewsLongDesc();
	}
	
	public void showImagesModal(NewsDTO item) {
		this.thumbailDto = new UploadedFileDTO();
		this.thumbailDto.setName(item.getNewsThumbImgPath());
		this.imageDto = new UploadedFileDTO();
		this.imageDto.setName(item.getNewsImgPath());
		this.hdImageDto = new UploadedFileDTO();
		this.hdImageDto.setName(item.getNewsFullImgPath());
		this.showImageFile = true;
		this.showThumbnailFile = true;
		this.showHdImageFile = true;
	}
	
	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(this.thumbnail!=null) {
				selected.setNewsThumbImgPath(this.thumbnail.getFile().getFileName());
			}
			if(this.image!=null) {
				selected.setNewsImgPath(this.image.getFile().getFileName());
			}
			if(this.hdImage!=null) {
				selected.setNewsFullImgPath(this.hdImage.getFile().getFileName());
			}
			
			if(selectedNewsTypeId!=null && selectedNewsTypeId!=0) {
				NewsType newsType = new NewsType(selectedNewsTypeId);
				selected.setNewsTypeId(newsType);
			}
			
			if(selectedGeneralStatusId!=null && selectedGeneralStatusId!=0) {
				GeneralStatus generalStatus = new GeneralStatus(selectedGeneralStatusId);
				selected.setGeneralStatusId(generalStatus);
			}
			
			UserDTO userDto = SessionUtil.getSessionUser();
			selected.setUserId(UserUtil.getEntityFromDto(userDto));
			selected.setDateCre(new Date());
			newsService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [NewsController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = newsService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				
				newsService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [NewsController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = newsService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(selectedNewsTypeId!=null && selectedNewsTypeId!=0) {
					NewsType newsType = new NewsType(selectedNewsTypeId);
					selected.setNewsTypeId(newsType);
				}
				
				if(selectedGeneralStatusId!=null && selectedGeneralStatusId!=0) {
					GeneralStatus generalStatus = new GeneralStatus(selectedGeneralStatusId);
					selected.setGeneralStatusId(generalStatus);
				}
				if(this.thumbnail!=null) {
					selected.setNewsThumbImgPath(this.thumbnail.getFile().getFileName());
				}
				if(this.image!=null) {
					selected.setNewsImgPath(this.image.getFile().getFileName());
				}
				if(this.hdImage!=null) {
					selected.setNewsFullImgPath(this.hdImage.getFile().getFileName());
				}
				newsService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [NewsController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = newsService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new NewsDTO();
		this.thumbailDto = new UploadedFileDTO();
		this.imageDto = new UploadedFileDTO();
		this.hdImageDto = new UploadedFileDTO();
		this.showImageFile = false;
		this.showThumbnailFile = false;
		this.showHdImageFile = false;
		this.selectedGeneralStatusId = ApplicationConstants.ZERO_CONSTANT_VALUE;
		this.selectedNewsTypeId = ApplicationConstants.ZERO_CONSTANT_VALUE;
	}

	public INewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(INewsService NewsService) {
		this.newsService = NewsService;
	}

	public List<NewsDTO> getItems() {
		return items;
	}

	public void setItems(List<NewsDTO> items) {
		this.items = items;
	}

	public NewsDTO getSelected() {
		return selected;
	}

	public void setSelected(NewsDTO selected) {
		this.selected = selected;
	}

	public Integer getSelectedNewsTypeId() {
		return selectedNewsTypeId;
	}

	public void setSelectedNewsTypeId(Integer selectedNewsTypeId) {
		this.selectedNewsTypeId = selectedNewsTypeId;
	}

	public Integer getSelectedGeneralStatusId() {
		return selectedGeneralStatusId;
	}

	public void setSelectedGeneralStatusId(Integer selectedGeneralStatusId) {
		this.selectedGeneralStatusId = selectedGeneralStatusId;
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

	public boolean isShowHdImageFile() {
		return showHdImageFile;
	}

	public void setShowHdImageFile(boolean showHdImageFile) {
		this.showHdImageFile = showHdImageFile;
	}

	public String getSearchTitle() {
		return searchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public Integer getSearchNewsTypeId() {
		return searchNewsTypeId;
	}

	public void setSearchNewsTypeId(Integer searchNewsTypeId) {
		this.searchNewsTypeId = searchNewsTypeId;
	}

	public String getDescriptionForModal() {
		return descriptionForModal;
	}

	public void setDescriptionForModal(String descriptionForModal) {
		this.descriptionForModal = descriptionForModal;
	}
}
