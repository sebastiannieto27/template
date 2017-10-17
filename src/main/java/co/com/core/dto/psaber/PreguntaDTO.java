package co.com.core.dto.psaber;

public class PreguntaDTO {

    private Integer preguntaId;
    private String descripcion;
    private String codigo;
    private String titulo;
    
	public Integer getPreguntaId() {
		return preguntaId;
	}
	public void setPreguntaId(Integer preguntaId) {
		this.preguntaId = preguntaId;
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "PreguntaDTO [preguntaId=" + preguntaId + ", descripcion=" + descripcion + ", codigo=" + codigo
				+ ", titulo=" + titulo + "]";
	}
    
    
}
