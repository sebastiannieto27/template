package co.com.core.dto.psaber;

import co.com.core.domain.psaber.Contenido;
import co.com.core.domain.psaber.Pregunta;

public class CompetenciaDTO {

	private Integer competenciaId;
	private String nombre;
	private String descripcion;
	private Pregunta preguntaId;
	
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

	public Pregunta getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(Pregunta preguntaId) {
		this.preguntaId = preguntaId;
	}

	@Override
	public String toString() {
		return "CompetenciaDTO [competenciaId=" + competenciaId + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", preguntaId=" + preguntaId + "]";
	}
	

}
