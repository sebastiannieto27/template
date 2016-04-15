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
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByServiceId", query = "SELECT s FROM Service s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "Service.findByServiceName", query = "SELECT s FROM Service s WHERE s.serviceName = :serviceName"),
    @NamedQuery(name = "Service.findByServiceDesc", query = "SELECT s FROM Service s WHERE s.serviceDesc = :serviceDesc"),
    @NamedQuery(name = "Service.findByServiceImgPath", query = "SELECT s FROM Service s WHERE s.serviceImgPath = :serviceImgPath"),
    @NamedQuery(name = "Service.findByServiceThumbImgPath", query = "SELECT s FROM Service s WHERE s.serviceThumbImgPath = :serviceThumbImgPath"),
    @NamedQuery(name = "Service.findByDateCre", query = "SELECT s FROM Service s WHERE s.dateCre = :dateCre")})
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_id")
    private Integer serviceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "service_name")
    private String serviceName;
    @Size(max = 250)
    @Column(name = "service_desc")
    private String serviceDesc;
    @Size(max = 150)
    @Column(name = "service_img_path")
    private String serviceImgPath;
    @Size(max = 150)
    @Column(name = "service_thumb_img_path")
    private String serviceThumbImgPath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_cre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCre;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "general_status_id", referencedColumnName = "general_status_id")
    @ManyToOne(optional = false)
    private GeneralStatus generalStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceId")
    private Collection<BranchService> branchServiceCollection;

    public Service() {
    }

    public Service(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Service(Integer serviceId, String serviceName, Date dateCre) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.dateCre = dateCre;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getServiceImgPath() {
        return serviceImgPath;
    }

    public void setServiceImgPath(String serviceImgPath) {
        this.serviceImgPath = serviceImgPath;
    }

    public String getServiceThumbImgPath() {
        return serviceThumbImgPath;
    }

    public void setServiceThumbImgPath(String serviceThumbImgPath) {
        this.serviceThumbImgPath = serviceThumbImgPath;
    }

    public Date getDateCre() {
        return dateCre;
    }

    public void setDateCre(Date dateCre) {
        this.dateCre = dateCre;
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
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.friogan.db.domain.Service[ serviceId=" + serviceId + " ]";
    }
    
}
