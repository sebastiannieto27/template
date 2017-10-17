/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain.psaber;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego.nieto
 */
@Entity
@Table(name = "respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
    , @NamedQuery(name = "Respuesta.findByRespuestaId", query = "SELECT r FROM Respuesta r WHERE r.respuestaId = :respuestaId")
    , @NamedQuery(name = "Respuesta.findByTitulo", query = "SELECT r FROM Respuesta r WHERE r.titulo = :titulo")
    , @NamedQuery(name = "Respuesta.findByCodigo", query = "SELECT r FROM Respuesta r WHERE r.codigo = :codigo")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "respuesta_id")
    private Integer respuestaId;
    @Size(max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "pregunta_id", referencedColumnName = "pregunta_id")
    @ManyToOne(optional = false)
    private Pregunta preguntaId;

    public Respuesta() {
    }

    public Respuesta(Integer respuestaId) {
        this.respuestaId = respuestaId;
    }

    public Integer getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(Integer respuestaId) {
        this.respuestaId = respuestaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Pregunta getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Pregunta preguntaId) {
        this.preguntaId = preguntaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respuestaId != null ? respuestaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.respuestaId == null && other.respuestaId != null) || (this.respuestaId != null && !this.respuestaId.equals(other.respuestaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.Respuesta[ respuestaId=" + respuestaId + " ]";
    }
    
}
