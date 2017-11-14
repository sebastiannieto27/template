package co.com.core.dto.psaber;

import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.RespuestaExamen;

public class PromedioAreaRespuestaExamenDTO {
	private Integer promedioAreaRespuestaExamenId;
    private double valor;
    private Area areaId;
    private RespuestaExamen respuestaExamenId;
    
	public Integer getPromedioAreaRespuestaExamenId() {
		return promedioAreaRespuestaExamenId;
	}
	public void setPromedioAreaRespuestaExamenId(Integer promedioAreaRespuestaExamenId) {
		this.promedioAreaRespuestaExamenId = promedioAreaRespuestaExamenId;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Area getAreaId() {
		return areaId;
	}
	public void setAreaId(Area areaId) {
		this.areaId = areaId;
	}
	public RespuestaExamen getRespuestaExamenId() {
		return respuestaExamenId;
	}
	public void setRespuestaExamenId(RespuestaExamen respuestaExamenId) {
		this.respuestaExamenId = respuestaExamenId;
	}
	@Override
	public String toString() {
		return "PromedioAreaRespuestaExamenDTO [promedioAreaRespuestaExamenId=" + promedioAreaRespuestaExamenId
				+ ", valor=" + valor + ", areaId=" + areaId + ", respuestaExamenId=" + respuestaExamenId + "]";
	}
    
    
}
