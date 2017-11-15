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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import co.com.core.domain.User;

/**
 *
 * @author diego.nieto
 */
@Entity
@Table(name = "respuesta_examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RespuestaExamen.findAll", query = "SELECT r FROM RespuestaExamen r"), 
    @NamedQuery(name = "RespuestaExamen.findByArchivoPruebaProcesado", query = "SELECT r FROM RespuestaExamen r WHERE r.archivoPruebaProcesadoId = :archivoPruebaProcesadoId AND r.procesado = :procesado"), 
    @NamedQuery(name = "RespuestaExamen.findByRespuestaExamenId", query = "SELECT r FROM RespuestaExamen r WHERE r.respuestaExamenId = :respuestaExamenId")})
public class RespuestaExamen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "respuesta_examen_id")
    private Integer respuestaExamenId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "respuesta")
    private String respuesta;
    @JoinColumn(name = "archivo_prueba_procesado_id", referencedColumnName = "archivo_prueba_procesado_id")
    @ManyToOne(optional = false)
    private ArchivoPruebaProcesado archivoPruebaProcesadoId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @Column(name = "procesado")
    private Short procesado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuestaExamenId")
    private Collection<ResultadoExamenUsuario> resultadoExamenUsuarioCollection;
    
    public RespuestaExamen() {
    }

    public RespuestaExamen(Integer respuestaExamenId) {
        this.respuestaExamenId = respuestaExamenId;
    }

    public RespuestaExamen(Integer respuestaExamenId, String respuesta) {
        this.respuestaExamenId = respuestaExamenId;
        this.respuesta = respuesta;
    }

    public Integer getRespuestaExamenId() {
        return respuestaExamenId;
    }

    public void setRespuestaExamenId(Integer respuestaExamenId) {
        this.respuestaExamenId = respuestaExamenId;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public ArchivoPruebaProcesado getArchivoPruebaProcesadoId() {
        return archivoPruebaProcesadoId;
    }

    public void setArchivoPruebaProcesadoId(ArchivoPruebaProcesado archivoPruebaProcesadoId) {
        this.archivoPruebaProcesadoId = archivoPruebaProcesadoId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<ResultadoExamenUsuario> getResultadoExamenUsuarioCollection() {
        return resultadoExamenUsuarioCollection;
    }

    public void setResultadoExamenUsuarioCollection(Collection<ResultadoExamenUsuario> resultadoExamenUsuarioCollection) {
        this.resultadoExamenUsuarioCollection = resultadoExamenUsuarioCollection;
    }

    public Short getProcesado() {
        return procesado;
    }

    public void setProcesado(Short procesado) {
        this.procesado = procesado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respuestaExamenId != null ? respuestaExamenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaExamen)) {
            return false;
        }
        RespuestaExamen other = (RespuestaExamen) object;
        if ((this.respuestaExamenId == null && other.respuestaExamenId != null) || (this.respuestaExamenId != null && !this.respuestaExamenId.equals(other.respuestaExamenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.RespuestaExamen[ respuestaExamenId=" + respuestaExamenId + " ]";
    }
    
}
