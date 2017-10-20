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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego.nieto
 */
@Entity
@Table(name = "pregunta_tema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaTema.findAll", query = "SELECT p FROM PreguntaTema p"), 
    @NamedQuery(name = "PreguntaTema.findByPreguntaId", query = "SELECT p FROM PreguntaTema p WHERE p.preguntaId = :preguntaId"),
    @NamedQuery(name = "PreguntaTema.findByPreguntaTemaId", query = "SELECT p FROM PreguntaTema p WHERE p.preguntaTemaId = :preguntaTemaId")})
public class PreguntaTema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pregunta_tema_id")
    private Integer preguntaTemaId;
    @JoinColumn(name = "pregunta_id", referencedColumnName = "pregunta_id")
    @ManyToOne(optional = false)
    private Pregunta preguntaId;
    @JoinColumn(name = "tema_id", referencedColumnName = "tema_id")
    @ManyToOne(optional = false)
    private Tema temaId;

    public PreguntaTema() {
    }

    public PreguntaTema(Integer preguntaTemaId) {
        this.preguntaTemaId = preguntaTemaId;
    }

    public Integer getPreguntaTemaId() {
        return preguntaTemaId;
    }

    public void setPreguntaTemaId(Integer preguntaTemaId) {
        this.preguntaTemaId = preguntaTemaId;
    }

    public Pregunta getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Pregunta preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Tema getTemaId() {
        return temaId;
    }

    public void setTemaId(Tema temaId) {
        this.temaId = temaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preguntaTemaId != null ? preguntaTemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaTema)) {
            return false;
        }
        PreguntaTema other = (PreguntaTema) object;
        if ((this.preguntaTemaId == null && other.preguntaTemaId != null) || (this.preguntaTemaId != null && !this.preguntaTemaId.equals(other.preguntaTemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.PreguntaTema[ preguntaTemaId=" + preguntaTemaId + " ]";
    }
    
}
