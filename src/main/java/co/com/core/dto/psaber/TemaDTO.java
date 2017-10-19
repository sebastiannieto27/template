package co.com.core.dto.psaber;

import co.com.core.domain.psaber.Pregunta;

public class TemaDTO {

    private Integer temaId;
    private String nombre;
    private String descripcion;
    private Pregunta preguntaId;
	public Integer getTemaId() {
		return temaId;
	}
	public void setTemaId(Integer temaId) {
		this.temaId = temaId;
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
		return "TemaDTO [temaId=" + temaId + ", nombre=" + nombre + ", descripcion=" + descripcion + ", preguntaId="
				+ preguntaId + "]";
	}
}
