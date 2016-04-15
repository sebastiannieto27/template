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
@Table(name = "tax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tax.findAll", query = "SELECT t FROM Tax t"),
    @NamedQuery(name = "Tax.findByTaxId", query = "SELECT t FROM Tax t WHERE t.taxId = :taxId"),
    @NamedQuery(name = "Tax.findByTaxName", query = "SELECT t FROM Tax t WHERE t.taxName = :taxName"),
    @NamedQuery(name = "Tax.findByTaxPercentage", query = "SELECT t FROM Tax t WHERE t.taxPercentage = :taxPercentage"),
    @NamedQuery(name = "Tax.findByTaxValue", query = "SELECT t FROM Tax t WHERE t.taxValue = :taxValue"),
    @NamedQuery(name = "Tax.findByTaxIntCode", query = "SELECT t FROM Tax t WHERE t.taxIntCode = :taxIntCode")})
public class Tax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tax_id")
    private Integer taxId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "tax_name")
    private String taxName;
    @Column(name = "tax_percentage")
    private Integer taxPercentage;
    @Column(name = "tax_value")
    private Long taxValue;
    @Size(max = 45)
    @Column(name = "tax_int_code")
    private String taxIntCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxId")
    private Collection<BillDetailTax> billDetailTaxCollection;

    public Tax() {
    }

    public Tax(Integer taxId) {
        this.taxId = taxId;
    }

    public Tax(Integer taxId, String taxName) {
        this.taxId = taxId;
        this.taxName = taxName;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Integer getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Integer taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public Long getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(Long taxValue) {
        this.taxValue = taxValue;
    }

    public String getTaxIntCode() {
        return taxIntCode;
    }

    public void setTaxIntCode(String taxIntCode) {
        this.taxIntCode = taxIntCode;
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
        hash += (taxId != null ? taxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tax)) {
            return false;
        }
        Tax other = (Tax) object;
        if ((this.taxId == null && other.taxId != null) || (this.taxId != null && !this.taxId.equals(other.taxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tax[ taxId=" + taxId + " ]";
    }
    
}
