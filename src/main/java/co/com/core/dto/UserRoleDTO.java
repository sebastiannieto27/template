package co.com.core.dto;

import co.com.core.domain.Role;
import co.com.core.domain.User;

public class UserRoleDTO implements IBaseDTO {

    private Integer userRoleId;
    private Role roleId;
    private User userId;
    
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Role getRoleId() {
		return roleId;
	}
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "UserRoleDTO [userRoleId=" + userRoleId + ", roleId=" + roleId
				+ ", userId=" + userId + "]";
	}
    
    
}
