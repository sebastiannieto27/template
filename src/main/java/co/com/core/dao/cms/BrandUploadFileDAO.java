package co.com.core.dao.cms;

import java.util.List;

import co.com.core.domain.cms.BrandUploadFile;

public interface BrandUploadFileDAO {
	
	public List<BrandUploadFile> getAll();
	
	public void create(BrandUploadFile entity);
	
	public void delete(BrandUploadFile entity);
	
	public void update(BrandUploadFile entity);
	
}
