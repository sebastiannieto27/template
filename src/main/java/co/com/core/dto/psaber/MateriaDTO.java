package co.com.core.dto.psaber;

import co.com.core.domain.psaber.Componente;

public class MateriaDTO {

	private Integer materiaId;
    private String nombre;
    private String descripcion;
    private Componente componenteId;
    
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
	
	public Componente getComponenteId() {
		return componenteId;
	}
	
	public void setComponenteId(Componente componenteId) {
		this.componenteId = componenteId;
	}

	@Override
	public String toString() {
		return "MateriaDTO [materiaId=" + materiaId + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", componenteId=" + componenteId + "]";
	}
}
