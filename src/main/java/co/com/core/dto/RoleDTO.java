package co.com.core.dto;


public class RoleDTO implements IBaseDTO {

	private Integer roleId;
    private String roleName;
    private String description;
    
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "RoleDTO [roleId=" + roleId + ", roleName=" + roleName
				+ ", description=" + description + "]";
	}
    
    
}
