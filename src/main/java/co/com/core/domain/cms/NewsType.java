/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.cms;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import co.com.core.domain.User;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "news_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsType.findAll", query = "SELECT n FROM NewsType n"),
    @NamedQuery(name = "NewsType.findByNewsTypeId", query = "SELECT n FROM NewsType n WHERE n.newsTypeId = :newsTypeId"),
    @NamedQuery(name = "NewsType.findByNewsTypeName", query = "SELECT n FROM NewsType n WHERE n.newsTypeName = :newsTypeName")})
public class NewsType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "news_type_id")
    private Integer newsTypeId;
    @Size(max = 150)
    @Column(name = "news_type_name")
    private String newsTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsTypeId")
    private Collection<News> newsCollection;

    public NewsType() {
    }

    public NewsType(Integer newsTypeId) {
        this.newsTypeId = newsTypeId;
    }

    public NewsType(Integer newsTypeId, Date dateCre) {
        this.newsTypeId = newsTypeId;
    }

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

    @XmlTransient
    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsTypeId != null ? newsTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsType)) {
            return false;
        }
        NewsType other = (NewsType) object;
        if ((this.newsTypeId == null && other.newsTypeId != null) || (this.newsTypeId != null && !this.newsTypeId.equals(other.newsTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.friogan.db.domain.NewsType[ newsTypeId=" + newsTypeId + " ]";
    }
    
}
