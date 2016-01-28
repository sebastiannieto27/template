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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "deparment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deparment.findAll", query = "SELECT d FROM Deparment d"),
    @NamedQuery(name = "Deparment.findByDeparmentId", query = "SELECT d FROM Deparment d WHERE d.deparmentId = :deparmentId"),
    @NamedQuery(name = "Deparment.findByDeparmentName", query = "SELECT d FROM Deparment d WHERE d.deparmentName = :deparmentName")})
public class Deparment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deparment_id")
    private Integer deparmentId;
    @Size(max = 45)
    @Column(name = "deparment_name")
    private String deparmentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deparmentId")
    private Collection<City> cityCollection;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = false)
    private Country countryId;

    public Deparment() {
    }

    public Deparment(Integer deparmentId) {
        this.deparmentId = deparmentId;
    }

    public Integer getDeparmentId() {
        return deparmentId;
    }

    public void setDeparmentId(Integer deparmentId) {
        this.deparmentId = deparmentId;
    }

    public String getDeparmentName() {
        return deparmentName;
    }

    public void setDeparmentName(String deparmentName) {
        this.deparmentName = deparmentName;
    }

    @XmlTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deparmentId != null ? deparmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deparment)) {
            return false;
        }
        Deparment other = (Deparment) object;
        if ((this.deparmentId == null && other.deparmentId != null) || (this.deparmentId != null && !this.deparmentId.equals(other.deparmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.Deparment[ deparmentId=" + deparmentId + " ]";
    }
    
}
