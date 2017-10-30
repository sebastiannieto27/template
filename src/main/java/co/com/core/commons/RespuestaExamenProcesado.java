package co.com.core.commons;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RespuestaExamenProcesado {

	@SerializedName("respuestaExamen")
	@Expose
	private List<EsquemaRespuesta> respuestaExamen = null;

	public List<EsquemaRespuesta> getRespuestaExamen() {
		return respuestaExamen;
	}

	public void setRespuestaExamen(List<EsquemaRespuesta> respuestaExamen) {
		this.respuestaExamen = respuestaExamen;
	}

	@Override
	public String toString() {
		return "RespuestaExamen [respuestaExamen=" + respuestaExamen + "]";
	}
	
	
}
