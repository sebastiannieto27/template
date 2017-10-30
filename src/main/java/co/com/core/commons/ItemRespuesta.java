package co.com.core.commons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemRespuesta {

	@SerializedName("pregunta")
	@Expose
	private String pregunta;
	@SerializedName("respuesta")
	@Expose
	private String respuesta;

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	@Override
	public String toString() {
		return "ItemRespuesta [pregunta=" + pregunta + ", respuesta=" + respuesta + "]";
	}
}
