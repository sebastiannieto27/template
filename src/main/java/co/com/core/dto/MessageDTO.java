package co.com.core.dto;

import java.sql.Timestamp;
import java.util.Date;

import co.com.core.domain.MessageStatus;
import co.com.core.domain.Priority;
import co.com.core.domain.User;

public class MessageDTO implements IBaseDTO {

	private Integer messageId;
    private String title;
    private String body;
    private Timestamp date;
    private User senderId;
    private User receiverId;
    private Priority priorityId;
    private MessageStatus messageStatusId;
    
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public User getSenderId() {
		return senderId;
	}
	public void setSenderId(User senderId) {
		this.senderId = senderId;
	}
	public User getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(User receiverId) {
		this.receiverId = receiverId;
	}
	public Priority getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(Priority priorityId) {
		this.priorityId = priorityId;
	}
	public MessageStatus getMessageStatusId() {
		return messageStatusId;
	}
	public void setMessageStatusId(MessageStatus messageStatusId) {
		this.messageStatusId = messageStatusId;
	}
	
	@Override
	public String toString() {
		return "MessageDTO [messageId=" + messageId + ", title=" + title
				+ ", body=" + body + ", date=" + date + "]";
	}
}
