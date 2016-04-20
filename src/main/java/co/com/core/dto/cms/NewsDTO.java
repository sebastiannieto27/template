package co.com.core.dto.cms;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.core.domain.User;
import co.com.core.domain.cms.GeneralStatus;
import co.com.core.domain.cms.NewsType;

public class NewsDTO {
	
	private Integer newId;
    private String newsTitle;
    private Date newsDateStart;
    private Date newsDateExpire;
    private String newsShortDescr;
    private String newsLongDesc;
    private String newsImgCaption;
    private String newsFullImgPath;
    private String newsImgPath;
    private String newsThumbImgPath;
    private String newsRelativeLink;
    private Date dateCre;
    private User userId;
    private GeneralStatus generalStatusId;
    private NewsType newsTypeId;
	public Integer getNewId() {
		return newId;
	}
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public Date getNewsDateStart() {
		return newsDateStart;
	}
	public void setNewsDateStart(Date newsDateStart) {
		this.newsDateStart = newsDateStart;
	}
	public Date getNewsDateExpire() {
		return newsDateExpire;
	}
	public void setNewsDateExpire(Date newsDateExpire) {
		this.newsDateExpire = newsDateExpire;
	}
	public String getNewsShortDescr() {
		return newsShortDescr;
	}
	public void setNewsShortDescr(String newsShortDescr) {
		this.newsShortDescr = newsShortDescr;
	}
	public String getNewsLongDesc() {
		return newsLongDesc;
	}
	public void setNewsLongDesc(String newsLongDesc) {
		this.newsLongDesc = newsLongDesc;
	}
	public String getNewsImgCaption() {
		return newsImgCaption;
	}
	public void setNewsImgCaption(String newsImgCaption) {
		this.newsImgCaption = newsImgCaption;
	}
	public String getNewsFullImgPath() {
		return newsFullImgPath;
	}
	public void setNewsFullImgPath(String newsFullImgPath) {
		this.newsFullImgPath = newsFullImgPath;
	}
	public String getNewsImgPath() {
		return newsImgPath;
	}
	public void setNewsImgPath(String newsImgPath) {
		this.newsImgPath = newsImgPath;
	}
	public String getNewsThumbImgPath() {
		return newsThumbImgPath;
	}
	public void setNewsThumbImgPath(String newsThumbImgPath) {
		this.newsThumbImgPath = newsThumbImgPath;
	}
	public String getNewsRelativeLink() {
		return newsRelativeLink;
	}
	public void setNewsRelativeLink(String newsRelativeLink) {
		this.newsRelativeLink = newsRelativeLink;
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
	public GeneralStatus getGeneralStatusId() {
		return generalStatusId;
	}
	public void setGeneralStatusId(GeneralStatus generalStatusId) {
		this.generalStatusId = generalStatusId;
	}
	public NewsType getNewsTypeId() {
		return newsTypeId;
	}
	public void setNewsTypeId(NewsType newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	@Override
	public String toString() {
		return "NewsDTO [newId=" + newId + ", newsTitle=" + newsTitle
				+ ", newsDateStart=" + newsDateStart + ", newsDateExpire="
				+ newsDateExpire + ", newsShortDescr=" + newsShortDescr
				+ ", newsLongDesc=" + newsLongDesc + ", newsImgCaption="
				+ newsImgCaption + ", newsFullImgPath=" + newsFullImgPath
				+ ", newsImgPath=" + newsImgPath + ", newsThumbImgPath="
				+ newsThumbImgPath + ", newsRelativeLink=" + newsRelativeLink
				+ ", dateCre=" + dateCre + ", userId=" + userId
				+ ", generalStatusId=" + generalStatusId + ", newsTypeId="
				+ newsTypeId + "]";
	}

    
}
