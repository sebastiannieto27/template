package co.com.core.dto.psaber;

import co.com.core.domain.User;
import co.com.core.domain.psaber.ArchivoPruebaProcesado;

public class RespuestaExamenDTO {

    private Integer respuestaExamenId;
    private String respuesta;
    private ArchivoPruebaProcesado archivoPruebaProcesadoId;
    private User userId;
    private Short procesado;
    
	public Integer getRespuestaExamenId() {
		return respuestaExamenId;
	}
	public void setRespuestaExamenId(Integer respuestaExamenId) {
		this.respuestaExamenId = respuestaExamenId;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public ArchivoPruebaProcesado getArchivoPruebaProcesadoId() {
		return archivoPruebaProcesadoId;
	}
	public void setArchivoPruebaProcesadoId(ArchivoPruebaProcesado archivoPruebaProcesadoId) {
		this.archivoPruebaProcesadoId = archivoPruebaProcesadoId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public Short getProcesado() {
		return procesado;
	}
	public void setProcesado(Short procesado) {
		this.procesado = procesado;
	}
	@Override
	public String toString() {
		return "RespuestaExamenDTO [respuestaExamenId=" + respuestaExamenId + ", respuesta=" + respuesta
				+ ", archivoPruebaProcesadoId=" + archivoPruebaProcesadoId + ", userId=" + "null" + ", procesado="
				+ procesado + "]";
	}
}
