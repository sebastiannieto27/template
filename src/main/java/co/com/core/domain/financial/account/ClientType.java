/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.financial.account;

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
@Table(name = "client_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientType.findAll", query = "SELECT c FROM ClientType c"),
    @NamedQuery(name = "ClientType.findByClientTypeId", query = "SELECT c FROM ClientType c WHERE c.clientTypeId = :clientTypeId"),
    @NamedQuery(name = "ClientType.findByClientTypeName", query = "SELECT c FROM ClientType c WHERE c.clientTypeName = :clientTypeName")})
public class ClientType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_type_id")
    private Integer clientTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "client_type_name")
    private String clientTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientTypeId")
    private Collection<Client> clientCollection;

    public ClientType() {
    }

    public ClientType(Integer clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public ClientType(Integer clientTypeId, String clientTypeName) {
        this.clientTypeId = clientTypeId;
        this.clientTypeName = clientTypeName;
    }

    public Integer getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Integer clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public String getClientTypeName() {
        return clientTypeName;
    }

    public void setClientTypeName(String clientTypeName) {
        this.clientTypeName = clientTypeName;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientTypeId != null ? clientTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientType)) {
            return false;
        }
        ClientType other = (ClientType) object;
        if ((this.clientTypeId == null && other.clientTypeId != null) || (this.clientTypeId != null && !this.clientTypeId.equals(other.clientTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ClientType[ clientTypeId=" + clientTypeId + " ]";
    }
    
}
