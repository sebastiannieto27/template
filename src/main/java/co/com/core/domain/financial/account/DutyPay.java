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
@Table(name = "duty_pay")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DutyPay.findAll", query = "SELECT d FROM DutyPay d"),
    @NamedQuery(name = "DutyPay.findByDutyApyId", query = "SELECT d FROM DutyPay d WHERE d.dutyApyId = :dutyApyId"),
    @NamedQuery(name = "DutyPay.findByDutyPayValue", query = "SELECT d FROM DutyPay d WHERE d.dutyPayValue = :dutyPayValue"),
    @NamedQuery(name = "DutyPay.findByDutyPayNum", query = "SELECT d FROM DutyPay d WHERE d.dutyPayNum = :dutyPayNum"),
    @NamedQuery(name = "DutyPay.findByDutyPayDate", query = "SELECT d FROM DutyPay d WHERE d.dutyPayDate = :dutyPayDate")})
public class DutyPay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "duty_apy_id")
    private Integer dutyApyId;
    @Column(name = "duty_pay_value")
    private Long dutyPayValue;
    @Size(max = 45)
    @Column(name = "duty_pay_num")
    private String dutyPayNum;
    @Column(name = "duty_pay_date")
    @Temporal(TemporalType.DATE)
    private Date dutyPayDate;
    @JoinColumn(name = "branch_client_id", referencedColumnName = "branch_client_id")
    @ManyToOne(optional = false)
    private BranchClient branchClientId;

    public DutyPay() {
    }

    public DutyPay(Integer dutyApyId) {
        this.dutyApyId = dutyApyId;
    }

    public Integer getDutyApyId() {
        return dutyApyId;
    }

    public void setDutyApyId(Integer dutyApyId) {
        this.dutyApyId = dutyApyId;
    }

    public Long getDutyPayValue() {
        return dutyPayValue;
    }

    public void setDutyPayValue(Long dutyPayValue) {
        this.dutyPayValue = dutyPayValue;
    }

    public String getDutyPayNum() {
        return dutyPayNum;
    }

    public void setDutyPayNum(String dutyPayNum) {
        this.dutyPayNum = dutyPayNum;
    }

    public Date getDutyPayDate() {
        return dutyPayDate;
    }

    public void setDutyPayDate(Date dutyPayDate) {
        this.dutyPayDate = dutyPayDate;
    }

    public BranchClient getBranchClientId() {
        return branchClientId;
    }

    public void setBranchClientId(BranchClient branchClientId) {
        this.branchClientId = branchClientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dutyApyId != null ? dutyApyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DutyPay)) {
            return false;
        }
        DutyPay other = (DutyPay) object;
        if ((this.dutyApyId == null && other.dutyApyId != null) || (this.dutyApyId != null && !this.dutyApyId.equals(other.dutyApyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DutyPay[ dutyApyId=" + dutyApyId + " ]";
    }
    
}
