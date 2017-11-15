/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.psaber;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author diego.nieto
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findByAreaId", query = "SELECT a FROM Area a WHERE a.areaId = :areaId")
    , @NamedQuery(name = "Area.findByNombre", query = "SELECT a FROM Area a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Area.findByCodigo", query = "SELECT a FROM Area a WHERE a.codigo = :codigo")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "area_id")
    private Integer areaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaId")
    private Collection<Tema> temaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaId")
    private Collection<AreaArchivoPrueba> areaArchivoPruebaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaId")
    private Collection<ResultadoExamenUsuario> resultadoExamenUsuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaId")
    private Collection<PromedioAreaArchivoPruebaProcesado> promedioAreaArchivoPruebaProcesadoCollection;
    
    public Area() {
    }

    public Area(Integer areaId) {
        this.areaId = areaId;
    }

    public Area(Integer areaId, String nombre, String codigo) {
        this.areaId = areaId;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Tema> getTemaCollection() {
        return temaCollection;
    }

    public void setTemaCollection(Collection<Tema> temaCollection) {
        this.temaCollection = temaCollection;
    }

    @XmlTransient
    public Collection<AreaArchivoPrueba> getAreaArchivoPruebaCollection() {
        return areaArchivoPruebaCollection;
    }

    public void setAreaArchivoPruebaCollection(Collection<AreaArchivoPrueba> areaArchivoPruebaCollection) {
        this.areaArchivoPruebaCollection = areaArchivoPruebaCollection;
    }

    @XmlTransient
    public Collection<ResultadoExamenUsuario> getResultadoExamenUsuarioCollection() {
        return resultadoExamenUsuarioCollection;
    }

    public void setResultadoExamenUsuarioCollection(Collection<ResultadoExamenUsuario> resultadoExamenUsuarioCollection) {
        this.resultadoExamenUsuarioCollection = resultadoExamenUsuarioCollection;
    }
    
    @XmlTransient
    public Collection<PromedioAreaArchivoPruebaProcesado> getPromedioAreaArchivoPruebaProcesadoCollection() {
        return promedioAreaArchivoPruebaProcesadoCollection;
    }

    public void setPromedioAreaArchivoPruebaProcesadoCollection(Collection<PromedioAreaArchivoPruebaProcesado> promedioAreaArchivoPruebaProcesadoCollection) {
        this.promedioAreaArchivoPruebaProcesadoCollection = promedioAreaArchivoPruebaProcesadoCollection;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.Area[ areaId=" + areaId + " ]";
    }
    
}
