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
import co.com.core.commons.converter.cms.BranchUtil;
import co.com.core.controller.UploadedFileController;
import co.com.core.domain.cms.Branch;
import co.com.core.domain.cms.BranchType;
import co.com.core.domain.cms.GeneralStatus;
import co.com.core.dto.UploadedFileDTO;
import co.com.core.dto.UserDTO;
import co.com.core.dto.cms.BranchDTO;
import co.com.core.dto.cms.NewsDTO;
import co.com.core.services.cms.IBranchService;


public class BranchController {

	private static final Logger logger = Logger.getLogger(BranchController.class);
	
	private IBranchService branchService;
	private List<BranchDTO> items;
	private BranchDTO selected;
	private Integer selectedBranchTypeId;
	private Integer selectedGeneralStatusId;
	
	private FileUploadEvent thumbnail;
	private FileUploadEvent image;
	private UploadedFileController uploadedFileController;
	
	private String searchName;
	private String searchAddress;
	private String internalCode;
	
	private UploadedFileDTO thumbailDto;
	private UploadedFileDTO imageDto;
	private boolean showImageFile;
	private boolean showThumbnailFile;
	private String imagePath;
	private String thumbnailPath;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("branchName", searchName);
		}
		
		if(StringUtils.hasText(searchAddress)) {
			filter.put("branchAddress", searchAddress);
		}
			
		if(StringUtils.hasText(internalCode)) {
			filter.put("branchInternalCode", internalCode);
		}
			
		items = branchService.getAllFilter(filter);
	}

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(selectedGeneralStatusId==null || selectedGeneralStatusId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("statusRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
			if(selectedBranchTypeId==null && selectedBranchTypeId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("brandTypeRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
					
			//set the current user
			UserDTO userDto = SessionUtil.getSessionUser();
			selected.setUserId(UserUtil.getEntityFromDto(userDto));
			//set the current date
			selected.setDateCre(new Date());
			//set the brand type
			BranchType brandType = new BranchType(selectedBranchTypeId);
			selected.setBranchTypeId(brandType);
			
			GeneralStatus status = new GeneralStatus(selectedGeneralStatusId);
			selected.setGeneralStatusId(status);
			if(this.thumbnail!=null) {
				selected.setBranchThumbImg(this.thumbnail.getFile().getFileName());
			}
			if(this.image!=null) {
				selected.setBranchBigImg(this.image.getFile().getFileName());
			}
			
			branchService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [BranchController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = branchService.getAll();
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
				if(selectedBranchTypeId==null && selectedBranchTypeId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("brandTypeRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				BranchType brandType = new BranchType(selectedBranchTypeId);
				selected.setBranchTypeId(brandType);
				
				GeneralStatus status = new GeneralStatus(selectedGeneralStatusId);
				selected.setGeneralStatusId(status);
				
				if(this.thumbnail!=null) {
					selected.setBranchThumbImg(this.thumbnail.getFile().getFileName());
				}
				if(this.image!=null) {
					selected.setBranchBigImg(this.image.getFile().getFileName());
				}
				
				Branch brandEntity = BranchUtil.getEntityFromDto(selected);
				
				/*
				 * start creation of the thumbnail file entry
				 */
				if(this.thumbnail!=null) {
					selected.setBranchThumbImg(this.thumbnail.getFile().getFileName());
				}
				/*
				 * end creation of the thumbnail file entry
				 */
				
				/*
				 * start creation of the image file entry
				 */
				if(this.image!=null) {
					selected.setBranchThumbImg(this.image.getFile().getFileName());
				}
				/*
				 * end creation of the mage file entry
				 */
				branchService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BranchController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = branchService.getAll();
			}
		}
		return true;
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				branchService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BranchController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = branchService.getAll();
			}
		}
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
		this.thumbailDto.setName(selected.getBranchThumbImg());
		this.imageDto = new UploadedFileDTO();
		this.imageDto.setName(selected.getBranchBigImg());
		this.showImageFile = true;
		this.showThumbnailFile = true;
		this.selectedBranchTypeId = selected.getBranchTypeId().getBranchTypeId();
		this.selectedGeneralStatusId = selected.getGeneralStatusId().getGeneralStatusId();
	}
	
	public void showImagesModal(BranchDTO item) {
		this.thumbailDto = new UploadedFileDTO();
		this.thumbailDto.setName(item.getBranchThumbImg());
		this.imageDto = new UploadedFileDTO();
		this.imageDto.setName(item.getBranchBigImg());
		this.showImageFile = true;
		this.showThumbnailFile = true;
	}
	
	
	public void prepareCreate() {
		selected = new BranchDTO();
		this.thumbailDto = new UploadedFileDTO();
		this.imageDto = new UploadedFileDTO();
		this.showImageFile = false;
		this.showThumbnailFile = false;
		this.selectedGeneralStatusId = ApplicationConstants.ZERO_CONSTANT_VALUE;
		this.selectedBranchTypeId = ApplicationConstants.ZERO_CONSTANT_VALUE;
	}

	public IBranchService getBranchService() {
		return branchService;
	}

	public void setBranchService(IBranchService BranchService) {
		this.branchService = BranchService;
	}

	public List<BranchDTO> getItems() {
		return items;
	}

	public void setItems(List<BranchDTO> items) {
		this.items = items;
	}

	public BranchDTO getSelected() {
		return selected;
	}

	public void setSelected(BranchDTO selected) {
		this.selected = selected;
	}

	public Integer getSelectedBranchTypeId() {
		return selectedBranchTypeId;
	}

	public void setSelectedBranchTypeId(Integer selectedBranchTypeId) {
		this.selectedBranchTypeId = selectedBranchTypeId;
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

	public String getSearchAddress() {
		return searchAddress;
	}

	public void setSearchAddress(String searchAddress) {
		this.searchAddress = searchAddress;
	}

	public UploadedFileDTO getThumbailDto() {
		return thumbailDto;
	}

	public void setThumbailDto(UploadedFileDTO thumbailDto) {
		this.thumbailDto = thumbailDto;
	}

	public UploadedFileDTO getImageDto() {
		return imageDto;
	}

	public void setImageDto(UploadedFileDTO imageDto) {
		this.imageDto = imageDto;
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

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}
}
