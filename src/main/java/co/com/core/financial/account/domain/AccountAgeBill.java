/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.financial.account.domain;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "account_age_bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountAgeBill.findAll", query = "SELECT a FROM AccountAgeBill a"),
    @NamedQuery(name = "AccountAgeBill.findByAccountAgeBillId", query = "SELECT a FROM AccountAgeBill a WHERE a.accountAgeBillId = :accountAgeBillId")})
public class AccountAgeBill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_age_bill_id")
    private Integer accountAgeBillId;
    @JoinColumn(name = "account_age_det_id", referencedColumnName = "account_age_det_id")
    @ManyToOne(optional = false)
    private AccountAgeDet accountAgeDetId;
    @JoinColumn(name = "bill_head_id", referencedColumnName = "bill_head_id")
    @ManyToOne(optional = false)
    private BillHead billHeadId;

    public AccountAgeBill() {
    }

    public AccountAgeBill(Integer accountAgeBillId) {
        this.accountAgeBillId = accountAgeBillId;
    }

    public Integer getAccountAgeBillId() {
        return accountAgeBillId;
    }

    public void setAccountAgeBillId(Integer accountAgeBillId) {
        this.accountAgeBillId = accountAgeBillId;
    }

    public AccountAgeDet getAccountAgeDetId() {
        return accountAgeDetId;
    }

    public void setAccountAgeDetId(AccountAgeDet accountAgeDetId) {
        this.accountAgeDetId = accountAgeDetId;
    }

    public BillHead getBillHeadId() {
        return billHeadId;
    }

    public void setBillHeadId(BillHead billHeadId) {
        this.billHeadId = billHeadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountAgeBillId != null ? accountAgeBillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountAgeBill)) {
            return false;
        }
        AccountAgeBill other = (AccountAgeBill) object;
        if ((this.accountAgeBillId == null && other.accountAgeBillId != null) || (this.accountAgeBillId != null && !this.accountAgeBillId.equals(other.accountAgeBillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountAgeBill[ accountAgeBillId=" + accountAgeBillId + " ]";
    }
    
}
