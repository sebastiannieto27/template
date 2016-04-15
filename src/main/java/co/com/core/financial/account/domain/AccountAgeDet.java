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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "account_age_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountAgeDet.findAll", query = "SELECT a FROM AccountAgeDet a"),
    @NamedQuery(name = "AccountAgeDet.findByAccountAgeDetId", query = "SELECT a FROM AccountAgeDet a WHERE a.accountAgeDetId = :accountAgeDetId"),
    @NamedQuery(name = "AccountAgeDet.findByAccountAgeDetTotal", query = "SELECT a FROM AccountAgeDet a WHERE a.accountAgeDetTotal = :accountAgeDetTotal"),
    @NamedQuery(name = "AccountAgeDet.findByAccountAgeDetAmo", query = "SELECT a FROM AccountAgeDet a WHERE a.accountAgeDetAmo = :accountAgeDetAmo")})
public class AccountAgeDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_age_det_id")
    private Integer accountAgeDetId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_age_det_total")
    private long accountAgeDetTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_age_det_amo")
    private int accountAgeDetAmo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountAgeDetId")
    private Collection<AccountAgeBill> accountAgeBillCollection;
    @JoinColumn(name = "account_age_id", referencedColumnName = "account_age_id")
    @ManyToOne(optional = false)
    private AccountAge accountAgeId;
    @JoinColumn(name = "account_age_type_id", referencedColumnName = "account_age_type_id")
    @ManyToOne(optional = false)
    private AccountAgeType accountAgeTypeId;

    public AccountAgeDet() {
    }

    public AccountAgeDet(Integer accountAgeDetId) {
        this.accountAgeDetId = accountAgeDetId;
    }

    public AccountAgeDet(Integer accountAgeDetId, long accountAgeDetTotal, int accountAgeDetAmo) {
        this.accountAgeDetId = accountAgeDetId;
        this.accountAgeDetTotal = accountAgeDetTotal;
        this.accountAgeDetAmo = accountAgeDetAmo;
    }

    public Integer getAccountAgeDetId() {
        return accountAgeDetId;
    }

    public void setAccountAgeDetId(Integer accountAgeDetId) {
        this.accountAgeDetId = accountAgeDetId;
    }

    public long getAccountAgeDetTotal() {
        return accountAgeDetTotal;
    }

    public void setAccountAgeDetTotal(long accountAgeDetTotal) {
        this.accountAgeDetTotal = accountAgeDetTotal;
    }

    public int getAccountAgeDetAmo() {
        return accountAgeDetAmo;
    }

    public void setAccountAgeDetAmo(int accountAgeDetAmo) {
        this.accountAgeDetAmo = accountAgeDetAmo;
    }

    @XmlTransient
    public Collection<AccountAgeBill> getAccountAgeBillCollection() {
        return accountAgeBillCollection;
    }

    public void setAccountAgeBillCollection(Collection<AccountAgeBill> accountAgeBillCollection) {
        this.accountAgeBillCollection = accountAgeBillCollection;
    }

    public AccountAge getAccountAgeId() {
        return accountAgeId;
    }

    public void setAccountAgeId(AccountAge accountAgeId) {
        this.accountAgeId = accountAgeId;
    }

    public AccountAgeType getAccountAgeTypeId() {
        return accountAgeTypeId;
    }

    public void setAccountAgeTypeId(AccountAgeType accountAgeTypeId) {
        this.accountAgeTypeId = accountAgeTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountAgeDetId != null ? accountAgeDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountAgeDet)) {
            return false;
        }
        AccountAgeDet other = (AccountAgeDet) object;
        if ((this.accountAgeDetId == null && other.accountAgeDetId != null) || (this.accountAgeDetId != null && !this.accountAgeDetId.equals(other.accountAgeDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountAgeDet[ accountAgeDetId=" + accountAgeDetId + " ]";
    }
    
}
