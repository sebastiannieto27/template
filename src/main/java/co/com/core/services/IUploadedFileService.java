package co.com.core.services;

import java.util.List;

import co.com.core.domain.UploadedFile;
import co.com.core.dto.UploadedFileDTO;


public interface IUploadedFileService {

	public List<UploadedFileDTO> getAll(); 
	
	public UploadedFile create(UploadedFileDTO dto);
	
	public void delete(UploadedFileDTO dto);
	
	public void update(UploadedFileDTO dto);
}
