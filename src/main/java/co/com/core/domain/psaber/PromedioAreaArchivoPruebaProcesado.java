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
@Table(name = "promedio_area_archivo_prueba_procesado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PromedioAreaArchivoPruebaProcesado.findAll", query = "SELECT p FROM PromedioAreaArchivoPruebaProcesado p")
    , @NamedQuery(name = "PromedioAreaArchivoPruebaProcesado.findByPromedioAreaArchivoPruebaProcesadoId", query = "SELECT p FROM PromedioAreaArchivoPruebaProcesado p WHERE p.promedioAreaArchivoPruebaProcesadoId = :promedioAreaArchivoPruebaProcesadoId")
    , @NamedQuery(name = "PromedioAreaArchivoPruebaProcesado.findByArchivoPruebaProcesadoId", query = "SELECT p FROM PromedioAreaArchivoPruebaProcesado p WHERE p.archivoPruebaProcesadoId = :archivoPruebaProcesadoId")
    , @NamedQuery(name = "PromedioAreaArchivoPruebaProcesado.findByValor", query = "SELECT p FROM PromedioAreaArchivoPruebaProcesado p WHERE p.valor = :valor")})
public class PromedioAreaArchivoPruebaProcesado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "promedio_area_archivo_prueba_procesado_id")
    private Integer promedioAreaArchivoPruebaProcesadoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "archivo_prueba_procesado_id", referencedColumnName = "archivo_prueba_procesado_id")
    @ManyToOne(optional = false)
    private ArchivoPruebaProcesado archivoPruebaProcesadoId;
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    @ManyToOne(optional = false)
    private Area areaId;

    public PromedioAreaArchivoPruebaProcesado() {
    }

    public PromedioAreaArchivoPruebaProcesado(Integer promedioAreaArchivoPruebaProcesadoId) {
        this.promedioAreaArchivoPruebaProcesadoId = promedioAreaArchivoPruebaProcesadoId;
    }

    public PromedioAreaArchivoPruebaProcesado(Integer promedioAreaArchivoPruebaProcesadoId, double valor) {
        this.promedioAreaArchivoPruebaProcesadoId = promedioAreaArchivoPruebaProcesadoId;
        this.valor = valor;
    }

    public Integer getPromedioAreaArchivoPruebaProcesadoId() {
        return promedioAreaArchivoPruebaProcesadoId;
    }

    public void setPromedioAreaArchivoPruebaProcesadoId(Integer promedioAreaArchivoPruebaProcesadoId) {
        this.promedioAreaArchivoPruebaProcesadoId = promedioAreaArchivoPruebaProcesadoId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArchivoPruebaProcesado getArchivoPruebaProcesadoId() {
        return archivoPruebaProcesadoId;
    }

    public void setArchivoPruebaProcesadoId(ArchivoPruebaProcesado archivoPruebaProcesadoId) {
        this.archivoPruebaProcesadoId = archivoPruebaProcesadoId;
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promedioAreaArchivoPruebaProcesadoId != null ? promedioAreaArchivoPruebaProcesadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromedioAreaArchivoPruebaProcesado)) {
            return false;
        }
        PromedioAreaArchivoPruebaProcesado other = (PromedioAreaArchivoPruebaProcesado) object;
        if ((this.promedioAreaArchivoPruebaProcesadoId == null && other.promedioAreaArchivoPruebaProcesadoId != null) || (this.promedioAreaArchivoPruebaProcesadoId != null && !this.promedioAreaArchivoPruebaProcesadoId.equals(other.promedioAreaArchivoPruebaProcesadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.PromedioAreaArchivoPruebaProcesado[ promedioAreaArchivoPruebaProcesadoId=" + promedioAreaArchivoPruebaProcesadoId + " ]";
    }
    
}
