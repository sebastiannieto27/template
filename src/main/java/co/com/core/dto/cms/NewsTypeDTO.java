package co.com.core.dto.cms;

import java.util.Date;

import co.com.core.domain.User;

public class NewsTypeDTO {

	private Integer newsTypeId;
	private String newsTypeName;
	private Date dateCre;
	private User userId;
	
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
	public Date getDateCre() {
		return dateCre;
	}
	public void setDateCre(Date dateCre) {
		this.dateCre = dateCre;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "NewsTypeDTO [newsTypeId=" + newsTypeId + ", newsTypeName="
				+ newsTypeName + ", dateCre=" + dateCre + "]";
	}
}
