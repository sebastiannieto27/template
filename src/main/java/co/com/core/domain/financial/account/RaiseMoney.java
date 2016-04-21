/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.financial.account;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "raise_money")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RaiseMoney.findAll", query = "SELECT r FROM RaiseMoney r"),
    @NamedQuery(name = "RaiseMoney.findByRaiseMoneyId", query = "SELECT r FROM RaiseMoney r WHERE r.raiseMoneyId = :raiseMoneyId"),
    @NamedQuery(name = "RaiseMoney.findByRaiseMoneyAmount", query = "SELECT r FROM RaiseMoney r WHERE r.raiseMoneyAmount = :raiseMoneyAmount"),
    @NamedQuery(name = "RaiseMoney.findByRaiseMoneyNum", query = "SELECT r FROM RaiseMoney r WHERE r.raiseMoneyNum = :raiseMoneyNum"),
    @NamedQuery(name = "RaiseMoney.findByRaiseMoneyDate", query = "SELECT r FROM RaiseMoney r WHERE r.raiseMoneyDate = :raiseMoneyDate")})
public class RaiseMoney implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "raise_money_id")
    private Integer raiseMoneyId;
    @Column(name = "raise_money_amount")
    private Long raiseMoneyAmount;
    @Size(max = 45)
    @Column(name = "raise_money_num")
    private String raiseMoneyNum;
    @Column(name = "raise_money_date")
    @Temporal(TemporalType.DATE)
    private Date raiseMoneyDate;
    @JoinColumn(name = "branch_client_id", referencedColumnName = "branch_client_id")
    @ManyToOne(optional = false)
    private BranchClient branchClientId;
    @JoinColumn(name = "raise_money_type_id", referencedColumnName = "raise_money_type_id")
    @ManyToOne
    private RaiseMoneyType raiseMoneyTypeId;

    public RaiseMoney() {
    }

    public RaiseMoney(Integer raiseMoneyId) {
        this.raiseMoneyId = raiseMoneyId;
    }

    public Integer getRaiseMoneyId() {
        return raiseMoneyId;
    }

    public void setRaiseMoneyId(Integer raiseMoneyId) {
        this.raiseMoneyId = raiseMoneyId;
    }

    public Long getRaiseMoneyAmount() {
        return raiseMoneyAmount;
    }

    public void setRaiseMoneyAmount(Long raiseMoneyAmount) {
        this.raiseMoneyAmount = raiseMoneyAmount;
    }

    public String getRaiseMoneyNum() {
        return raiseMoneyNum;
    }

    public void setRaiseMoneyNum(String raiseMoneyNum) {
        this.raiseMoneyNum = raiseMoneyNum;
    }

    public Date getRaiseMoneyDate() {
        return raiseMoneyDate;
    }

    public void setRaiseMoneyDate(Date raiseMoneyDate) {
        this.raiseMoneyDate = raiseMoneyDate;
    }

    public BranchClient getBranchClientId() {
        return branchClientId;
    }

    public void setBranchClientId(BranchClient branchClientId) {
        this.branchClientId = branchClientId;
    }

    public RaiseMoneyType getRaiseMoneyTypeId() {
        return raiseMoneyTypeId;
    }

    public void setRaiseMoneyTypeId(RaiseMoneyType raiseMoneyTypeId) {
        this.raiseMoneyTypeId = raiseMoneyTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (raiseMoneyId != null ? raiseMoneyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RaiseMoney)) {
            return false;
        }
        RaiseMoney other = (RaiseMoney) object;
        if ((this.raiseMoneyId == null && other.raiseMoneyId != null) || (this.raiseMoneyId != null && !this.raiseMoneyId.equals(other.raiseMoneyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RaiseMoney[ raiseMoneyId=" + raiseMoneyId + " ]";
    }
    
}
