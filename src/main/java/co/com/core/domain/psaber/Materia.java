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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByMateriaId", query = "SELECT m FROM Materia m WHERE m.materiaId = :materiaId")
    , @NamedQuery(name = "Materia.findByNombre", query = "SELECT m FROM Materia m WHERE m.nombre = :nombre")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "materia_id")
    private Integer materiaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaId")
    private Collection<Contenido> contenidoCollection;
    @JoinColumn(name = "componente_id", referencedColumnName = "componente_id")
    @ManyToOne(optional = false)
    private Componente componenteId;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaId")
    private Collection<Pregunta> preguntaCollection;*/

    public Materia() {
    }

    public Materia(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public Materia(Integer materiaId, String nombre) {
        this.materiaId = materiaId;
        this.nombre = nombre;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
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

    @XmlTransient
    public Collection<Contenido> getContenidoCollection() {
        return contenidoCollection;
    }

    public void setContenidoCollection(Collection<Contenido> contenidoCollection) {
        this.contenidoCollection = contenidoCollection;
    }

    public Componente getComponenteId() {
        return componenteId;
    }

    public void setComponenteId(Componente componenteId) {
        this.componenteId = componenteId;
    }

    /*@XmlTransient
    public Collection<Pregunta> getPreguntaCollection() {
        return preguntaCollection;
    }

    public void setPreguntaCollection(Collection<Pregunta> preguntaCollection) {
        this.preguntaCollection = preguntaCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaId != null ? materiaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.materiaId == null && other.materiaId != null) || (this.materiaId != null && !this.materiaId.equals(other.materiaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.domain.Materia[ materiaId=" + materiaId + " ]";
    }
    
}
