package co.com.core.services.cms;

import java.util.List;

import co.com.core.dto.cms.BrandUploadFileDTO;


public interface IBrandUploadFileService {

	public List<BrandUploadFileDTO> getAll(); 
	
	public void create(BrandUploadFileDTO dto);
	
	public void delete(BrandUploadFileDTO dto);
	
	public void update(BrandUploadFileDTO dto);
}
