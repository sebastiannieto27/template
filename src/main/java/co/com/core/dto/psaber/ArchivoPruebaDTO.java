package co.com.core.dto.psaber;

public class ArchivoPruebaDTO {

    private Integer archivoPruebaId;
    private String nombre;
    private int nroColumnas;
    private String nroPreguntas;
    
	public Integer getArchivoPruebaId() {
		return archivoPruebaId;
	}
	public void setArchivoPruebaId(Integer archivoPruebaId) {
		this.archivoPruebaId = archivoPruebaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNroColumnas() {
		return nroColumnas;
	}
	public void setNroColumnas(int nroColumnas) {
		this.nroColumnas = nroColumnas;
	}
	public String getNroPreguntas() {
		return nroPreguntas;
	}
	public void setNroPreguntas(String nroPreguntas) {
		this.nroPreguntas = nroPreguntas;
	}
	@Override
	public String toString() {
		return "ArchivoPruebaDTO [archivoPruebaId=" + archivoPruebaId + ", nombre=" + nombre + ", nroColumnas="
				+ nroColumnas + ", nroPreguntas=" + nroPreguntas + "]";
	}
}
