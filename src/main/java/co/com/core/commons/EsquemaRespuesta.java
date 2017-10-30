package co.com.core.commons;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EsquemaRespuesta {
	@SerializedName("areaId")
	@Expose
	private Integer areaId;
	@SerializedName("nroColumna")
	@Expose
	private Integer nroColumna;
	@SerializedName("nombreArea")
	@Expose
	private String nombreArea;
	@SerializedName("item")
	@Expose
	private List<ItemRespuesta> item = null;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public List<ItemRespuesta> getItem() {
		return item;
	}

	public void setItem(List<ItemRespuesta> item) {
		this.item = item;
	}

	public Integer getNroColumna() {
		return nroColumna;
	}

	public void setNroColumna(Integer nroColumna) {
		this.nroColumna = nroColumna;
	}

	@Override
	public String toString() {
		return "EsquemaRespuesta [areaId=" + areaId + ", nroColumna=" + nroColumna + ", nombreArea=" + nombreArea
				+ ", item=" + item + "]";
	}

}
