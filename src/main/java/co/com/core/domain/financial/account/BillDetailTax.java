/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.financial.account;

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
@Table(name = "bill_detail_tax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillDetailTax.findAll", query = "SELECT b FROM BillDetailTax b"),
    @NamedQuery(name = "BillDetailTax.findByBillDetailTaxId", query = "SELECT b FROM BillDetailTax b WHERE b.billDetailTaxId = :billDetailTaxId"),
    @NamedQuery(name = "BillDetailTax.findByBillDetailTaxVal", query = "SELECT b FROM BillDetailTax b WHERE b.billDetailTaxVal = :billDetailTaxVal")})
public class BillDetailTax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_detail_tax_id")
    private Integer billDetailTaxId;
    @Column(name = "bill_detail_tax_val")
    private Long billDetailTaxVal;
    @JoinColumn(name = "bill_detail_id", referencedColumnName = "bill_detail_id")
    @ManyToOne(optional = false)
    private BillDetail billDetailId;
    @JoinColumn(name = "tax_id", referencedColumnName = "tax_id")
    @ManyToOne(optional = false)
    private Tax taxId;

    public BillDetailTax() {
    }

    public BillDetailTax(Integer billDetailTaxId) {
        this.billDetailTaxId = billDetailTaxId;
    }

    public Integer getBillDetailTaxId() {
        return billDetailTaxId;
    }

    public void setBillDetailTaxId(Integer billDetailTaxId) {
        this.billDetailTaxId = billDetailTaxId;
    }

    public Long getBillDetailTaxVal() {
        return billDetailTaxVal;
    }

    public void setBillDetailTaxVal(Long billDetailTaxVal) {
        this.billDetailTaxVal = billDetailTaxVal;
    }

    public BillDetail getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(BillDetail billDetailId) {
        this.billDetailId = billDetailId;
    }

    public Tax getTaxId() {
        return taxId;
    }

    public void setTaxId(Tax taxId) {
        this.taxId = taxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billDetailTaxId != null ? billDetailTaxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillDetailTax)) {
            return false;
        }
        BillDetailTax other = (BillDetailTax) object;
        if ((this.billDetailTaxId == null && other.billDetailTaxId != null) || (this.billDetailTaxId != null && !this.billDetailTaxId.equals(other.billDetailTaxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BillDetailTax[ billDetailTaxId=" + billDetailTaxId + " ]";
    }
    
}
