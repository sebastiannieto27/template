package co.com.core.dto.psaber;

import java.text.DecimalFormat;

import co.com.core.domain.User;
import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.RespuestaExamen;

public class ResultadoExamenUsuarioDTO implements Comparable<ResultadoExamenUsuarioDTO>{

	private Integer resultadoExamenUsuarioId;
    private int nroPreguntasArea;
    private Integer respuestasCorrectas;
    private Integer respuestasErradas;
    private Integer sinContestar;
    private ArchivoPrueba archivoPruebaId;
    private Area areaId;
    private RespuestaExamen respuestaExamenId;
    private User userId;
    private double  porcentajeAcierto;
    private double promedioArea;
    
	public Integer getResultadoExamenUsuarioId() {
		return resultadoExamenUsuarioId;
	}
	public void setResultadoExamenUsuarioId(Integer resultadoExamenUsuarioId) {
		this.resultadoExamenUsuarioId = resultadoExamenUsuarioId;
	}
	public int getNroPreguntasArea() {
		return nroPreguntasArea;
	}
	public void setNroPreguntasArea(int nroPreguntasArea) {
		this.nroPreguntasArea = nroPreguntasArea;
	}
	public Integer getRespuestasCorrectas() {
		return respuestasCorrectas;
	}
	public void setRespuestasCorrectas(Integer respuestasCorrectas) {
		this.respuestasCorrectas = respuestasCorrectas;
	}
	public Integer getRespuestasErradas() {
		return respuestasErradas;
	}
	public void setRespuestasErradas(Integer respuestasErradas) {
		this.respuestasErradas = respuestasErradas;
	}
	public Integer getSinContestar() {
		return sinContestar;
	}
	public void setSinContestar(Integer sinContestar) {
		this.sinContestar = sinContestar;
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
	public RespuestaExamen getRespuestaExamenId() {
		return respuestaExamenId;
	}
	public void setRespuestaExamenId(RespuestaExamen respuestaExamenId) {
		this.respuestaExamenId = respuestaExamenId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public double getPorcentajeAcierto() {
		return roundDouble(porcentajeAcierto);
	}
	public void setPorcentajeAcierto(double porcentajeAcierto) {
		this.porcentajeAcierto = porcentajeAcierto;
	}
	
	public double getPromedioArea() {
		return promedioArea;
	}
	public void setPromedioArea(double promedioArea) {
		this.promedioArea = promedioArea;
	}
	@Override
	public String toString() {
		return "ResultadoExamenUsuarioDTO [resultadoExamenUsuarioId=" + resultadoExamenUsuarioId + ", nroPreguntasArea="
				+ nroPreguntasArea + ", respuestasCorrectas=" + respuestasCorrectas + ", respuestasErradas="
				+ respuestasErradas + ", sinContestar=" + sinContestar + ", archivoPruebaId=" + archivoPruebaId
				+ ", areaId=" + areaId + ", respuestaExamenId=" + respuestaExamenId + ", userId=" + "userId"
				+ ", porcentajeAcierto=" + porcentajeAcierto + ", promedioArea=" + promedioArea + "]";
	}
	
	@Override
	public int compareTo(ResultadoExamenUsuarioDTO obj) {
		return (int) (obj.getPorcentajeAcierto() - this.porcentajeAcierto);
	}
	
	public static double roundDouble(double val) {
		val = val*100;
		val = (double)((int) val);
		val = val /100; 
	    
	    return val;
	}
}
