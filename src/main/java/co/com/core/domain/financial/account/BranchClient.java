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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "branch_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchClient.findAll", query = "SELECT b FROM BranchClient b"),
    @NamedQuery(name = "BranchClient.findByBranchClientId", query = "SELECT b FROM BranchClient b WHERE b.branchClientId = :branchClientId"),
    @NamedQuery(name = "BranchClient.findByBranchClName", query = "SELECT b FROM BranchClient b WHERE b.branchClName = :branchClName"),
    @NamedQuery(name = "BranchClient.findByBranchClIntCode", query = "SELECT b FROM BranchClient b WHERE b.branchClIntCode = :branchClIntCode"),
    @NamedQuery(name = "BranchClient.findByBranchClAddress", query = "SELECT b FROM BranchClient b WHERE b.branchClAddress = :branchClAddress"),
    @NamedQuery(name = "BranchClient.findByBranchClPhone", query = "SELECT b FROM BranchClient b WHERE b.branchClPhone = :branchClPhone")})
public class BranchClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_client_id")
    private Integer branchClientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "branch_cl_name")
    private String branchClName;
    @Size(max = 30)
    @Column(name = "branch_cl_int_code")
    private String branchClIntCode;
    @Size(max = 150)
    @Column(name = "branch_cl_address")
    private String branchClAddress;
    @Size(max = 45)
    @Column(name = "branch_cl_phone")
    private String branchClPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchClientId")
    private Collection<AccountAge> accountAgeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchClientId")
    private Collection<DutyPay> dutyPayCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchClientId")
    private Collection<CreditNote> creditNoteCollection;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false)
    private Client clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchClientId")
    private Collection<RaiseMoney> raiseMoneyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchClientId")
    private Collection<BillHead> billHeadCollection;

    public BranchClient() {
    }

    public BranchClient(Integer branchClientId) {
        this.branchClientId = branchClientId;
    }

    public BranchClient(Integer branchClientId, String branchClName) {
        this.branchClientId = branchClientId;
        this.branchClName = branchClName;
    }

    public Integer getBranchClientId() {
        return branchClientId;
    }

    public void setBranchClientId(Integer branchClientId) {
        this.branchClientId = branchClientId;
    }

    public String getBranchClName() {
        return branchClName;
    }

    public void setBranchClName(String branchClName) {
        this.branchClName = branchClName;
    }

    public String getBranchClIntCode() {
        return branchClIntCode;
    }

    public void setBranchClIntCode(String branchClIntCode) {
        this.branchClIntCode = branchClIntCode;
    }

    public String getBranchClAddress() {
        return branchClAddress;
    }

    public void setBranchClAddress(String branchClAddress) {
        this.branchClAddress = branchClAddress;
    }

    public String getBranchClPhone() {
        return branchClPhone;
    }

    public void setBranchClPhone(String branchClPhone) {
        this.branchClPhone = branchClPhone;
    }

    @XmlTransient
    public Collection<AccountAge> getAccountAgeCollection() {
        return accountAgeCollection;
    }

    public void setAccountAgeCollection(Collection<AccountAge> accountAgeCollection) {
        this.accountAgeCollection = accountAgeCollection;
    }

    @XmlTransient
    public Collection<DutyPay> getDutyPayCollection() {
        return dutyPayCollection;
    }

    public void setDutyPayCollection(Collection<DutyPay> dutyPayCollection) {
        this.dutyPayCollection = dutyPayCollection;
    }

    @XmlTransient
    public Collection<CreditNote> getCreditNoteCollection() {
        return creditNoteCollection;
    }

    public void setCreditNoteCollection(Collection<CreditNote> creditNoteCollection) {
        this.creditNoteCollection = creditNoteCollection;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    @XmlTransient
    public Collection<RaiseMoney> getRaiseMoneyCollection() {
        return raiseMoneyCollection;
    }

    public void setRaiseMoneyCollection(Collection<RaiseMoney> raiseMoneyCollection) {
        this.raiseMoneyCollection = raiseMoneyCollection;
    }

    @XmlTransient
    public Collection<BillHead> getBillHeadCollection() {
        return billHeadCollection;
    }

    public void setBillHeadCollection(Collection<BillHead> billHeadCollection) {
        this.billHeadCollection = billHeadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchClientId != null ? branchClientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchClient)) {
            return false;
        }
        BranchClient other = (BranchClient) object;
        if ((this.branchClientId == null && other.branchClientId != null) || (this.branchClientId != null && !this.branchClientId.equals(other.branchClientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BranchClient[ branchClientId=" + branchClientId + " ]";
    }
    
}
