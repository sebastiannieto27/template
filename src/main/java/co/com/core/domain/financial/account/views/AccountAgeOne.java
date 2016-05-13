/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.financial.account.views;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "account_age_one")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountAgeOne.findAll", query = "SELECT a FROM AccountAgeOne a"),
    @NamedQuery(name = "AccountAgeOne.findByAccountAgeId", query = "SELECT a FROM AccountAgeOne a WHERE a.accountAgeId = :accountAgeId"),
    @NamedQuery(name = "AccountAgeOne.findByClientName", query = "SELECT a FROM AccountAgeOne a WHERE a.clientName = :clientName"),
    @NamedQuery(name = "AccountAgeOne.findByBranchClName", query = "SELECT a FROM AccountAgeOne a WHERE a.branchClName = :branchClName")})
public class AccountAgeOne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_age_id")
    private int accountAgeId;
    @Size(max = 150)
    @Column(name = "client_name")
    private String clientName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "branch_cl_name")
    private String branchClName;

    public AccountAgeOne() {
    }

    public int getAccountAgeId() {
        return accountAgeId;
    }

    public void setAccountAgeId(int accountAgeId) {
        this.accountAgeId = accountAgeId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getBranchClName() {
        return branchClName;
    }

    public void setBranchClName(String branchClName) {
        this.branchClName = branchClName;
    }

	@Override
	public String toString() {
		return "AccountAgeOne [accountAgeId=" + accountAgeId + ", clientName="
				+ clientName + ", branchClName=" + branchClName + "]";
	}
    
}
