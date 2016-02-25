/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "login_attempt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginAttempt.findAll", query = "SELECT l FROM LoginAttempt l"),
    @NamedQuery(name = "LoginAttempt.findByLoginAttemptId", query = "SELECT l FROM LoginAttempt l WHERE l.loginAttemptId = :loginAttemptId"),
    @NamedQuery(name = "LoginAttempt.findByUserAgent", query = "SELECT l FROM LoginAttempt l WHERE l.userAgent = :userAgent"),
    @NamedQuery(name = "LoginAttempt.findByIpAddress", query = "SELECT l FROM LoginAttempt l WHERE l.ipAddress = :ipAddress"),
    @NamedQuery(name = "LoginAttempt.findByDateAttempt", query = "SELECT l FROM LoginAttempt l WHERE l.dateAttempt = :dateAttempt"),
    @NamedQuery(name = "LoginAttempt.findByValidAttempt", query = "SELECT l FROM LoginAttempt l WHERE l.validAttempt = :validAttempt"),
    @NamedQuery(name = "LoginAttempt.findByUserMail", query = "SELECT l FROM LoginAttempt l WHERE l.userMail = :userMail")})
public class LoginAttempt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "login_attempt_id")
    private Integer loginAttemptId;
    @Lob
    @Size(max = 65535)
    @Column(name = "user_agent")
    private String userAgent;
    @Size(max = 50)
    @Column(name = "ip_address")
    private String ipAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_attempt")
    private Timestamp dateAttempt;
    @Column(name = "valid_attempt")
    private Short validAttempt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_mail")
    private String userMail;

    public LoginAttempt() {
    }

    public LoginAttempt(Integer loginAttemptId) {
        this.loginAttemptId = loginAttemptId;
    }

    public LoginAttempt(Integer loginAttemptId, Timestamp dateAttempt, String userMail) {
        this.loginAttemptId = loginAttemptId;
        this.dateAttempt = dateAttempt;
        this.userMail = userMail;
    }

    public Integer getLoginAttemptId() {
        return loginAttemptId;
    }

    public void setLoginAttemptId(Integer loginAttemptId) {
        this.loginAttemptId = loginAttemptId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Timestamp getDateAttempt() {
        return dateAttempt;
    }

    public void setDateAttempt(Timestamp dateAttempt) {
        this.dateAttempt = dateAttempt;
    }

    public Short getValidAttempt() {
        return validAttempt;
    }

    public void setValidAttempt(Short validAttempt) {
        this.validAttempt = validAttempt;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginAttemptId != null ? loginAttemptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginAttempt)) {
            return false;
        }
        LoginAttempt other = (LoginAttempt) object;
        if ((this.loginAttemptId == null && other.loginAttemptId != null) || (this.loginAttemptId != null && !this.loginAttemptId.equals(other.loginAttemptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.LoginAttempt[ loginAttemptId=" + loginAttemptId + " ]";
    }
    
}
