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

import co.com.core.domain.User;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "branch_service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchService.findAll", query = "SELECT b FROM BranchService b"),
    @NamedQuery(name = "BranchService.findByBranchServiceId", query = "SELECT b FROM BranchService b WHERE b.branchServiceId = :branchServiceId"),
    @NamedQuery(name = "BranchService.findByDateCre", query = "SELECT b FROM BranchService b WHERE b.dateCre = :dateCre")})
public class BranchService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_service_id")
    private Integer branchServiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_cre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCre;
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @ManyToOne(optional = false)
    private Service serviceId;
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id")
    @ManyToOne(optional = false)
    private Branch branchId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public BranchService() {
    }

    public BranchService(Integer branchServiceId) {
        this.branchServiceId = branchServiceId;
    }

    public BranchService(Integer branchServiceId, Date dateCre) {
        this.branchServiceId = branchServiceId;
        this.dateCre = dateCre;
    }

    public Integer getBranchServiceId() {
        return branchServiceId;
    }

    public void setBranchServiceId(Integer branchServiceId) {
        this.branchServiceId = branchServiceId;
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

    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
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
        hash += (branchServiceId != null ? branchServiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchService)) {
            return false;
        }
        BranchService other = (BranchService) object;
        if ((this.branchServiceId == null && other.branchServiceId != null) || (this.branchServiceId != null && !this.branchServiceId.equals(other.branchServiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.friogan.db.domain.BranchService[ branchServiceId=" + branchServiceId + " ]";
    }
    
}
