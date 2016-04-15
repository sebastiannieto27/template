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
@Table(name = "company_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyEvent.findAll", query = "SELECT c FROM CompanyEvent c"),
    @NamedQuery(name = "CompanyEvent.findByCompanyEventId", query = "SELECT c FROM CompanyEvent c WHERE c.companyEventId = :companyEventId"),
    @NamedQuery(name = "CompanyEvent.findByCompanyEventTitle", query = "SELECT c FROM CompanyEvent c WHERE c.companyEventTitle = :companyEventTitle"),
    @NamedQuery(name = "CompanyEvent.findByCompanyEventLocation", query = "SELECT c FROM CompanyEvent c WHERE c.companyEventLocation = :companyEventLocation"),
    @NamedQuery(name = "CompanyEvent.findByCompanyEventDesc", query = "SELECT c FROM CompanyEvent c WHERE c.companyEventDesc = :companyEventDesc"),
    @NamedQuery(name = "CompanyEvent.findByCompanyEventThumbImg", query = "SELECT c FROM CompanyEvent c WHERE c.companyEventThumbImg = :companyEventThumbImg"),
    @NamedQuery(name = "CompanyEvent.findByCompanyEventBigImg", query = "SELECT c FROM CompanyEvent c WHERE c.companyEventBigImg = :companyEventBigImg"),
    @NamedQuery(name = "CompanyEvent.findByDateCre", query = "SELECT c FROM CompanyEvent c WHERE c.dateCre = :dateCre")})
public class CompanyEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "company_event_id")
    private Integer companyEventId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "company_event_title")
    private String companyEventTitle;
    @Size(max = 150)
    @Column(name = "company_event_location")
    private String companyEventLocation;
    @Size(max = 1000)
    @Column(name = "company_event_desc")
    private String companyEventDesc;
    @Size(max = 150)
    @Column(name = "company_event_thumb_img")
    private String companyEventThumbImg;
    @Size(max = 150)
    @Column(name = "company_event_big_img")
    private String companyEventBigImg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_cre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCre;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public CompanyEvent() {
    }

    public CompanyEvent(Integer companyEventId) {
        this.companyEventId = companyEventId;
    }

    public CompanyEvent(Integer companyEventId, String companyEventTitle, Date dateCre) {
        this.companyEventId = companyEventId;
        this.companyEventTitle = companyEventTitle;
        this.dateCre = dateCre;
    }

    public Integer getCompanyEventId() {
        return companyEventId;
    }

    public void setCompanyEventId(Integer companyEventId) {
        this.companyEventId = companyEventId;
    }

    public String getCompanyEventTitle() {
        return companyEventTitle;
    }

    public void setCompanyEventTitle(String companyEventTitle) {
        this.companyEventTitle = companyEventTitle;
    }

    public String getCompanyEventLocation() {
        return companyEventLocation;
    }

    public void setCompanyEventLocation(String companyEventLocation) {
        this.companyEventLocation = companyEventLocation;
    }

    public String getCompanyEventDesc() {
        return companyEventDesc;
    }

    public void setCompanyEventDesc(String companyEventDesc) {
        this.companyEventDesc = companyEventDesc;
    }

    public String getCompanyEventThumbImg() {
        return companyEventThumbImg;
    }

    public void setCompanyEventThumbImg(String companyEventThumbImg) {
        this.companyEventThumbImg = companyEventThumbImg;
    }

    public String getCompanyEventBigImg() {
        return companyEventBigImg;
    }

    public void setCompanyEventBigImg(String companyEventBigImg) {
        this.companyEventBigImg = companyEventBigImg;
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
    public int hashCode() {
        int hash = 0;
        hash += (companyEventId != null ? companyEventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyEvent)) {
            return false;
        }
        CompanyEvent other = (CompanyEvent) object;
        if ((this.companyEventId == null && other.companyEventId != null) || (this.companyEventId != null && !this.companyEventId.equals(other.companyEventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.friogan.db.domain.CompanyEvent[ companyEventId=" + companyEventId + " ]";
    }
    
}
