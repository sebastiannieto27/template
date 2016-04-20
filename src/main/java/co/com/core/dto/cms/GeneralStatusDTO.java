package co.com.core.dto.cms;





public class GeneralStatusDTO {
	
    private Integer generalStatusId;
    private String generalStatusName;
    
	public Integer getGeneralStatusId() {
		return generalStatusId;
	}
	public void setGeneralStatusId(Integer generalStatusId) {
		this.generalStatusId = generalStatusId;
	}
	public String getGeneralStatusName() {
		return generalStatusName;
	}
	public void setGeneralStatusName(String generalStatusName) {
		this.generalStatusName = generalStatusName;
	}
	@Override
	public String toString() {
		return "GeneralStatusDTO [generalStatus=" + generalStatusId
				+ ", generalStatusName=" + generalStatusName + "]";
	}
	

    
}
