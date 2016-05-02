package co.com.core.commons;

import java.io.Serializable;

import co.com.core.dto.IBaseDTO;

public class ColumnModel implements Serializable {
	
	 private String header;  
     private String property;  
     private IBaseDTO dataObject;

     public ColumnModel(String header, String property) {  
         this.header = header;  
         this.property = property;  
     }  

     public String getHeader() {  
         return header;  
     }  

     public String getProperty() {  
         return property;  
     }

	public IBaseDTO getDataObject() {
		return dataObject;
	}

	public void setDataObject(IBaseDTO dataObject) {
		this.dataObject = dataObject;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public ColumnModel(String header, String property, IBaseDTO dataObject) {
		super();
		this.header = header;
		this.property = property;
		this.dataObject = dataObject;
	}  
     
     
}
