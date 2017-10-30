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
@Table(name = "area_archivo_prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaArchivoPrueba.findAll", query = "SELECT a FROM AreaArchivoPrueba a"), 
    @NamedQuery(name = "AreaArchivoPrueba.findByArchivoPruebaId", query = "SELECT a FROM AreaArchivoPrueba a WHERE a.archivoPruebaId = :archivoPruebaId"),
    @NamedQuery(name = "AreaArchivoPrueba.findByAreaArchivoPruebaId", query = "SELECT a FROM AreaArchivoPrueba a WHERE a.areaArchivoPruebaId = :areaArchivoPruebaId")})
public class AreaArchivoPrueba implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "area_archivo_prueba_id")
    private Integer areaArchivoPruebaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_columna")
    private int nroColumna;
    @JoinColumn(name = "archivo_prueba_id", referencedColumnName = "archivo_prueba_id")
    @ManyToOne(optional = false)
    private ArchivoPrueba archivoPruebaId;
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    @ManyToOne(optional = false)
    private Area areaId;

    public AreaArchivoPrueba() {
    }

    public AreaArchivoPrueba(Integer areaArchivoPruebaId) {
        this.areaArchivoPruebaId = areaArchivoPruebaId;
    }

    public AreaArchivoPrueba(Integer areaArchivoPruebaId, int nroColumna) {
        this.areaArchivoPruebaId = areaArchivoPruebaId;
        this.nroColumna = nroColumna;
    }

    public Integer getAreaArchivoPruebaId() {
        return areaArchivoPruebaId;
    }

    public void setAreaArchivoPruebaId(Integer areaArchivoPruebaId) {
        this.areaArchivoPruebaId = areaArchivoPruebaId;
    }

    public int getNroColumna() {
        return nroColumna;
    }

    public void setNroColumna(int nroColumna) {
        this.nroColumna = nroColumna;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaArchivoPruebaId != null ? areaArchivoPruebaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaArchivoPrueba)) {
            return false;
        }
        AreaArchivoPrueba other = (AreaArchivoPrueba) object;
        if ((this.areaArchivoPruebaId == null && other.areaArchivoPruebaId != null) || (this.areaArchivoPruebaId != null && !this.areaArchivoPruebaId.equals(other.areaArchivoPruebaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.AreaArchivoPrueba[ areaArchivoPruebaId=" + areaArchivoPruebaId + " ]";
    }
    
}
