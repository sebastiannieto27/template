package co.com.core.dto.psaber;

public class AreaDTO {

    private Integer areaId;
    private String nombre;
    private String codigo;
    private String descripcion;
    
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "ArearDTO [areaId=" + areaId + ", nombre=" + nombre + ", codigo=" + codigo + ", descripcion="
				+ descripcion + "]";
	}
}
