package co.com.core.commons;

import java.io.Serializable;

public class Message implements Serializable {
	private String subject;  
    private String text;  
    private long time;  
    private String textLength;  
    private String country;  
    private String deliveryStatus;  

    public Message() {  
        time = System.currentTimeMillis() + (long) (Math.random() * 10);  
        textLength = Math.random() * 10 + "";  
    }  

    public final String getSubject() {  
        return subject;  
    }  

    public final void setSubject(String subject) {  
        this.subject = subject;  
    }  

    public final String getText() {  
        return text;  
    }  

    public final void setText(String text) {  
        this.text = text;  
    }  

    public long getTime() {  
        return time;  
    }  

    public void setTime(long time) {  
        this.time = time;  
    }  

    public String getTextLength() {  
        return textLength;  
    }  

    public void setTextLength(String textLength) {  
        this.textLength = textLength;  
    }  

    public String getCountry() {  
        return country;  
    }  

    public void setCountry(String country) {  
        this.country = country;  
    }  

    public String getDeliveryStatus() {  
        return deliveryStatus;  
    }  

    public void setDeliveryStatus(String deliveryStatus) {  
        this.deliveryStatus = deliveryStatus;  
    }  
}
