/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.financial.account;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "credit_note_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditNoteType.findAll", query = "SELECT c FROM CreditNoteType c"),
    @NamedQuery(name = "CreditNoteType.findByCreditNoteTypeId", query = "SELECT c FROM CreditNoteType c WHERE c.creditNoteTypeId = :creditNoteTypeId"),
    @NamedQuery(name = "CreditNoteType.findByCreditNotTypeName", query = "SELECT c FROM CreditNoteType c WHERE c.creditNotTypeName = :creditNotTypeName")})
public class CreditNoteType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "credit_note_type_id")
    private Integer creditNoteTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "credit_not_type_name")
    private String creditNotTypeName;
    @OneToMany(mappedBy = "creditNoteTypeId")
    private Collection<CreditNote> creditNoteCollection;

    public CreditNoteType() {
    }

    public CreditNoteType(Integer creditNoteTypeId) {
        this.creditNoteTypeId = creditNoteTypeId;
    }

    public CreditNoteType(Integer creditNoteTypeId, String creditNotTypeName) {
        this.creditNoteTypeId = creditNoteTypeId;
        this.creditNotTypeName = creditNotTypeName;
    }

    public Integer getCreditNoteTypeId() {
        return creditNoteTypeId;
    }

    public void setCreditNoteTypeId(Integer creditNoteTypeId) {
        this.creditNoteTypeId = creditNoteTypeId;
    }

    public String getCreditNotTypeName() {
        return creditNotTypeName;
    }

    public void setCreditNotTypeName(String creditNotTypeName) {
        this.creditNotTypeName = creditNotTypeName;
    }

    @XmlTransient
    public Collection<CreditNote> getCreditNoteCollection() {
        return creditNoteCollection;
    }

    public void setCreditNoteCollection(Collection<CreditNote> creditNoteCollection) {
        this.creditNoteCollection = creditNoteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditNoteTypeId != null ? creditNoteTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditNoteType)) {
            return false;
        }
        CreditNoteType other = (CreditNoteType) object;
        if ((this.creditNoteTypeId == null && other.creditNoteTypeId != null) || (this.creditNoteTypeId != null && !this.creditNoteTypeId.equals(other.creditNoteTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CreditNoteType[ creditNoteTypeId=" + creditNoteTypeId + " ]";
    }
    
}
