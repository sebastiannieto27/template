/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.financial.account;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import co.com.core.domain.cms.GeneralStatus;

/**
 *
 * @author root
 */
@Entity
@Table(name = "bill_head")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillHead.findAll", query = "SELECT b FROM BillHead b"),
    @NamedQuery(name = "BillHead.findByBillHeadId", query = "SELECT b FROM BillHead b WHERE b.billHeadId = :billHeadId"),
    @NamedQuery(name = "BillHead.findByBillHeadTotalValue", query = "SELECT b FROM BillHead b WHERE b.billHeadTotalValue = :billHeadTotalValue"),
    @NamedQuery(name = "BillHead.findByBillHeadTaxValue", query = "SELECT b FROM BillHead b WHERE b.billHeadTaxValue = :billHeadTaxValue"),
    @NamedQuery(name = "BillHead.findByBillHeadDiscValue", query = "SELECT b FROM BillHead b WHERE b.billHeadDiscValue = :billHeadDiscValue"),
    @NamedQuery(name = "BillHead.findByBillHeadNum", query = "SELECT b FROM BillHead b WHERE b.billHeadNum = :billHeadNum"),
    @NamedQuery(name = "BillHead.findByBillHeadDate", query = "SELECT b FROM BillHead b WHERE b.billHeadDate = :billHeadDate"),
    @NamedQuery(name = "BillHead.findByBillHeadDue", query = "SELECT b FROM BillHead b WHERE b.billHeadDue = :billHeadDue")})
public class BillHead implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_head_id")
    private Integer billHeadId;
    @Column(name = "bill_head_total_value")
    private Long billHeadTotalValue;
    @Column(name = "bill_head_tax_value")
    private Long billHeadTaxValue;
    @Column(name = "bill_head_disc_value")
    private Long billHeadDiscValue;
    @Size(max = 45)
    @Column(name = "bill_head_num")
    private String billHeadNum;
    @Column(name = "bill_head_date")
    @Temporal(TemporalType.DATE)
    private Date billHeadDate;
    @Column(name = "bill_head_due")
    @Temporal(TemporalType.DATE)
    private Date billHeadDue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billHeadId")
    private Collection<CreditNote> creditNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billHeadId")
    private Collection<AccountAgeBill> accountAgeBillCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billHeadId")
    private Collection<BillDetail> billDetailCollection;
    @JoinColumn(name = "branch_client_id", referencedColumnName = "branch_client_id")
    @ManyToOne(optional = false)
    private BranchClient branchClientId;
    @JoinColumn(name = "general_status_id", referencedColumnName = "general_status_id")
    @ManyToOne(optional = false)
    private GeneralStatus generalStatusId;

    public BillHead() {
    }

    public BillHead(Integer billHeadId) {
        this.billHeadId = billHeadId;
    }

    public Integer getBillHeadId() {
        return billHeadId;
    }

    public void setBillHeadId(Integer billHeadId) {
        this.billHeadId = billHeadId;
    }

    public Long getBillHeadTotalValue() {
        return billHeadTotalValue;
    }

    public void setBillHeadTotalValue(Long billHeadTotalValue) {
        this.billHeadTotalValue = billHeadTotalValue;
    }

    public Long getBillHeadTaxValue() {
        return billHeadTaxValue;
    }

    public void setBillHeadTaxValue(Long billHeadTaxValue) {
        this.billHeadTaxValue = billHeadTaxValue;
    }

    public Long getBillHeadDiscValue() {
        return billHeadDiscValue;
    }

    public void setBillHeadDiscValue(Long billHeadDiscValue) {
        this.billHeadDiscValue = billHeadDiscValue;
    }

    public String getBillHeadNum() {
        return billHeadNum;
    }

    public void setBillHeadNum(String billHeadNum) {
        this.billHeadNum = billHeadNum;
    }

    public Date getBillHeadDate() {
        return billHeadDate;
    }

    public void setBillHeadDate(Date billHeadDate) {
        this.billHeadDate = billHeadDate;
    }

    public Date getBillHeadDue() {
        return billHeadDue;
    }

    public void setBillHeadDue(Date billHeadDue) {
        this.billHeadDue = billHeadDue;
    }

    @XmlTransient
    public Collection<CreditNote> getCreditNoteCollection() {
        return creditNoteCollection;
    }

    public void setCreditNoteCollection(Collection<CreditNote> creditNoteCollection) {
        this.creditNoteCollection = creditNoteCollection;
    }

    @XmlTransient
    public Collection<AccountAgeBill> getAccountAgeBillCollection() {
        return accountAgeBillCollection;
    }

    public void setAccountAgeBillCollection(Collection<AccountAgeBill> accountAgeBillCollection) {
        this.accountAgeBillCollection = accountAgeBillCollection;
    }

    @XmlTransient
    public Collection<BillDetail> getBillDetailCollection() {
        return billDetailCollection;
    }

    public void setBillDetailCollection(Collection<BillDetail> billDetailCollection) {
        this.billDetailCollection = billDetailCollection;
    }

    public BranchClient getBranchClientId() {
        return branchClientId;
    }

    public void setBranchClientId(BranchClient branchClientId) {
        this.branchClientId = branchClientId;
    }

    public GeneralStatus getGeneralStatusId() {
        return generalStatusId;
    }

    public void setGeneralStatusId(GeneralStatus generalStatusId) {
        this.generalStatusId = generalStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billHeadId != null ? billHeadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillHead)) {
            return false;
        }
        BillHead other = (BillHead) object;
        if ((this.billHeadId == null && other.billHeadId != null) || (this.billHeadId != null && !this.billHeadId.equals(other.billHeadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BillHead[ billHeadId=" + billHeadId + " ]";
    }
    
}
