/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain;

import java.io.Serializable;
import java.sql.Timestamp;
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

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "uploaded_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UploadedFile.findAll", query = "SELECT u FROM UploadedFile u"),
    @NamedQuery(name = "UploadedFile.findByUploadedFileId", query = "SELECT u FROM UploadedFile u WHERE u.uploadedFileId = :uploadedFileId"),
    @NamedQuery(name = "UploadedFile.findByName", query = "SELECT u FROM UploadedFile u WHERE u.name = :name"),
    @NamedQuery(name = "UploadedFile.findBySize", query = "SELECT u FROM UploadedFile u WHERE u.size = :size"),
    @NamedQuery(name = "UploadedFile.findByCreationDate", query = "SELECT u FROM UploadedFile u WHERE u.creationDate = :creationDate")})
public class UploadedFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uploaded_file_id")
    private Integer uploadedFileId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "size")
    private int size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    private Timestamp creationDate;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public UploadedFile() {
    }

    public UploadedFile(Integer uploadedFileId) {
        this.uploadedFileId = uploadedFileId;
    }

    public UploadedFile(Integer uploadedFileId, String name, int size, Timestamp creationDate) {
        this.uploadedFileId = uploadedFileId;
        this.name = name;
        this.size = size;
        this.creationDate = creationDate;
    }

    public Integer getUploadedFileId() {
        return uploadedFileId;
    }

    public void setUploadedFileId(Integer uploadedFileId) {
        this.uploadedFileId = uploadedFileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
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
        hash += (uploadedFileId != null ? uploadedFileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UploadedFile)) {
            return false;
        }
        UploadedFile other = (UploadedFile) object;
        if ((this.uploadedFileId == null && other.uploadedFileId != null) || (this.uploadedFileId != null && !this.uploadedFileId.equals(other.uploadedFileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.UploadedFile[ uploadedFileId=" + uploadedFileId + " ]";
    }
    
}
