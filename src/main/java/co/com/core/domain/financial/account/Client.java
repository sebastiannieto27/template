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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientId", query = "SELECT c FROM Client c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Client.findByClientIntCode", query = "SELECT c FROM Client c WHERE c.clientIntCode = :clientIntCode"),
    @NamedQuery(name = "Client.findByClientNumId", query = "SELECT c FROM Client c WHERE c.clientNumId = :clientNumId"),
    @NamedQuery(name = "Client.findByClientName", query = "SELECT c FROM Client c WHERE c.clientName = :clientName"),
    @NamedQuery(name = "Client.findByClientAddress", query = "SELECT c FROM Client c WHERE c.clientAddress = :clientAddress"),
    @NamedQuery(name = "Client.findByClientDv", query = "SELECT c FROM Client c WHERE c.clientDv = :clientDv"),
    @NamedQuery(name = "Client.findByClientMail", query = "SELECT c FROM Client c WHERE c.clientMail = :clientMail")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_id")
    private Integer clientId;
    @Size(max = 30)
    @Column(name = "client_int_code")
    private String clientIntCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "client_num_id")
    private String clientNumId;
    @Size(max = 150)
    @Column(name = "client_name")
    private String clientName;
    @Size(max = 150)
    @Column(name = "client_address")
    private String clientAddress;
    @Column(name = "client_dv")
    private Integer clientDv;
    @Size(max = 200)
    @Column(name = "client_mail")
    private String clientMail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<AccountAge> accountAgeCollection;
    @JoinColumn(name = "client_type_id", referencedColumnName = "client_type_id")
    @ManyToOne(optional = false)
    private ClientType clientTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<BranchClient> branchClientCollection;

    public Client() {
    }

    public Client(Integer clientId) {
        this.clientId = clientId;
    }

    public Client(Integer clientId, String clientNumId) {
        this.clientId = clientId;
        this.clientNumId = clientNumId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientIntCode() {
        return clientIntCode;
    }

    public void setClientIntCode(String clientIntCode) {
        this.clientIntCode = clientIntCode;
    }

    public String getClientNumId() {
        return clientNumId;
    }

    public void setClientNumId(String clientNumId) {
        this.clientNumId = clientNumId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Integer getClientDv() {
        return clientDv;
    }

    public void setClientDv(Integer clientDv) {
        this.clientDv = clientDv;
    }

    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    @XmlTransient
    public Collection<AccountAge> getAccountAgeCollection() {
        return accountAgeCollection;
    }

    public void setAccountAgeCollection(Collection<AccountAge> accountAgeCollection) {
        this.accountAgeCollection = accountAgeCollection;
    }

    public ClientType getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(ClientType clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    @XmlTransient
    public Collection<BranchClient> getBranchClientCollection() {
        return branchClientCollection;
    }

    public void setBranchClientCollection(Collection<BranchClient> branchClientCollection) {
        this.branchClientCollection = branchClientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Client[ clientId=" + clientId + " ]";
    }
    
}
