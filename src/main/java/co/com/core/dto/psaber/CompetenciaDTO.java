package co.com.core.dto.psaber;

import co.com.core.domain.psaber.Contenido;

public class CompetenciaDTO {

	private Integer competenciaId;
	private String nombre;
	private String descripcion;
	private Contenido contenidoId;
	
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
	
	public Contenido getContenidoId() {
		return contenidoId;
	}
	
	public void setContenidoId(Contenido contenidoId) {
		this.contenidoId = contenidoId;
	}

	@Override
	public String toString() {
		return "CompetenciaDTO [competenciaId=" + competenciaId + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", contenidoId=" + contenidoId + "]";
	}
}
