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
@Table(name = "account_age_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountAgeType.findAll", query = "SELECT a FROM AccountAgeType a"),
    @NamedQuery(name = "AccountAgeType.findByAccountAgeTypeId", query = "SELECT a FROM AccountAgeType a WHERE a.accountAgeTypeId = :accountAgeTypeId"),
    @NamedQuery(name = "AccountAgeType.findByAccountAgeTypeName", query = "SELECT a FROM AccountAgeType a WHERE a.accountAgeTypeName = :accountAgeTypeName"),
    @NamedQuery(name = "AccountAgeType.findByAccountAgeTypeBegin", query = "SELECT a FROM AccountAgeType a WHERE a.accountAgeTypeBegin = :accountAgeTypeBegin"),
    @NamedQuery(name = "AccountAgeType.findByAccountAgeTypeEnd", query = "SELECT a FROM AccountAgeType a WHERE a.accountAgeTypeEnd = :accountAgeTypeEnd")})
public class AccountAgeType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_age_type_id")
    private Integer accountAgeTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "account_age_type_name")
    private String accountAgeTypeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_age_type_begin")
    private int accountAgeTypeBegin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_age_type_end")
    private int accountAgeTypeEnd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountAgeTypeId")
    private Collection<AccountAgeDet> accountAgeDetCollection;

    public AccountAgeType() {
    }

    public AccountAgeType(Integer accountAgeTypeId) {
        this.accountAgeTypeId = accountAgeTypeId;
    }

    public AccountAgeType(Integer accountAgeTypeId, String accountAgeTypeName, int accountAgeTypeBegin, int accountAgeTypeEnd) {
        this.accountAgeTypeId = accountAgeTypeId;
        this.accountAgeTypeName = accountAgeTypeName;
        this.accountAgeTypeBegin = accountAgeTypeBegin;
        this.accountAgeTypeEnd = accountAgeTypeEnd;
    }

    public Integer getAccountAgeTypeId() {
        return accountAgeTypeId;
    }

    public void setAccountAgeTypeId(Integer accountAgeTypeId) {
        this.accountAgeTypeId = accountAgeTypeId;
    }

    public String getAccountAgeTypeName() {
        return accountAgeTypeName;
    }

    public void setAccountAgeTypeName(String accountAgeTypeName) {
        this.accountAgeTypeName = accountAgeTypeName;
    }

    public int getAccountAgeTypeBegin() {
        return accountAgeTypeBegin;
    }

    public void setAccountAgeTypeBegin(int accountAgeTypeBegin) {
        this.accountAgeTypeBegin = accountAgeTypeBegin;
    }

    public int getAccountAgeTypeEnd() {
        return accountAgeTypeEnd;
    }

    public void setAccountAgeTypeEnd(int accountAgeTypeEnd) {
        this.accountAgeTypeEnd = accountAgeTypeEnd;
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
        hash += (accountAgeTypeId != null ? accountAgeTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountAgeType)) {
            return false;
        }
        AccountAgeType other = (AccountAgeType) object;
        if ((this.accountAgeTypeId == null && other.accountAgeTypeId != null) || (this.accountAgeTypeId != null && !this.accountAgeTypeId.equals(other.accountAgeTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountAgeType[ accountAgeTypeId=" + accountAgeTypeId + " ]";
    }
    
}
