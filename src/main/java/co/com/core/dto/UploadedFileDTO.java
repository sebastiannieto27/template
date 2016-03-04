package co.com.core.dto;

import java.sql.Timestamp;

import co.com.core.domain.User;

public class UploadedFileDTO {

	private Integer uploadedFileId;
    private String name;
    private int size;
    private Timestamp creationDate;
    private User userId;
    
	public Integer getUploadedFileId() {
		return uploadedFileId;
	}
	public void setUploadedFileId(Integer uploadedFileId) {
		this.uploadedFileId = uploadedFileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
}
