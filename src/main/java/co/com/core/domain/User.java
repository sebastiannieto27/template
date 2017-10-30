/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain;
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

import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.domain.psaber.ResultadoExamenUsuario;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByIdNumber", query = "SELECT u FROM User u WHERE u.idNumber = :idNumber"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active"),
    @NamedQuery(name = "User.findByCreationDate", query = "SELECT u FROM User u WHERE u.creationDate = :creationDate")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "complete_name")
    private String completeName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "active")
    private Boolean active;
    @Size(max = 45)
    @Column(name = "creation_date")
    private String creationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserRole> userRoleCollection;
    @JoinColumn(name = "city_city_id", referencedColumnName = "city_id")
    @ManyToOne
    private City cityCityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderId")
    private Collection<Message> messageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiverId")
    private Collection<Message> messageCollection1;
    @Column(name = "account_locked")
    private Short accountLocked;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UploadedFile> uploadedFileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<RespuestaExamen> respuestaExamenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<ResultadoExamenUsuario> resultadoExamenUsuarioCollection;
    
    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String firstName, String lastName, String email, String password, String idNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.idNumber = idNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	@XmlTransient
    public Collection<UserRole> getUserRoleCollection() {
        return userRoleCollection;
    }

    public void setUserRoleCollection(Collection<UserRole> userRoleCollection) {
        this.userRoleCollection = userRoleCollection;
    }

    public City getCityCityId() {
        return cityCityId;
    }

    public void setCityCityId(City cityCityId) {
        this.cityCityId = cityCityId;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection1() {
        return messageCollection1;
    }

    public void setMessageCollection1(Collection<Message> messageCollection1) {
        this.messageCollection1 = messageCollection1;
    }
    
    public Short getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Short accountLocked) {
        this.accountLocked = accountLocked;
    }

    @XmlTransient
    public Collection<RespuestaExamen> getRespuestaExamenCollection() {
        return respuestaExamenCollection;
    }

    public void setRespuestaExamenCollection(Collection<RespuestaExamen> respuestaExamenCollection) {
        this.respuestaExamenCollection = respuestaExamenCollection;
    }

    @XmlTransient
    public Collection<ResultadoExamenUsuario> getResultadoExamenUsuarioCollection() {
        return resultadoExamenUsuarioCollection;
    }

    public void setResultadoExamenUsuarioCollection(Collection<ResultadoExamenUsuario> resultadoExamenUsuarioCollection) {
        this.resultadoExamenUsuarioCollection = resultadoExamenUsuarioCollection;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", idNumber=" + idNumber + ", active=" + active
				+ ", creationDate=" + creationDate + ", userRoleCollection="
				+ userRoleCollection + ", cityCityId=" + cityCityId + "]";
	}
    
}
