package co.com.core.dto.psaber;

import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.Area;

public class AreaArchivoPruebaDTO {

    private Integer areaArchivoPruebaId;
    private ArchivoPrueba archivoPruebaId;
    private Area areaId;
    private int nroColumna;
    
	public Integer getAreaArchivoPruebaId() {
		return areaArchivoPruebaId;
	}
	public void setAreaArchivoPruebaId(Integer areaArchivoPruebaId) {
		this.areaArchivoPruebaId = areaArchivoPruebaId;
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
	
	public int getNroColumna() {
		return nroColumna;
	}
	public void setNroColumna(int nroColumna) {
		this.nroColumna = nroColumna;
	}
	@Override
	public String toString() {
		return "AreaArchivoPruebaDTO [areaArchivoPruebaId=" + areaArchivoPruebaId + ", archivoPruebaId="
				+ archivoPruebaId + ", areaId=" + areaId + ", nroColumna=" + nroColumna + "]";
	}
}
