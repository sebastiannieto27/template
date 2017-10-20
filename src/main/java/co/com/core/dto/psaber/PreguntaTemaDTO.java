package co.com.core.dto.psaber;

import co.com.core.domain.psaber.Pregunta;
import co.com.core.domain.psaber.Tema;

public class PreguntaTemaDTO {

    private Integer preguntaTemaId;
    private Pregunta preguntaId;
    private Tema temaId;
	public Integer getPreguntaTemaId() {
		return preguntaTemaId;
	}
	public void setPreguntaTemaId(Integer preguntaTemaId) {
		this.preguntaTemaId = preguntaTemaId;
	}
	public Pregunta getPreguntaId() {
		return preguntaId;
	}
	public void setPreguntaId(Pregunta preguntaId) {
		this.preguntaId = preguntaId;
	}
	public Tema getTemaId() {
		return temaId;
	}
	public void setTemaId(Tema temaId) {
		this.temaId = temaId;
	}
	
	@Override
	public String toString() {
		return "PreguntaTemaDTO [preguntaTemaId=" + preguntaTemaId + ", preguntaId=" + preguntaId + ", temaId=" + temaId
				+ "]";
	}
}
