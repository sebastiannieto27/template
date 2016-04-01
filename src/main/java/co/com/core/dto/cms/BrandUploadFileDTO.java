package co.com.core.dto.cms;

import co.com.core.domain.UploadedFile;
import co.com.core.domain.cms.Brand;

public class BrandUploadFileDTO {
	
	private Integer brandUploadFileId;
    private UploadedFile uploadedFileId;
    private Brand brandId;
    
	public Integer getBrandUploadFileId() {
		return brandUploadFileId;
	}
	public void setBrandUploadFileId(Integer brandUploadFileId) {
		this.brandUploadFileId = brandUploadFileId;
	}
	public UploadedFile getUploadedFileId() {
		return uploadedFileId;
	}
	public void setUploadedFileId(UploadedFile uploadedFileId) {
		this.uploadedFileId = uploadedFileId;
	}
	public Brand getBrandId() {
		return brandId;
	}
	public void setBrandId(Brand brandId) {
		this.brandId = brandId;
	}
	
	@Override
	public String toString() {
		return "BrandUploadedFile [brandUploadFileId=" + brandUploadFileId
				+ ", uploadedFileId=" + uploadedFileId + ", brandId=" + brandId
				+ "]";
	}
}
