package co.com.core.dto.psaber;

import co.com.core.domain.psaber.Pregunta;

public class RespuestaDTO {
    private Integer respuesta;
    private String codigo;
    private String descripcion;
    private Boolean verdadera;
    private Pregunta preguntaId;
    private String letra;
    
	public Integer getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Integer respuesta) {
		this.respuesta = respuesta;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getVerdadera() {
		return verdadera;
	}
	public void setVerdadera(Boolean verdadera) {
		this.verdadera = verdadera;
	}
	public Pregunta getPreguntaId() {
		return preguntaId;
	}
	public void setPreguntaId(Pregunta preguntaId) {
		this.preguntaId = preguntaId;
	}
	
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	@Override
	public String toString() {
		return "RespuestaDTO [respuesta=" + respuesta + ", codigo=" + codigo + ", descripcion=" + descripcion
				+ ", verdadera=" + verdadera + ", preguntaId=" + preguntaId + "]";
	}
}
