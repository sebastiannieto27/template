package co.com.core.dto;



public class PermissionDTO implements IBaseDTO {

	private Integer permissionId;
    private String permissionName;
    private String code;
    
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	@Override
	public String toString() {
		return "PermissionDTO [permissionId=" + permissionId
				+ ", permissionName=" + permissionName + "]";
	}
}
