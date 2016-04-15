/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.financial.account.domain;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "account_age")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountAge.findAll", query = "SELECT a FROM AccountAge a"),
    @NamedQuery(name = "AccountAge.findByAccountAgeId", query = "SELECT a FROM AccountAge a WHERE a.accountAgeId = :accountAgeId")})
public class AccountAge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_age_id")
    private Integer accountAgeId;
    @JoinColumn(name = "branch_client_id", referencedColumnName = "branch_client_id")
    @ManyToOne(optional = false)
    private BranchClient branchClientId;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false)
    private Client clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountAgeId")
    private Collection<AccountAgeDet> accountAgeDetCollection;

    public AccountAge() {
    }

    public AccountAge(Integer accountAgeId) {
        this.accountAgeId = accountAgeId;
    }

    public Integer getAccountAgeId() {
        return accountAgeId;
    }

    public void setAccountAgeId(Integer accountAgeId) {
        this.accountAgeId = accountAgeId;
    }

    public BranchClient getBranchClientId() {
        return branchClientId;
    }

    public void setBranchClientId(BranchClient branchClientId) {
        this.branchClientId = branchClientId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    @XmlTransient
    public Collection<AccountAgeDet> getAccountAgeDetCollection() {
        return accountAgeDetCollection;
    }

    public void setAccountAgeDetCollection(Collection<AccountAgeDet> accountAgeDetCollection) {
        this.accountAgeDetCollection = accountAgeDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountAgeId != null ? accountAgeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountAge)) {
            return false;
        }
        AccountAge other = (AccountAge) object;
        if ((this.accountAgeId == null && other.accountAgeId != null) || (this.accountAgeId != null && !this.accountAgeId.equals(other.accountAgeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountAge[ accountAgeId=" + accountAgeId + " ]";
    }
    
}
