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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "brand_service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrandService.findAll", query = "SELECT b FROM BrandService b"),
    @NamedQuery(name = "BrandService.findByBrandServiceId", query = "SELECT b FROM BrandService b WHERE b.brandServiceId = :brandServiceId"),
    @NamedQuery(name = "BrandService.findByUserId", query = "SELECT b FROM BrandService b WHERE b.userId = :userId"),
    @NamedQuery(name = "BrandService.findByDateCre", query = "SELECT b FROM BrandService b WHERE b.dateCre = :dateCre")})
public class BrandService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "brand_service_id")
    private Integer brandServiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_cre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCre;
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @ManyToOne(optional = false)
    private Service serviceId;
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    @ManyToOne(optional = false)
    private Brand brandId;

    public BrandService() {
    }

    public BrandService(Integer brandServiceId) {
        this.brandServiceId = brandServiceId;
    }

    public BrandService(Integer brandServiceId, int userId, Date dateCre) {
        this.brandServiceId = brandServiceId;
        this.userId = userId;
        this.dateCre = dateCre;
    }

    public Integer getBrandServiceId() {
        return brandServiceId;
    }

    public void setBrandServiceId(Integer brandServiceId) {
        this.brandServiceId = brandServiceId;
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

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandServiceId != null ? brandServiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrandService)) {
            return false;
        }
        BrandService other = (BrandService) object;
        if ((this.brandServiceId == null && other.brandServiceId != null) || (this.brandServiceId != null && !this.brandServiceId.equals(other.brandServiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.BrandService[ brandServiceId=" + brandServiceId + " ]";
    }
    
}
