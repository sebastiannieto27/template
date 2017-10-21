package co.com.core.dto.psaber;

import co.com.core.domain.psaber.Area;

public class CompetenciaDTO {

	private Integer competenciaId;
	private String nombre;
	private String descripcion;
	private String codigo;
	private Area areaId;
	
	public Integer getCompetenciaId() {
		return competenciaId;
	}
	
	public void setCompetenciaId(Integer competenciaId) {
		this.competenciaId = competenciaId;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Area getAreaId() {
		return areaId;
	}

	public void setAreaId(Area areaId) {
		this.areaId = areaId;
	}

	@Override
	public String toString() {
		return "CompetenciaDTO [competenciaId=" + competenciaId + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", codigo=" + codigo + ", areaId=" + areaId + "]";
	}
}
