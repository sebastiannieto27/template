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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
    , @NamedQuery(name = "Pregunta.findByPreguntaId", query = "SELECT p FROM Pregunta p WHERE p.preguntaId = :preguntaId")
    , @NamedQuery(name = "Pregunta.findByValor", query = "SELECT p FROM Pregunta p WHERE p.valor = :valor")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pregunta_id")
    private Integer preguntaId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "contenido_id", referencedColumnName = "contenido_id")
    @ManyToOne(optional = false)
    private Contenido contenidoId;
    @JoinColumn(name = "materia_id", referencedColumnName = "materia_id")
    @ManyToOne(optional = false)
    private Materia materiaId;

    public Pregunta() {
    }

    public Pregunta(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Pregunta(Integer preguntaId, String descripcion, double valor) {
        this.preguntaId = preguntaId;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public Integer getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Contenido getContenidoId() {
        return contenidoId;
    }

    public void setContenidoId(Contenido contenidoId) {
        this.contenidoId = contenidoId;
    }

    public Materia getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Materia materiaId) {
        this.materiaId = materiaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preguntaId != null ? preguntaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preguntaId == null && other.preguntaId != null) || (this.preguntaId != null && !this.preguntaId.equals(other.preguntaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.domain.Pregunta[ preguntaId=" + preguntaId + " ]";
    }
    
}
