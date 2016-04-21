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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "bill_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillDetail.findAll", query = "SELECT b FROM BillDetail b"),
    @NamedQuery(name = "BillDetail.findByBillDetailId", query = "SELECT b FROM BillDetail b WHERE b.billDetailId = :billDetailId"),
    @NamedQuery(name = "BillDetail.findByBillDetailUnitVal", query = "SELECT b FROM BillDetail b WHERE b.billDetailUnitVal = :billDetailUnitVal"),
    @NamedQuery(name = "BillDetail.findByBillDetailAmount", query = "SELECT b FROM BillDetail b WHERE b.billDetailAmount = :billDetailAmount"),
    @NamedQuery(name = "BillDetail.findByBillDetailTotValue", query = "SELECT b FROM BillDetail b WHERE b.billDetailTotValue = :billDetailTotValue")})
public class BillDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_detail_id")
    private Integer billDetailId;
    @Column(name = "bill_detail_unit_val")
    private Long billDetailUnitVal;
    @Column(name = "bill_detail_amount")
    private Integer billDetailAmount;
    @Column(name = "bill_detail_tot_value")
    private Long billDetailTotValue;
    @JoinColumn(name = "bill_head_id", referencedColumnName = "bill_head_id")
    @ManyToOne(optional = false)
    private BillHead billHeadId;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Product productId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billDetailId")
    private Collection<BillDetailTax> billDetailTaxCollection;

    public BillDetail() {
    }

    public BillDetail(Integer billDetailId) {
        this.billDetailId = billDetailId;
    }

    public Integer getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(Integer billDetailId) {
        this.billDetailId = billDetailId;
    }

    public Long getBillDetailUnitVal() {
        return billDetailUnitVal;
    }

    public void setBillDetailUnitVal(Long billDetailUnitVal) {
        this.billDetailUnitVal = billDetailUnitVal;
    }

    public Integer getBillDetailAmount() {
        return billDetailAmount;
    }

    public void setBillDetailAmount(Integer billDetailAmount) {
        this.billDetailAmount = billDetailAmount;
    }

    public Long getBillDetailTotValue() {
        return billDetailTotValue;
    }

    public void setBillDetailTotValue(Long billDetailTotValue) {
        this.billDetailTotValue = billDetailTotValue;
    }

    public BillHead getBillHeadId() {
        return billHeadId;
    }

    public void setBillHeadId(BillHead billHeadId) {
        this.billHeadId = billHeadId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @XmlTransient
    public Collection<BillDetailTax> getBillDetailTaxCollection() {
        return billDetailTaxCollection;
    }

    public void setBillDetailTaxCollection(Collection<BillDetailTax> billDetailTaxCollection) {
        this.billDetailTaxCollection = billDetailTaxCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billDetailId != null ? billDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillDetail)) {
            return false;
        }
        BillDetail other = (BillDetail) object;
        if ((this.billDetailId == null && other.billDetailId != null) || (this.billDetailId != null && !this.billDetailId.equals(other.billDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BillDetail[ billDetailId=" + billDetailId + " ]";
    }
    
}
