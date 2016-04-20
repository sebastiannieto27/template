/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.cms;

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
@Table(name = "branch_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchType.findAll", query = "SELECT b FROM BranchType b"),
    @NamedQuery(name = "BranchType.findByBranchTypeId", query = "SELECT b FROM BranchType b WHERE b.branchTypeId = :branchTypeId"),
    @NamedQuery(name = "BranchType.findByBranchTypeName", query = "SELECT b FROM BranchType b WHERE b.branchTypeName = :branchTypeName")})
public class BranchType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_type_id")
    private Integer branchTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "branch_type_name")
    private String branchTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchTypeId")
    private Collection<Branch> branchCollection;

    public BranchType() {
    }

    public BranchType(Integer branchTypeId) {
        this.branchTypeId = branchTypeId;
    }

    public BranchType(Integer branchTypeId, String branchTypeName) {
        this.branchTypeId = branchTypeId;
        this.branchTypeName = branchTypeName;
    }

    public Integer getBranchTypeId() {
        return branchTypeId;
    }

    public void setBranchTypeId(Integer branchTypeId) {
        this.branchTypeId = branchTypeId;
    }

    public String getBranchTypeName() {
        return branchTypeName;
    }

    public void setBranchTypeName(String branchTypeName) {
        this.branchTypeName = branchTypeName;
    }

    @XmlTransient
    public Collection<Branch> getBranchCollection() {
        return branchCollection;
    }

    public void setBranchCollection(Collection<Branch> branchCollection) {
        this.branchCollection = branchCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchTypeId != null ? branchTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchType)) {
            return false;
        }
        BranchType other = (BranchType) object;
        if ((this.branchTypeId == null && other.branchTypeId != null) || (this.branchTypeId != null && !this.branchTypeId.equals(other.branchTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.friogan.db.domain.BranchType[ branchTypeId=" + branchTypeId + " ]";
    }
    
}
