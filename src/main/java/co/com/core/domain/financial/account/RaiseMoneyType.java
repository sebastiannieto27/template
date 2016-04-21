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
@Table(name = "raise_money_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RaiseMoneyType.findAll", query = "SELECT r FROM RaiseMoneyType r"),
    @NamedQuery(name = "RaiseMoneyType.findByRaiseMoneyTypeId", query = "SELECT r FROM RaiseMoneyType r WHERE r.raiseMoneyTypeId = :raiseMoneyTypeId"),
    @NamedQuery(name = "RaiseMoneyType.findByRaiseMonTypeName", query = "SELECT r FROM RaiseMoneyType r WHERE r.raiseMonTypeName = :raiseMonTypeName")})
public class RaiseMoneyType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "raise_money_type_id")
    private Integer raiseMoneyTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "raise_mon_type_name")
    private String raiseMonTypeName;
    @OneToMany(mappedBy = "raiseMoneyTypeId")
    private Collection<RaiseMoney> raiseMoneyCollection;

    public RaiseMoneyType() {
    }

    public RaiseMoneyType(Integer raiseMoneyTypeId) {
        this.raiseMoneyTypeId = raiseMoneyTypeId;
    }

    public RaiseMoneyType(Integer raiseMoneyTypeId, String raiseMonTypeName) {
        this.raiseMoneyTypeId = raiseMoneyTypeId;
        this.raiseMonTypeName = raiseMonTypeName;
    }

    public Integer getRaiseMoneyTypeId() {
        return raiseMoneyTypeId;
    }

    public void setRaiseMoneyTypeId(Integer raiseMoneyTypeId) {
        this.raiseMoneyTypeId = raiseMoneyTypeId;
    }

    public String getRaiseMonTypeName() {
        return raiseMonTypeName;
    }

    public void setRaiseMonTypeName(String raiseMonTypeName) {
        this.raiseMonTypeName = raiseMonTypeName;
    }

    @XmlTransient
    public Collection<RaiseMoney> getRaiseMoneyCollection() {
        return raiseMoneyCollection;
    }

    public void setRaiseMoneyCollection(Collection<RaiseMoney> raiseMoneyCollection) {
        this.raiseMoneyCollection = raiseMoneyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (raiseMoneyTypeId != null ? raiseMoneyTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RaiseMoneyType)) {
            return false;
        }
        RaiseMoneyType other = (RaiseMoneyType) object;
        if ((this.raiseMoneyTypeId == null && other.raiseMoneyTypeId != null) || (this.raiseMoneyTypeId != null && !this.raiseMoneyTypeId.equals(other.raiseMoneyTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RaiseMoneyType[ raiseMoneyTypeId=" + raiseMoneyTypeId + " ]";
    }
    
}
