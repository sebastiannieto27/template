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
@Table(name = "archivo_prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivoPrueba.findAll", query = "SELECT a FROM ArchivoPrueba a")
    , @NamedQuery(name = "ArchivoPrueba.findByArchivoPruebaId", query = "SELECT a FROM ArchivoPrueba a WHERE a.archivoPruebaId = :archivoPruebaId")
    , @NamedQuery(name = "ArchivoPrueba.findByNombre", query = "SELECT a FROM ArchivoPrueba a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "ArchivoPrueba.findByNroColumnas", query = "SELECT a FROM ArchivoPrueba a WHERE a.nroColumnas = :nroColumnas")
    , @NamedQuery(name = "ArchivoPrueba.findByNroPreguntas", query = "SELECT a FROM ArchivoPrueba a WHERE a.nroPreguntas = :nroPreguntas")})
public class ArchivoPrueba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "archivo_prueba_id")
    private Integer archivoPruebaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_columnas")
    private int nroColumnas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nro_preguntas")
    private String nroPreguntas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "archivoPruebaId")
    private Collection<MediaNacionalArea> mediaNacionalAreaCollection;

    public ArchivoPrueba() {
    }

    public ArchivoPrueba(Integer archivoPruebaId) {
        this.archivoPruebaId = archivoPruebaId;
    }

    public ArchivoPrueba(Integer archivoPruebaId, String nombre, int nroColumnas, String nroPreguntas) {
        this.archivoPruebaId = archivoPruebaId;
        this.nombre = nombre;
        this.nroColumnas = nroColumnas;
        this.nroPreguntas = nroPreguntas;
    }

    public Integer getArchivoPruebaId() {
        return archivoPruebaId;
    }

    public void setArchivoPruebaId(Integer archivoPruebaId) {
        this.archivoPruebaId = archivoPruebaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroColumnas() {
        return nroColumnas;
    }

    public void setNroColumnas(int nroColumnas) {
        this.nroColumnas = nroColumnas;
    }

    public String getNroPreguntas() {
        return nroPreguntas;
    }

    public void setNroPreguntas(String nroPreguntas) {
        this.nroPreguntas = nroPreguntas;
    }

    @XmlTransient
    public Collection<MediaNacionalArea> getMediaNacionalAreaCollection() {
        return mediaNacionalAreaCollection;
    }

    public void setMediaNacionalAreaCollection(Collection<MediaNacionalArea> mediaNacionalAreaCollection) {
        this.mediaNacionalAreaCollection = mediaNacionalAreaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (archivoPruebaId != null ? archivoPruebaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivoPrueba)) {
            return false;
        }
        ArchivoPrueba other = (ArchivoPrueba) object;
        if ((this.archivoPruebaId == null && other.archivoPruebaId != null) || (this.archivoPruebaId != null && !this.archivoPruebaId.equals(other.archivoPruebaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.ArchivoPrueba[ archivoPruebaId=" + archivoPruebaId + " ]";
    }
    
    
}
