package co.com.core.dto.psaber;

public class TemaDTO {

    private Integer temaId;
    private String nombre;
    private String descripcion;

    public Integer getTemaId() {
		return temaId;
	}
	public void setTemaId(Integer temaId) {
		this.temaId = temaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TemaDTO [temaId=" + temaId + ", nombre=" + nombre + ", descripcion=" + descripcion;
	}
}
