package co.com.core.services;

import java.util.List;

import co.com.core.dto.UploadedFileDTO;


public interface IUploadedFileService {

	public List<UploadedFileDTO> getAll(); 
	
	public void create(UploadedFileDTO dto);
	
	public void delete(UploadedFileDTO dto);
	
	public void update(UploadedFileDTO dto);
}
