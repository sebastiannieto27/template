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

import co.com.core.commons.LoadBundle;
import co.com.core.commons.SessionUtil;
import co.com.core.commons.converter.UploadedFileUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.commons.converter.cms.BrandUtil;
import co.com.core.controller.UploadedFileController;
import co.com.core.domain.cms.Brand;
import co.com.core.domain.cms.BrandType;
import co.com.core.dto.UploadedFileDTO;
import co.com.core.dto.UserDTO;
import co.com.core.dto.cms.BrandDTO;
import co.com.core.dto.cms.BrandUploadFileDTO;
import co.com.core.services.cms.IBrandService;
import co.com.core.services.cms.IBrandUploadFileService;


public class BrandController {

	private static final Logger logger = Logger.getLogger(BrandController.class);
	
	private IBrandService brandService;
	private List<BrandDTO> items;
	private BrandDTO selected;
	private Integer selectedBrandTypeId;
	
	private FileUploadEvent thumbnail;
	private FileUploadEvent image;
	private UploadedFileController uploadedFileController;
	private IBrandUploadFileService brandUploadFileService; 
	
	private String searchName;
	private String searchAddress;
	
	private UploadedFileDTO thumbailDto;
	private UploadedFileDTO imageDto;
	private boolean showImageFile;
	private boolean showThumbnailFile;
	private String imagePath;
	private String thumbnailPath;

	public void init() {
		//items = brandService.getAll();
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("brandName", searchName);
		}
			
		if(StringUtils.hasText(searchAddress)) {
			filter.put("brandAddress", searchAddress);
		}
			
		items = brandService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(selectedBrandTypeId!=null && selectedBrandTypeId!=0) {
				//set the current user
				UserDTO userDto = SessionUtil.getSessionUser();
				selected.setUserId(UserUtil.getEntityFromDto(userDto));
				//set the current date
				selected.setDateCre(new Date());
				//set the brand type
				BrandType brandType = new BrandType(selectedBrandTypeId);
				selected.setBrandTypeId(brandType);
		
				if(this.thumbnail!=null) {
					selected.setBrandThumbImg(this.thumbnail.getFile().getFileName());
				}
				if(this.image!=null) {
					selected.setBrandBigImg(this.image.getFile().getFileName());
				}
				
				Brand brandEntity = brandService.create(selected);
				
				/*
				 * start creation of the thumbnail file entry
				 */
				if(this.thumbnail!=null) {
					selected.setBrandThumbImg(this.thumbnail.getFile().getFileName());
					if(thumbailDto!=null) {
						createBrandUploadReference(thumbailDto, brandEntity);
					}
				}
				/*
				 * end creation of the thumbnail file entry
				 */
				
				/*
				 * start creation of the image file entry
				 */
				if(this.image!=null) {
					selected.setBrandThumbImg(this.image.getFile().getFileName());
					if(imageDto!=null) {
						createBrandUploadReference(imageDto, brandEntity);
					}
				}
				/*
				 * end creation of the mage file entry
				 */
				
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, geProperty("brandTypeRequiredMessage"), geProperty("pleaseVerifySummary")));
			}
			
		} catch (Exception ex) {
			logger.error("Throwed Exception [BrandController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = brandService.getAll();
		}

	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(selectedBrandTypeId!=null && selectedBrandTypeId!=0) {
					BrandType brandType = new BrandType(selectedBrandTypeId);
					selected.setBrandTypeId(brandType);
					
					if(this.thumbnail!=null) {
						selected.setBrandThumbImg(this.thumbnail.getFile().getFileName());
					}
					if(this.image!=null) {
						selected.setBrandBigImg(this.image.getFile().getFileName());
					}
					
					Brand brandEntity = BrandUtil.getEntityFromDto(selected);
					brandService.update(selected);
					
					/*
					 * start creation of the thumbnail file entry
					 */
					if(this.thumbnail!=null) {
						selected.setBrandThumbImg(this.thumbnail.getFile().getFileName());
						if(thumbailDto!=null) {
							createBrandUploadReference(thumbailDto, brandEntity);
						}
					}
					/*
					 * end creation of the thumbnail file entry
					 */
					
					/*
					 * start creation of the image file entry
					 */
					if(this.image!=null) {
						selected.setBrandThumbImg(this.image.getFile().getFileName());
						if(imageDto!=null) {
							createBrandUploadReference(imageDto, brandEntity);
						}
					}
					/*
					 * end creation of the mage file entry
					 */
					
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
				} else {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, geProperty("brandTypeRequiredMessage"), geProperty("pleaseVerifySummary")));
				}
			} catch (Exception ex) {
				logger.error("Throwed Exception [BrandController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = brandService.getAll();
			}
		}
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				brandService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BrandController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = brandService.getAll();
			}
		}
	}

	private UploadedFileDTO createUploadedFile(FileUploadEvent event) {
		return uploadedFileController.upload(event, true);
	}
	
	private void createBrandUploadReference(UploadedFileDTO uploadedFileDTO, Brand brandEntity) {
		BrandUploadFileDTO entryDto = new BrandUploadFileDTO();
		entryDto.setBrandId(brandEntity);
		entryDto.setUploadedFileId(UploadedFileUtil.getEntityFromDto(uploadedFileDTO));
		brandUploadFileService.create(entryDto);
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
	
	public void prepareCreate() {
		selected = new BrandDTO();
	}

	public IBrandService getBrandService() {
		return brandService;
	}

	public void setBrandService(IBrandService BrandService) {
		this.brandService = BrandService;
	}

	public List<BrandDTO> getItems() {
		return items;
	}

	public void setItems(List<BrandDTO> items) {
		this.items = items;
	}

	public BrandDTO getSelected() {
		return selected;
	}

	public void setSelected(BrandDTO selected) {
		this.selected = selected;
	}

	public Integer getSelectedBrandTypeId() {
		return selectedBrandTypeId;
	}

	public void setSelectedBrandTypeId(Integer selectedBrandTypeId) {
		this.selectedBrandTypeId = selectedBrandTypeId;
	}

	public UploadedFileController getUploadedFileController() {
		return uploadedFileController;
	}

	public void setUploadedFileController(
			UploadedFileController uploadedFileController) {
		this.uploadedFileController = uploadedFileController;
	}

	public IBrandUploadFileService getBrandUploadFileService() {
		return brandUploadFileService;
	}

	public void setBrandUploadFileService(
			IBrandUploadFileService brandUploadFileService) {
		this.brandUploadFileService = brandUploadFileService;
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
	
}
