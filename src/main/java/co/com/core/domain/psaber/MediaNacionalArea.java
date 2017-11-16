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
@Table(name = "media_nacional_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MediaNacionalArea.findAll", query = "SELECT m FROM MediaNacionalArea m")
    , @NamedQuery(name = "MediaNacionalArea.findByMediaNacionalAreaId", query = "SELECT m FROM MediaNacionalArea m WHERE m.mediaNacionalAreaId = :mediaNacionalAreaId")
    , @NamedQuery(name = "MediaNacionalArea.findByArchivoPruebaId", query = "SELECT m FROM MediaNacionalArea m WHERE m.archivoPruebaId = :archivoPruebaId")
    , @NamedQuery(name = "MediaNacionalArea.findByValor", query = "SELECT m FROM MediaNacionalArea m WHERE m.valor = :valor")})
public class MediaNacionalArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "media_nacional_area_id")
    private Integer mediaNacionalAreaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "archivo_prueba_id", referencedColumnName = "archivo_prueba_id")
    @ManyToOne(optional = false)
    private ArchivoPrueba archivoPruebaId;
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    @ManyToOne(optional = false)
    private Area areaId;

    public MediaNacionalArea() {
    }

    public MediaNacionalArea(Integer mediaNacionalAreaId) {
        this.mediaNacionalAreaId = mediaNacionalAreaId;
    }

    public MediaNacionalArea(Integer mediaNacionalAreaId, double valor) {
        this.mediaNacionalAreaId = mediaNacionalAreaId;
        this.valor = valor;
    }

    public Integer getMediaNacionalAreaId() {
        return mediaNacionalAreaId;
    }

    public void setMediaNacionalAreaId(Integer mediaNacionalAreaId) {
        this.mediaNacionalAreaId = mediaNacionalAreaId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
        hash += (mediaNacionalAreaId != null ? mediaNacionalAreaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaNacionalArea)) {
            return false;
        }
        MediaNacionalArea other = (MediaNacionalArea) object;
        if ((this.mediaNacionalAreaId == null && other.mediaNacionalAreaId != null) || (this.mediaNacionalAreaId != null && !this.mediaNacionalAreaId.equals(other.mediaNacionalAreaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.MediaNacionalArea[ mediaNacionalAreaId=" + mediaNacionalAreaId + " ]";
    }
    
}
