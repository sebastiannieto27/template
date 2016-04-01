package co.com.core.dao;

import java.util.List;

import co.com.core.domain.UploadedFile;

public interface UploadedFileDAO {
	
	public List<UploadedFile> getAll();
	
	public UploadedFile create(UploadedFile entity);
	
	public void delete(UploadedFile entity);
	
	public void update(UploadedFile entity);
	
}
