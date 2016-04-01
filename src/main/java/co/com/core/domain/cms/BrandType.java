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

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "brand_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrandType.findAll", query = "SELECT b FROM BrandType b"),
    @NamedQuery(name = "BrandType.findByBrandTypeId", query = "SELECT b FROM BrandType b WHERE b.brandTypeId = :brandTypeId"),
    @NamedQuery(name = "BrandType.findByBrandTypeName", query = "SELECT b FROM BrandType b WHERE b.brandTypeName = :brandTypeName"),
    @NamedQuery(name = "BrandType.findByUserId", query = "SELECT b FROM BrandType b WHERE b.userId = :userId"),
    @NamedQuery(name = "BrandType.findByDateCre", query = "SELECT b FROM BrandType b WHERE b.dateCre = :dateCre")})
public class BrandType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "brand_type_id")
    private Integer brandTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "brand_type_name")
    private String brandTypeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_cre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandTypeId")
    private Collection<Brand> brandCollection;

    public BrandType() {
    }

    public BrandType(Integer brandTypeId) {
        this.brandTypeId = brandTypeId;
    }

    public BrandType(Integer brandTypeId, String brandTypeName, int userId, Date dateCre) {
        this.brandTypeId = brandTypeId;
        this.brandTypeName = brandTypeName;
        this.userId = userId;
        this.dateCre = dateCre;
    }

    public Integer getBrandTypeId() {
        return brandTypeId;
    }

    public void setBrandTypeId(Integer brandTypeId) {
        this.brandTypeId = brandTypeId;
    }

    public String getBrandTypeName() {
        return brandTypeName;
    }

    public void setBrandTypeName(String brandTypeName) {
        this.brandTypeName = brandTypeName;
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

    @XmlTransient
    public Collection<Brand> getBrandCollection() {
        return brandCollection;
    }

    public void setBrandCollection(Collection<Brand> brandCollection) {
        this.brandCollection = brandCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandTypeId != null ? brandTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrandType)) {
            return false;
        }
        BrandType other = (BrandType) object;
        if ((this.brandTypeId == null && other.brandTypeId != null) || (this.brandTypeId != null && !this.brandTypeId.equals(other.brandTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.cms.BrandType[ brandTypeId=" + brandTypeId + " ]";
    }
    
}
