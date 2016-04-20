package co.com.core.dto.cms;


public class BranchTypeDTO {
	
	private Integer branchTypeId;
    private String branchTypeName;
    
	public Integer getBranchTypeId() {
		return branchTypeId;
	}
	public void setBranchTypeId(Integer branchTypeId) {
		this.branchTypeId = branchTypeId;
	}
	public String getBranchTypeName() {
		return branchTypeName;
	}
	public void setBranchTypeName(String branchTypeName) {
		this.branchTypeName = branchTypeName;
	}
	
	@Override
	public String toString() {
		return "BranchTypeDTO [branchTypeId=" + branchTypeId
				+ ", branchTypeName=" + branchTypeName + "]";
	}
}
