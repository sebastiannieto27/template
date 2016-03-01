package co.com.core.dto;

import java.util.Date;

import co.com.core.domain.Priority;


public class EventDTO implements IBaseDTO {

	 	private Integer eventId;
	    private String name;
	    private Date startDate;
	    private Date endDate;
	    private Priority priorityId;
	    
		public Integer getEventId() {
			return eventId;
		}
		public void setEventId(Integer eventId) {
			this.eventId = eventId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public Priority getPriorityId() {
			return priorityId;
		}
		public void setPriorityId(Priority priorityId) {
			this.priorityId = priorityId;
		}

	    public String getRowKeyValue() {
	    	return this.eventId + this.name;
	    }
		@Override
		public String toString() {
			return "EventDTO [eventId=" + eventId + ", name=" + name
					+ ", startDate=" + startDate + ", endDate=" + endDate
					+ ", priorityId=" + priorityId + "]";
		}
	    
}
