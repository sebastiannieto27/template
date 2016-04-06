package co.com.core.dto.cms;

import java.util.Date;


public class NewsTypeDTO {
	
	private Integer newsTypeId;
    private String newsTypeName;
    private int userId;
    private Date dateCre;
	public Integer getNewsTypeId() {
		return newsTypeId;
	}
	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	public String getNewsTypeName() {
		return newsTypeName;
	}
	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDateCre() {
		return dateCre;
	}
	public void setDateCre(Date dateCre) {
		this.dateCre = dateCre;
	}
	@Override
	public String toString() {
		return "NewsTypeDTO [newsTypeId=" + newsTypeId + ", newsTypeName="
				+ newsTypeName + ", userId=" + userId + ", dateCre=" + dateCre
				+ "]";
	}
	
    
}
