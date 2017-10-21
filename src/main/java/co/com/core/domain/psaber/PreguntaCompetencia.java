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
@Table(name = "pregunta_competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaCompetencia.findAll", query = "SELECT p FROM PreguntaCompetencia p")
    , @NamedQuery(name = "PreguntaCompetencia.findByPreguntaCompetenciaId", query = "SELECT p FROM PreguntaCompetencia p WHERE p.preguntaCompetenciaId = :preguntaCompetenciaId")})
public class PreguntaCompetencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pregunta_competencia_id")
    private Integer preguntaCompetenciaId;
    @JoinColumn(name = "competencia_id", referencedColumnName = "competencia_id")
    @ManyToOne(optional = false)
    private Competencia competenciaId;
    @JoinColumn(name = "pregunta_id", referencedColumnName = "pregunta_id")
    @ManyToOne(optional = false)
    private Pregunta preguntaId;

    public PreguntaCompetencia() {
    }

    public PreguntaCompetencia(Integer preguntaCompetenciaId) {
        this.preguntaCompetenciaId = preguntaCompetenciaId;
    }

    public Integer getPreguntaCompetenciaId() {
        return preguntaCompetenciaId;
    }

    public void setPreguntaCompetenciaId(Integer preguntaCompetenciaId) {
        this.preguntaCompetenciaId = preguntaCompetenciaId;
    }

    public Competencia getCompetenciaId() {
        return competenciaId;
    }

    public void setCompetenciaId(Competencia competenciaId) {
        this.competenciaId = competenciaId;
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
        hash += (preguntaCompetenciaId != null ? preguntaCompetenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaCompetencia)) {
            return false;
        }
        PreguntaCompetencia other = (PreguntaCompetencia) object;
        if ((this.preguntaCompetenciaId == null && other.preguntaCompetenciaId != null) || (this.preguntaCompetenciaId != null && !this.preguntaCompetenciaId.equals(other.preguntaCompetenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.PreguntaCompetencia[ preguntaCompetenciaId=" + preguntaCompetenciaId + " ]";
    }
    
}
