package co.com.core.dto;


public class MessageStatusDTO implements IBaseDTO {
	private Integer messageStatusId;
    private String name;
    
	public Integer getMessageStatusId() {
		return messageStatusId;
	}
	public void setMessageStatusId(Integer messageStatusId) {
		this.messageStatusId = messageStatusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MessageStatusDTO [messageStatusId=" + messageStatusId
				+ ", name=" + name + "]";
	}
    
    
}
