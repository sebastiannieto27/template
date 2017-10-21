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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego.nieto
 */
@Entity
@Table(name = "competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencia.findAll", query = "SELECT c FROM Competencia c")
    , @NamedQuery(name = "Competencia.findByCompetenciaId", query = "SELECT c FROM Competencia c WHERE c.competenciaId = :competenciaId")
    , @NamedQuery(name = "Competencia.findByNombre", query = "SELECT c FROM Competencia c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Competencia.findByCodigo", query = "SELECT c FROM Competencia c WHERE c.codigo = :codigo")})
public class Competencia implements Serializable {

    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    @ManyToOne(optional = false)
    private Area areaId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "competencia_id")
    private Integer competenciaId;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competenciaId")
    private Collection<PreguntaCompetencia> preguntaCompetenciaCollection;

    public Competencia() {
    }

    public Competencia(Integer competenciaId) {
        this.competenciaId = competenciaId;
    }

    public Integer getCompetenciaId() {
        return competenciaId;
    }

    public void setCompetenciaId(Integer competenciaId) {
        this.competenciaId = competenciaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<PreguntaCompetencia> getPreguntaCompetenciaCollection() {
        return preguntaCompetenciaCollection;
    }

    public void setPreguntaCompetenciaCollection(Collection<PreguntaCompetencia> preguntaCompetenciaCollection) {
        this.preguntaCompetenciaCollection = preguntaCompetenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenciaId != null ? competenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencia)) {
            return false;
        }
        Competencia other = (Competencia) object;
        if ((this.competenciaId == null && other.competenciaId != null) || (this.competenciaId != null && !this.competenciaId.equals(other.competenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.core.domain.psaber.Competencia[ competenciaId=" + competenciaId + " ]";
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }
    
}
