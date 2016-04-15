/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.financial.account.domain;

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
@Table(name = "credit_note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditNote.findAll", query = "SELECT c FROM CreditNote c"),
    @NamedQuery(name = "CreditNote.findByCreditNoteId", query = "SELECT c FROM CreditNote c WHERE c.creditNoteId = :creditNoteId"),
    @NamedQuery(name = "CreditNote.findByCreditNotValue", query = "SELECT c FROM CreditNote c WHERE c.creditNotValue = :creditNotValue"),
    @NamedQuery(name = "CreditNote.findByCreditNotNum", query = "SELECT c FROM CreditNote c WHERE c.creditNotNum = :creditNotNum"),
    @NamedQuery(name = "CreditNote.findByCreditNotDate", query = "SELECT c FROM CreditNote c WHERE c.creditNotDate = :creditNotDate")})
public class CreditNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "credit_note_id")
    private Integer creditNoteId;
    @Column(name = "credit_not_value")
    private Long creditNotValue;
    @Size(max = 45)
    @Column(name = "credit_not_num")
    private String creditNotNum;
    @Column(name = "credit_not_date")
    @Temporal(TemporalType.DATE)
    private Date creditNotDate;
    @JoinColumn(name = "branch_client_id", referencedColumnName = "branch_client_id")
    @ManyToOne(optional = false)
    private BranchClient branchClientId;
    @JoinColumn(name = "bill_head_id", referencedColumnName = "bill_head_id")
    @ManyToOne(optional = false)
    private BillHead billHeadId;
    @JoinColumn(name = "credit_note_type_id", referencedColumnName = "credit_note_type_id")
    @ManyToOne
    private CreditNoteType creditNoteTypeId;

    public CreditNote() {
    }

    public CreditNote(Integer creditNoteId) {
        this.creditNoteId = creditNoteId;
    }

    public Integer getCreditNoteId() {
        return creditNoteId;
    }

    public void setCreditNoteId(Integer creditNoteId) {
        this.creditNoteId = creditNoteId;
    }

    public Long getCreditNotValue() {
        return creditNotValue;
    }

    public void setCreditNotValue(Long creditNotValue) {
        this.creditNotValue = creditNotValue;
    }

    public String getCreditNotNum() {
        return creditNotNum;
    }

    public void setCreditNotNum(String creditNotNum) {
        this.creditNotNum = creditNotNum;
    }

    public Date getCreditNotDate() {
        return creditNotDate;
    }

    public void setCreditNotDate(Date creditNotDate) {
        this.creditNotDate = creditNotDate;
    }

    public BranchClient getBranchClientId() {
        return branchClientId;
    }

    public void setBranchClientId(BranchClient branchClientId) {
        this.branchClientId = branchClientId;
    }

    public BillHead getBillHeadId() {
        return billHeadId;
    }

    public void setBillHeadId(BillHead billHeadId) {
        this.billHeadId = billHeadId;
    }

    public CreditNoteType getCreditNoteTypeId() {
        return creditNoteTypeId;
    }

    public void setCreditNoteTypeId(CreditNoteType creditNoteTypeId) {
        this.creditNoteTypeId = creditNoteTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditNoteId != null ? creditNoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditNote)) {
            return false;
        }
        CreditNote other = (CreditNote) object;
        if ((this.creditNoteId == null && other.creditNoteId != null) || (this.creditNoteId != null && !this.creditNoteId.equals(other.creditNoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CreditNote[ creditNoteId=" + creditNoteId + " ]";
    }
    
}
