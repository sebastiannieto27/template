/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.cms;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import co.com.core.domain.User;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewId", query = "SELECT n FROM News n WHERE n.newId = :newId"),
    @NamedQuery(name = "News.findByNewsTitle", query = "SELECT n FROM News n WHERE n.newsTitle = :newsTitle"),
    @NamedQuery(name = "News.findByNewsDateStart", query = "SELECT n FROM News n WHERE n.newsDateStart = :newsDateStart"),
    @NamedQuery(name = "News.findByNewsDateExpire", query = "SELECT n FROM News n WHERE n.newsDateExpire = :newsDateExpire"),
    @NamedQuery(name = "News.findByNewsShortDescr", query = "SELECT n FROM News n WHERE n.newsShortDescr = :newsShortDescr"),
    @NamedQuery(name = "News.findByNewsLongDesc", query = "SELECT n FROM News n WHERE n.newsLongDesc = :newsLongDesc"),
    @NamedQuery(name = "News.findByNewsImgCaption", query = "SELECT n FROM News n WHERE n.newsImgCaption = :newsImgCaption"),
    @NamedQuery(name = "News.findByNewsFullImgPath", query = "SELECT n FROM News n WHERE n.newsFullImgPath = :newsFullImgPath"),
    @NamedQuery(name = "News.findByNewsImgPath", query = "SELECT n FROM News n WHERE n.newsImgPath = :newsImgPath"),
    @NamedQuery(name = "News.findByNewsThumbImgPath", query = "SELECT n FROM News n WHERE n.newsThumbImgPath = :newsThumbImgPath"),
    @NamedQuery(name = "News.findByNewsRelativeLink", query = "SELECT n FROM News n WHERE n.newsRelativeLink = :newsRelativeLink"),
    @NamedQuery(name = "News.findByDateCre", query = "SELECT n FROM News n WHERE n.dateCre = :dateCre")})
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "new_id")
    private Integer newId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "news_title")
    private String newsTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "news_date_start")
    @Temporal(TemporalType.DATE)
    private Date newsDateStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "news_date_expire")
    @Temporal(TemporalType.DATE)
    private Date newsDateExpire;
    @Size(max = 200)
    @Column(name = "news_short_descr")
    private String newsShortDescr;
    @Size(max = 2000)
    @Column(name = "news_long_desc")
    private String newsLongDesc;
    @Size(max = 150)
    @Column(name = "news_img_caption")
    private String newsImgCaption;
    @Size(max = 150)
    @Column(name = "news_full_img_path")
    private String newsFullImgPath;
    @Size(max = 150)
    @Column(name = "news_img_path")
    private String newsImgPath;
    @Size(max = 150)
    @Column(name = "news_thumb_img_path")
    private String newsThumbImgPath;
    @Size(max = 250)
    @Column(name = "news_relative_link")
    private String newsRelativeLink;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_cre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCre;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "general_status_id", referencedColumnName = "general_status_id")
    @ManyToOne(optional = false)
    private GeneralStatus generalStatusId;
    @JoinColumn(name = "news_type_id", referencedColumnName = "news_type_id")
    @ManyToOne(optional = false)
    private NewsType newsTypeId;

    public News() {
    }

    public News(Integer newId) {
        this.newId = newId;
    }

    public News(Integer newId, String newsTitle, Date newsDateStart, Date newsDateExpire, Date dateCre) {
        this.newId = newId;
        this.newsTitle = newsTitle;
        this.newsDateStart = newsDateStart;
        this.newsDateExpire = newsDateExpire;
        this.dateCre = dateCre;
    }

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
    public int hashCode() {
        int hash = 0;
        hash += (newId != null ? newId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newId == null && other.newId != null) || (this.newId != null && !this.newId.equals(other.newId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.friogan.db.domain.News[ newId=" + newId + " ]";
    }
    
}
