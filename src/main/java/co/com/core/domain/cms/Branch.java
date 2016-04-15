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
@Table(name = "branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByBranchId", query = "SELECT b FROM Branch b WHERE b.branchId = :branchId"),
    @NamedQuery(name = "Branch.findByBranchName", query = "SELECT b FROM Branch b WHERE b.branchName = :branchName"),
    @NamedQuery(name = "Branch.findByBranchAddress", query = "SELECT b FROM Branch b WHERE b.branchAddress = :branchAddress"),
    @NamedQuery(name = "Branch.findByBranchThumbImg", query = "SELECT b FROM Branch b WHERE b.branchThumbImg = :branchThumbImg"),
    @NamedQuery(name = "Branch.findByBranchBigImg", query = "SELECT b FROM Branch b WHERE b.branchBigImg = :branchBigImg"),
    @NamedQuery(name = "Branch.findByBranchOpenHours", query = "SELECT b FROM Branch b WHERE b.branchOpenHours = :branchOpenHours"),
    @NamedQuery(name = "Branch.findByBranchMainPhone", query = "SELECT b FROM Branch b WHERE b.branchMainPhone = :branchMainPhone"),
    @NamedQuery(name = "Branch.findByBranchAltPhone", query = "SELECT b FROM Branch b WHERE b.branchAltPhone = :branchAltPhone"),
    @NamedQuery(name = "Branch.findByBranchInternalCode", query = "SELECT b FROM Branch b WHERE b.branchInternalCode = :branchInternalCode"),
    @NamedQuery(name = "Branch.findByDateCre", query = "SELECT b FROM Branch b WHERE b.dateCre = :dateCre")})
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_id")
    private Integer branchId;
    @Size(max = 150)
    @Column(name = "branch_name")
    private String branchName;
    @Size(max = 150)
    @Column(name = "branch_address")
    private String branchAddress;
    @Size(max = 150)
    @Column(name = "branch_thumb_img")
    private String branchThumbImg;
    @Size(max = 150)
    @Column(name = "branch_big_img")
    private String branchBigImg;
    @Size(max = 250)
    @Column(name = "branch_open_hours")
    private String branchOpenHours;
    @Size(max = 15)
    @Column(name = "branch_main_phone")
    private String branchMainPhone;
    @Size(max = 15)
    @Column(name = "branch_alt_phone")
    private String branchAltPhone;
    @Size(max = 30)
    @Column(name = "branch_internal_code")
    private String branchInternalCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_cre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCre;
    @JoinColumn(name = "branch_type_id", referencedColumnName = "branch_type_id")
    @ManyToOne(optional = false)
    private BranchType branchTypeId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "general_status_id", referencedColumnName = "general_status_id")
    @ManyToOne(optional = false)
    private GeneralStatus generalStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchId")
    private Collection<BranchService> branchServiceCollection;

    public Branch() {
    }

    public Branch(Integer branchId) {
        this.branchId = branchId;
    }

    public Branch(Integer branchId, Date dateCre) {
        this.branchId = branchId;
        this.dateCre = dateCre;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchThumbImg() {
        return branchThumbImg;
    }

    public void setBranchThumbImg(String branchThumbImg) {
        this.branchThumbImg = branchThumbImg;
    }

    public String getBranchBigImg() {
        return branchBigImg;
    }

    public void setBranchBigImg(String branchBigImg) {
        this.branchBigImg = branchBigImg;
    }

    public String getBranchOpenHours() {
        return branchOpenHours;
    }

    public void setBranchOpenHours(String branchOpenHours) {
        this.branchOpenHours = branchOpenHours;
    }

    public String getBranchMainPhone() {
        return branchMainPhone;
    }

    public void setBranchMainPhone(String branchMainPhone) {
        this.branchMainPhone = branchMainPhone;
    }

    public String getBranchAltPhone() {
        return branchAltPhone;
    }

    public void setBranchAltPhone(String branchAltPhone) {
        this.branchAltPhone = branchAltPhone;
    }

    public String getBranchInternalCode() {
        return branchInternalCode;
    }

    public void setBranchInternalCode(String branchInternalCode) {
        this.branchInternalCode = branchInternalCode;
    }

    public Date getDateCre() {
        return dateCre;
    }

    public void setDateCre(Date dateCre) {
        this.dateCre = dateCre;
    }

    public BranchType getBranchTypeId() {
        return branchTypeId;
    }

    public void setBranchTypeId(BranchType branchTypeId) {
        this.branchTypeId = branchTypeId;
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

    @XmlTransient
    public Collection<BranchService> getBranchServiceCollection() {
        return branchServiceCollection;
    }

    public void setBranchServiceCollection(Collection<BranchService> branchServiceCollection) {
        this.branchServiceCollection = branchServiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchId != null ? branchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchId == null && other.branchId != null) || (this.branchId != null && !this.branchId.equals(other.branchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.friogan.db.domain.Branch[ branchId=" + branchId + " ]";
    }
    
}
