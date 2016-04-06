package co.com.core.dto.cms;




public class GeneralStatusDTO {
	
	private Integer generalStatus;
    private String generalStatusName;
    
	public Integer getGeneralStatus() {
		return generalStatus;
	}
	public void setGeneralStatus(Integer generalStatus) {
		this.generalStatus = generalStatus;
	}
	public String getGeneralStatusName() {
		return generalStatusName;
	}
	public void setGeneralStatusName(String generalStatusName) {
		this.generalStatusName = generalStatusName;
	}
	@Override
	public String toString() {
		return "GeneralStatusDTO [generalStatus=" + generalStatus
				+ ", generalStatusName=" + generalStatusName + "]";
	}
	

    
}
