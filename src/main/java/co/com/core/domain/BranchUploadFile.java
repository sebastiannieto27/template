/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain;

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

/**
 *
 * @author root
 */
@Entity
@Table(name = "branch_upload_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchUploadFile.findAll", query = "SELECT b FROM BranchUploadFile b"),
    @NamedQuery(name = "BranchUploadFile.findByBranchUploadFileId", query = "SELECT b FROM BranchUploadFile b WHERE b.branchUploadFileId = :branchUploadFileId")})
public class BranchUploadFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_upload_file_id")
    private Integer branchUploadFileId;
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id")
    @ManyToOne(optional = false)
    private Branch branchId;
    @JoinColumn(name = "uploaded_file_id", referencedColumnName = "uploaded_file_id")
    @ManyToOne(optional = false)
    private UploadedFile uploadedFileId;

    public BranchUploadFile() {
    }

    public BranchUploadFile(Integer branchUploadFileId) {
        this.branchUploadFileId = branchUploadFileId;
    }

    public Integer getBranchUploadFileId() {
        return branchUploadFileId;
    }

    public void setBranchUploadFileId(Integer branchUploadFileId) {
        this.branchUploadFileId = branchUploadFileId;
    }

    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }

    public UploadedFile getUploadedFileId() {
        return uploadedFileId;
    }

    public void setUploadedFileId(UploadedFile uploadedFileId) {
        this.uploadedFileId = uploadedFileId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchUploadFileId != null ? branchUploadFileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchUploadFile)) {
            return false;
        }
        BranchUploadFile other = (BranchUploadFile) object;
        if ((this.branchUploadFileId == null && other.branchUploadFileId != null) || (this.branchUploadFileId != null && !this.branchUploadFileId.equals(other.branchUploadFileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BranchUploadFile[ branchUploadFileId=" + branchUploadFileId + " ]";
    }
    
}
