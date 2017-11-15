/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.psaber;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego.nieto
 */
@Entity
@Table(name = "archivo_prueba_procesado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivoPruebaProcesado.findAll", query = "SELECT a FROM ArchivoPruebaProcesado a")
    , @NamedQuery(name = "ArchivoPruebaProcesado.findByArchivoPruebaProcesadoId", query = "SELECT a FROM ArchivoPruebaProcesado a WHERE a.archivoPruebaProcesadoId = :archivoPruebaProcesadoId")
    , @NamedQuery(name = "ArchivoPruebaProcesado.findByFecCre", query = "SELECT a FROM ArchivoPruebaProcesado a WHERE a.fecCre = :fecCre")
    , @NamedQuery(name = "ArchivoPruebaProcesado.findByNombreArchivo", query = "SELECT a FROM ArchivoPruebaProcesado a WHERE a.nombreArchivo = :nombreArchivo")})
public class ArchivoPruebaProcesado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "archivo_prueba_procesado_id")
    private Integer archivoPruebaProcesadoId;
    @Column(name = "fec_cre")
    @Temporal(TemporalType.DATE)
    private Date fecCre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_archivo")
    private String nombreArchivo;
    @JoinColumn(name = "archivo_prueba_id", referencedColumnName = "archivo_prueba_id")
    @ManyToOne(optional = false)
    private ArchivoPrueba archivoPruebaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "archivoPruebaProcesadoId")
    private Collection<RespuestaExamen> respuestaExamenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "archivoPruebaProcesadoId")
    private Collection<PromedioAreaArchivoPruebaProcesado> promedioAreaArchivoPruebaProcesadoCollection;
    
    public ArchivoPruebaProcesado() {
    }

    public ArchivoPruebaProcesado(Integer archivoPruebaProcesadoId) {
        this.archivoPruebaProcesadoId = archivoPruebaProcesadoId;
    }

    public ArchivoPruebaProcesado(Integer archivoPruebaProcesadoId, String nombreArchivo) {
        this.archivoPruebaProcesadoId = archivoPruebaProcesadoId;
        this.nombreArchivo = nombreArchivo;
    }

    public Integer getArchivoPruebaProcesadoId() {
        return archivoPruebaProcesadoId;
    }

    public void setArchivoPruebaProcesadoId(Integer archivoPruebaProcesadoId) {
        this.archivoPruebaProcesadoId = archivoPruebaProcesadoId;
    }

    public Date getFecCre() {
        return fecCre;
    }

    public void setFecCre(Date fecCre) {
        this.fecCre = fecCre;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public ArchivoPrueba getArchivoPruebaId() {
        return archivoPruebaId;
    }

    public void setArchivoPruebaId(ArchivoPrueba archivoPruebaId) {
        this.archivoPruebaId = archivoPruebaId;
    }

    @XmlTransient
    public Collection<RespuestaExamen> getRespuestaExamenCollection() {
        return respuestaExamenCollection;
    }

    public void setRespuestaExamenCollection(Collection<RespuestaExamen> respuestaExamenCollection) {
        this.respuestaExamenCollection = respuestaExamenCollection;
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
        hash += (archivoPruebaProcesadoId != null ? archivoPruebaProcesadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivoPruebaProcesado)) {
            return false;
        }
        ArchivoPruebaProcesado other = (ArchivoPruebaProcesado) object;
        if ((this.archivoPruebaProcesadoId == null && other.archivoPruebaProcesadoId != null) || (this.archivoPruebaProcesadoId != null && !this.archivoPruebaProcesadoId.equals(other.archivoPruebaProcesadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.ArchivoPruebaProcesado[ archivoPruebaProcesadoId=" + archivoPruebaProcesadoId + " ]";
    }
    
}
