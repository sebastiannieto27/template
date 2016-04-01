/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.cms;

import java.io.Serializable;

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
import javax.xml.bind.annotation.XmlRootElement;

import co.com.core.domain.UploadedFile;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "brand_upload_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrandUploadFile.findAll", query = "SELECT b FROM BrandUploadFile b"),
    @NamedQuery(name = "BrandUploadFile.findByBrandUploadFileId", query = "SELECT b FROM BrandUploadFile b WHERE b.brandUploadFileId = :brandUploadFileId")})
public class BrandUploadFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "brand_upload_file_id")
    private Integer brandUploadFileId;
    @JoinColumn(name = "uploaded_file_id", referencedColumnName = "uploaded_file_id")
    @ManyToOne(optional = false)
    private UploadedFile uploadedFileId;
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    @ManyToOne(optional = false)
    private Brand brandId;

    public BrandUploadFile() {
    }

    public BrandUploadFile(Integer brandUploadFileId) {
        this.brandUploadFileId = brandUploadFileId;
    }

    public Integer getBrandUploadFileId() {
        return brandUploadFileId;
    }

    public void setBrandUploadFileId(Integer brandUploadFileId) {
        this.brandUploadFileId = brandUploadFileId;
    }

    public UploadedFile getUploadedFileId() {
        return uploadedFileId;
    }

    public void setUploadedFileId(UploadedFile uploadedFileId) {
        this.uploadedFileId = uploadedFileId;
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
        hash += (brandUploadFileId != null ? brandUploadFileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrandUploadFile)) {
            return false;
        }
        BrandUploadFile other = (BrandUploadFile) object;
        if ((this.brandUploadFileId == null && other.brandUploadFileId != null) || (this.brandUploadFileId != null && !this.brandUploadFileId.equals(other.brandUploadFileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.cms.BrandUploadFile[ brandUploadFileId=" + brandUploadFileId + " ]";
    }
    
}
