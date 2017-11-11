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
 * @author root
 */
@Entity
@Table(name = "general_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralStatus.findAll", query = "SELECT g FROM GeneralStatus g"),
    @NamedQuery(name = "GeneralStatus.findByGeneralStatusId", query = "SELECT g FROM GeneralStatus g WHERE g.generalStatusId = :generalStatusId"),
    @NamedQuery(name = "GeneralStatus.findByGeneralStatusName", query = "SELECT g FROM GeneralStatus g WHERE g.generalStatusName = :generalStatusName")})
public class GeneralStatus implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "general_status_module")
    private int generalStatusModule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalStatusId")
   // private Collection<BillHead> billHeadCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "general_status_id")
    private Integer generalStatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "general_status_name")
    private String generalStatusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalStatusId")
    private Collection<News> newsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalStatusId")
    private Collection<Branch> branchCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalStatusId")
    private Collection<Service> serviceCollection;
    

    public GeneralStatus() {
    }

    public GeneralStatus(Integer generalStatusId) {
        this.generalStatusId = generalStatusId;
    }

    public GeneralStatus(Integer generalStatusId, String generalStatusName) {
        this.generalStatusId = generalStatusId;
        this.generalStatusName = generalStatusName;
    }

    public Integer getGeneralStatusId() {
        return generalStatusId;
    }

    public void setGeneralStatusId(Integer generalStatusId) {
        this.generalStatusId = generalStatusId;
    }

    public String getGeneralStatusName() {
        return generalStatusName;
    }

    public void setGeneralStatusName(String generalStatusName) {
        this.generalStatusName = generalStatusName;
    }

    @XmlTransient
    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
    }

    @XmlTransient
    public Collection<Branch> getBranchCollection() {
        return branchCollection;
    }

    public void setBranchCollection(Collection<Branch> branchCollection) {
        this.branchCollection = branchCollection;
    }

    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalStatusId != null ? generalStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralStatus)) {
            return false;
        }
        GeneralStatus other = (GeneralStatus) object;
        if ((this.generalStatusId == null && other.generalStatusId != null) || (this.generalStatusId != null && !this.generalStatusId.equals(other.generalStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GeneralStatus[ generalStatusId=" + generalStatusId + " ]";
    }

    public int getGeneralStatusModule() {
        return generalStatusModule;
    }

    public void setGeneralStatusModule(int generalStatusModule) {
        this.generalStatusModule = generalStatusModule;
    }

    /*@XmlTransient
    public Collection<BillHead> getBillHeadCollection() {
        return billHeadCollection;
    }

    public void setBillHeadCollection(Collection<BillHead> billHeadCollection) {
        this.billHeadCollection = billHeadCollection;
    }*/
    
}
