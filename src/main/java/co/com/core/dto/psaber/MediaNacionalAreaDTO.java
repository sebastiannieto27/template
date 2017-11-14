package co.com.core.dto.psaber;

import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.Area;

public class MediaNacionalAreaDTO {
    private Integer mediaNacionalAreaId;
    private double valor;
    private ArchivoPrueba archivoPruebaId;
    private Area areaId;
	public Integer getMediaNacionalAreaId() {
		return mediaNacionalAreaId;
	}
	public void setMediaNacionalAreaId(Integer mediaNacionalAreaId) {
		this.mediaNacionalAreaId = mediaNacionalAreaId;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public ArchivoPrueba getArchivoPruebaId() {
		return archivoPruebaId;
	}
	public void setArchivoPruebaId(ArchivoPrueba archivoPruebaId) {
		this.archivoPruebaId = archivoPruebaId;
	}
	public Area getAreaId() {
		return areaId;
	}
	public void setAreaId(Area areaId) {
		this.areaId = areaId;
	}
	@Override
	public String toString() {
		return "MediaNacionalAreaDTO [mediaNacionalAreaId=" + mediaNacionalAreaId + ", valor=" + valor
				+ ", archivoPruebaId=" + archivoPruebaId + ", areaId=" + areaId + "]";
	}
}
