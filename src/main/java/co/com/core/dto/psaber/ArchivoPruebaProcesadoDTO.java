package co.com.core.dto.psaber;

import java.util.Date;

import co.com.core.domain.psaber.ArchivoPrueba;

public class ArchivoPruebaProcesadoDTO {

    private Integer archivoPruebaProcesadoId;
    private Date fecCre;
    private String nombreArchivo;
    private ArchivoPrueba archivoPruebaId;
    
	public Integer getArchivoPruebaProcesadoId() {
		return archivoPruebaProcesadoId;
	}
	public void setArchivoPruebaProcesadoId(Integer archivoPruebaProcesadoId) {
		this.archivoPruebaProcesadoId = archivoPruebaProcesadoId;
	}
	public Date getFecCre() {
		return fecCre;
	}
	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public ArchivoPrueba getArchivoPruebaId() {
		return archivoPruebaId;
	}
	public void setArchivoPruebaId(ArchivoPrueba archivoPruebaId) {
		this.archivoPruebaId = archivoPruebaId;
	}
	@Override
	public String toString() {
		return "ArchivoPruebaProcesadoDTO [archivoPruebaProcesadoId=" + archivoPruebaProcesadoId + ", fecCre=" + fecCre
				+ ", nombreArchivo=" + nombreArchivo + ", archivoPruebaId=" + archivoPruebaId + "]";
	}
}
