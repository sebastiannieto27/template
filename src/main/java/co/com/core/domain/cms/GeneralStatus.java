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
@Table(name = "general_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralStatus.findAll", query = "SELECT g FROM GeneralStatus g"),
    @NamedQuery(name = "GeneralStatus.findByGeneralStatus", query = "SELECT g FROM GeneralStatus g WHERE g.generalStatus = :generalStatus"),
    @NamedQuery(name = "GeneralStatus.findByGeneralStatusName", query = "SELECT g FROM GeneralStatus g WHERE g.generalStatusName = :generalStatusName")})
public class GeneralStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "general_status")
    private Integer generalStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "general_status_name")
    private String generalStatusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalStatusId")
    private Collection<Service> serviceCollection;

    public GeneralStatus() {
    }

    public GeneralStatus(Integer generalStatus) {
        this.generalStatus = generalStatus;
    }

    public GeneralStatus(Integer generalStatus, String generalStatusName) {
        this.generalStatus = generalStatus;
        this.generalStatusName = generalStatusName;
    }

    public Integer getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(Integer generalStatus) {
        this.generalStatus = generalStatus;
    }

    public String getGeneralStatusName() {
        return generalStatusName;
    }

    public void setGeneralStatusName(String generalStatusName) {
        this.generalStatusName = generalStatusName;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalStatus != null ? generalStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralStatus)) {
            return false;
        }
        GeneralStatus other = (GeneralStatus) object;
        if ((this.generalStatus == null && other.generalStatus != null) || (this.generalStatus != null && !this.generalStatus.equals(other.generalStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.cms.GeneralStatus[ generalStatus=" + generalStatus + " ]";
    }
    
}
