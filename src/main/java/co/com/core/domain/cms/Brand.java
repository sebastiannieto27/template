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
@Table(name = "brand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
    @NamedQuery(name = "Brand.findByBrandId", query = "SELECT b FROM Brand b WHERE b.brandId = :brandId"),
    @NamedQuery(name = "Brand.findByBrandName", query = "SELECT b FROM Brand b WHERE b.brandName = :brandName"),
    @NamedQuery(name = "Brand.findByBrandAddress", query = "SELECT b FROM Brand b WHERE b.brandAddress = :brandAddress"),
    @NamedQuery(name = "Brand.findByBrandThumbImg", query = "SELECT b FROM Brand b WHERE b.brandThumbImg = :brandThumbImg"),
    @NamedQuery(name = "Brand.findByBrandBigImg", query = "SELECT b FROM Brand b WHERE b.brandBigImg = :brandBigImg"),
    @NamedQuery(name = "Brand.findByBrandOpenHours", query = "SELECT b FROM Brand b WHERE b.brandOpenHours = :brandOpenHours"),
    @NamedQuery(name = "Brand.findByDateCre", query = "SELECT b FROM Brand b WHERE b.dateCre = :dateCre"),
    @NamedQuery(name = "Brand.findByFilter", query = "SELECT b FROM Brand b WHERE b.brandName = :brandName AND b.brandAddress = :brandAddress"),
    })
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "brand_id")
    private Integer brandId;
    @Size(max = 150)
    @Column(name = "brand_name")
    private String brandName;
    @Size(max = 150)
    @Column(name = "brand_address")
    private String brandAddress;
    @Size(max = 150)
    @Column(name = "brand_thumb_img")
    private String brandThumbImg;
    @Size(max = 150)
    @Column(name = "brand_big_img")
    private String brandBigImg;
    @Size(max = 250)
    @Column(name = "brand_open_hours")
    private String brandOpenHours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_cre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandId")
    private Collection<BrandUploadFile> brandUploadFileCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "brand_type_id", referencedColumnName = "brand_type_id")
    @ManyToOne(optional = false)
    private BrandType brandTypeId;

    public Brand() {
    }

    public Brand(Integer brandId) {
        this.brandId = brandId;
    }

    public Brand(Integer brandId, Date dateCre) {
        this.brandId = brandId;
        this.dateCre = dateCre;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandAddress() {
        return brandAddress;
    }

    public void setBrandAddress(String brandAddress) {
        this.brandAddress = brandAddress;
    }

    public String getBrandThumbImg() {
        return brandThumbImg;
    }

    public void setBrandThumbImg(String brandThumbImg) {
        this.brandThumbImg = brandThumbImg;
    }

    public String getBrandBigImg() {
        return brandBigImg;
    }

    public void setBrandBigImg(String brandBigImg) {
        this.brandBigImg = brandBigImg;
    }

    public String getBrandOpenHours() {
        return brandOpenHours;
    }

    public void setBrandOpenHours(String brandOpenHours) {
        this.brandOpenHours = brandOpenHours;
    }

    public Date getDateCre() {
        return dateCre;
    }

    public void setDateCre(Date dateCre) {
        this.dateCre = dateCre;
    }

    @XmlTransient
    public Collection<BrandUploadFile> getBrandUploadFileCollection() {
        return brandUploadFileCollection;
    }

    public void setBrandUploadFileCollection(Collection<BrandUploadFile> brandUploadFileCollection) {
        this.brandUploadFileCollection = brandUploadFileCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public BrandType getBrandTypeId() {
        return brandTypeId;
    }

    public void setBrandTypeId(BrandType brandTypeId) {
        this.brandTypeId = brandTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandId != null ? brandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        if ((this.brandId == null && other.brandId != null) || (this.brandId != null && !this.brandId.equals(other.brandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.cms.Brand[ brandId=" + brandId + " ]";
    }
    
}
