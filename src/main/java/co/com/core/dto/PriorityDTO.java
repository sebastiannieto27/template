package co.com.core.dto;

public class PriorityDTO implements IBaseDTO {

	private Integer priorityId;
	private String name;
	private String color;
	
	public PriorityDTO(Integer priorityId, String name, String color) {
		super();
		this.priorityId = priorityId;
		this.name = name;
		this.color = color;
	}
	public PriorityDTO() {
	}
	
	@Override
	public String toString() {
		return "PriorityDTO [priorityId=" + priorityId + ", name=" + name
				+ ", color=" + color + "]";
	}
	public Integer getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
