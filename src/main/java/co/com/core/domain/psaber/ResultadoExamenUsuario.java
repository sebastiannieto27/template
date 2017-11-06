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

import co.com.core.domain.User;

/**
 *
 * @author diego.nieto
 */
@Entity
@Table(name = "resultado_examen_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoExamenUsuario.findAll", query = "SELECT r FROM ResultadoExamenUsuario r"), 
    @NamedQuery(name = "ResultadoExamenUsuario.findByResultadoExamenUsuarioId", query = "SELECT r FROM ResultadoExamenUsuario r WHERE r.resultadoExamenUsuarioId = :resultadoExamenUsuarioId"), 
    @NamedQuery(name = "ResultadoExamenUsuario.findByNroPreguntasArea", query = "SELECT r FROM ResultadoExamenUsuario r WHERE r.nroPreguntasArea = :nroPreguntasArea"), 
    @NamedQuery(name = "ResultadoExamenUsuario.findByRespuestaExamenId", query = "SELECT r FROM ResultadoExamenUsuario r WHERE r.respuestaExamenId = :respuestaExamenId"),
    @NamedQuery(name = "ResultadoExamenUsuario.findByAreaRespuestaExamenIdList", query = "SELECT r FROM ResultadoExamenUsuario r WHERE r.respuestaExamenId IN (:ids) AND r.areaId = :areaId"),
    @NamedQuery(name = "ResultadoExamenUsuario.findByRespuestasCorrectas", query = "SELECT r FROM ResultadoExamenUsuario r WHERE r.respuestasCorrectas = :respuestasCorrectas"), 
    @NamedQuery(name = "ResultadoExamenUsuario.findByRespuestasErradas", query = "SELECT r FROM ResultadoExamenUsuario r WHERE r.respuestasErradas = :respuestasErradas"), 
    @NamedQuery(name = "ResultadoExamenUsuario.findBySinContestar", query = "SELECT r FROM ResultadoExamenUsuario r WHERE r.sinContestar = :sinContestar")})
public class ResultadoExamenUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resultado_examen_usuario_id")
    private Integer resultadoExamenUsuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_preguntas_area")
    private int nroPreguntasArea;
    @Column(name = "respuestas_correctas")
    private Integer respuestasCorrectas;
    @Column(name = "respuestas_erradas")
    private Integer respuestasErradas;
    @Column(name = "sin_contestar")
    private Integer sinContestar;
    @Column(name = "porcentaje_acierto")
    private Double porcentajeAcierto;
    @Column(name = "promedio_area")
    private Double promedioArea;
    @JoinColumn(name = "archivo_prueba_id", referencedColumnName = "archivo_prueba_id")
    @ManyToOne(optional = false)
    private ArchivoPrueba archivoPruebaId;
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    @ManyToOne(optional = false)
    private Area areaId;
    @JoinColumn(name = "respuesta_examen_id", referencedColumnName = "respuesta_examen_id")
    @ManyToOne(optional = false)
    private RespuestaExamen respuestaExamenId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public ResultadoExamenUsuario() {
    }

    public ResultadoExamenUsuario(Integer resultadoExamenUsuarioId) {
        this.resultadoExamenUsuarioId = resultadoExamenUsuarioId;
    }

    public ResultadoExamenUsuario(Integer resultadoExamenUsuarioId, int nroPreguntasArea) {
        this.resultadoExamenUsuarioId = resultadoExamenUsuarioId;
        this.nroPreguntasArea = nroPreguntasArea;
    }

    public Integer getResultadoExamenUsuarioId() {
        return resultadoExamenUsuarioId;
    }

    public void setResultadoExamenUsuarioId(Integer resultadoExamenUsuarioId) {
        this.resultadoExamenUsuarioId = resultadoExamenUsuarioId;
    }

    public int getNroPreguntasArea() {
        return nroPreguntasArea;
    }

    public void setNroPreguntasArea(int nroPreguntasArea) {
        this.nroPreguntasArea = nroPreguntasArea;
    }

    public Integer getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public void setRespuestasCorrectas(Integer respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }

    public Integer getRespuestasErradas() {
        return respuestasErradas;
    }

    public void setRespuestasErradas(Integer respuestasErradas) {
        this.respuestasErradas = respuestasErradas;
    }

    public Integer getSinContestar() {
        return sinContestar;
    }

    public void setSinContestar(Integer sinContestar) {
        this.sinContestar = sinContestar;
    }

    public ArchivoPrueba getArchivoPruebaId() {
        return archivoPruebaId;
    }

    public void setArchivoPruebaId(ArchivoPrueba archivoPruebaId) {
        this.archivoPruebaId = archivoPruebaId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Double getPorcentajeAcierto() {
		return porcentajeAcierto;
	}

	public void setPorcentajeAcierto(Double porcentajeAcierto) {
		this.porcentajeAcierto = porcentajeAcierto;
	}

	public Double getPromedioArea() {
		return promedioArea;
	}

	public void setPromedioArea(Double promedioArea) {
		this.promedioArea = promedioArea;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (resultadoExamenUsuarioId != null ? resultadoExamenUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoExamenUsuario)) {
            return false;
        }
        ResultadoExamenUsuario other = (ResultadoExamenUsuario) object;
        if ((this.resultadoExamenUsuarioId == null && other.resultadoExamenUsuarioId != null) || (this.resultadoExamenUsuarioId != null && !this.resultadoExamenUsuarioId.equals(other.resultadoExamenUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.ResultadoExamenUsuario[ resultadoExamenUsuarioId=" + resultadoExamenUsuarioId + " ]";
    }
    
}
