/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page p"),
    @NamedQuery(name = "Page.findByPageId", query = "SELECT p FROM Page p WHERE p.pageId = :pageId"),
    @NamedQuery(name = "Page.findByPageName", query = "SELECT p FROM Page p WHERE p.pageName = :pageName"),
    @NamedQuery(name = "Page.findByRealUrl", query = "SELECT p FROM Page p WHERE p.realUrl = :realUrl"),
    @NamedQuery(name = "Page.findByUrl", query = "SELECT p FROM Page p WHERE p.url = :url")})
public class Page implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "page_id")
    private Integer pageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "page_name")
    private String pageName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "real_url")
    private String realUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pageId")
    private Collection<PagePermission> pagePermissionCollection;
    @OneToMany(mappedBy = "pageId")
    private Collection<Menu> menuCollection;

    public Page() {
    }

    public Page(Integer pageId) {
        this.pageId = pageId;
    }

    public Page(Integer pageId, String pageName, String url, String realUrl) {
        this.pageId = pageId;
        this.pageName = pageName;
        this.url = url;
        this.realUrl = realUrl;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public String getUrl() {
    	return url;
    }
    
    public void setUrl(String url) {
    	this.url = url;
    }

    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl;
    }

    @XmlTransient
    public Collection<PagePermission> getPagePermissionCollection() {
        return pagePermissionCollection;
    }

    public void setPagePermissionCollection(Collection<PagePermission> pagePermissionCollection) {
        this.pagePermissionCollection = pagePermissionCollection;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pageId != null ? pageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Page)) {
            return false;
        }
        Page other = (Page) object;
        if ((this.pageId == null && other.pageId != null) || (this.pageId != null && !this.pageId.equals(other.pageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.Page[ pageId=" + pageId + " ]";
    }
    
}

