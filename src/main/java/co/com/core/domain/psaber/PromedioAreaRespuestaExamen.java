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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego.nieto
 */
@Entity
@Table(name = "promedio_area_respuesta_examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PromedioAreaRespuestaExamen.findAll", query = "SELECT p FROM PromedioAreaRespuestaExamen p")
    , @NamedQuery(name = "PromedioAreaRespuestaExamen.findByPromedioAreaRespuestaExamenId", query = "SELECT p FROM PromedioAreaRespuestaExamen p WHERE p.promedioAreaRespuestaExamenId = :promedioAreaRespuestaExamenId")
    , @NamedQuery(name = "PromedioAreaRespuestaExamen.findByValor", query = "SELECT p FROM PromedioAreaRespuestaExamen p WHERE p.valor = :valor")})
public class PromedioAreaRespuestaExamen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "promedio_area_respuesta_examen_id")
    private Integer promedioAreaRespuestaExamenId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    @ManyToOne(optional = false)
    private Area areaId;
    @JoinColumn(name = "respuesta_examen_id", referencedColumnName = "respuesta_examen_id")
    @ManyToOne(optional = false)
    private RespuestaExamen respuestaExamenId;

    public PromedioAreaRespuestaExamen() {
    }

    public PromedioAreaRespuestaExamen(Integer promedioAreaRespuestaExamenId) {
        this.promedioAreaRespuestaExamenId = promedioAreaRespuestaExamenId;
    }

    public PromedioAreaRespuestaExamen(Integer promedioAreaRespuestaExamenId, double valor) {
        this.promedioAreaRespuestaExamenId = promedioAreaRespuestaExamenId;
        this.valor = valor;
    }

    public Integer getPromedioAreaRespuestaExamenId() {
        return promedioAreaRespuestaExamenId;
    }

    public void setPromedioAreaRespuestaExamenId(Integer promedioAreaRespuestaExamenId) {
        this.promedioAreaRespuestaExamenId = promedioAreaRespuestaExamenId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }

    public RespuestaExamen getRespuestaExamenId() {
        return respuestaExamenId;
    }

    public void setRespuestaExamenId(RespuestaExamen respuestaExamenId) {
        this.respuestaExamenId = respuestaExamenId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promedioAreaRespuestaExamenId != null ? promedioAreaRespuestaExamenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromedioAreaRespuestaExamen)) {
            return false;
        }
        PromedioAreaRespuestaExamen other = (PromedioAreaRespuestaExamen) object;
        if ((this.promedioAreaRespuestaExamenId == null && other.promedioAreaRespuestaExamenId != null) || (this.promedioAreaRespuestaExamenId != null && !this.promedioAreaRespuestaExamenId.equals(other.promedioAreaRespuestaExamenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.PromedioAreaRespuestaExamen[ promedioAreaRespuestaExamenId=" + promedioAreaRespuestaExamenId + " ]";
    }
    
}
