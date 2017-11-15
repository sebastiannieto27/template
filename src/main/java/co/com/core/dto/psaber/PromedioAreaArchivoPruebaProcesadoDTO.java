package co.com.core.dto.psaber;

import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.RespuestaExamen;

public class PromedioAreaArchivoPruebaProcesadoDTO {
	private Integer promedioAreaArchivoPruebaProcesadoId;
    private double valor;
    private Area areaId;
    private ArchivoPruebaProcesado archivoPruebaProcesadoId;

	public Integer getPromedioAreaArchivoPruebaProcesadoId() {
		return promedioAreaArchivoPruebaProcesadoId;
	}
	public void setPromedioAreaArchivoPruebaProcesadoId(Integer promedioAreaArchivoPruebaProcesadoId) {
		this.promedioAreaArchivoPruebaProcesadoId = promedioAreaArchivoPruebaProcesadoId;
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
	public ArchivoPruebaProcesado getArchivoPruebaProcesadoId() {
		return archivoPruebaProcesadoId;
	}
	public void setArchivoPruebaProcesadoId(ArchivoPruebaProcesado archivoPruebaProcesadoId) {
		this.archivoPruebaProcesadoId = archivoPruebaProcesadoId;
	}
	@Override
	public String toString() {
		return "PromedioAreaArchivoPruebaProcesadoDTO [promedioAreaArchivoPruebaProcesadoId=" + promedioAreaArchivoPruebaProcesadoId
				+ ", valor=" + valor + ", areaId=" + areaId + ", archivoPruebaProcesadoId=" + archivoPruebaProcesadoId
				+ "]";
	}
}
