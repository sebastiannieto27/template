package co.com.core.dto;

import co.com.core.domain.Permission;
import co.com.core.domain.Role;

public class RolePermissionDTO {
	private Integer rolePermissionId;
    private Permission permissionId;
    private Role roleId;
	public Integer getRolePermissionId() {
		return rolePermissionId;
	}
	public void setRolePermissionId(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}
	public Permission getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Permission permissionId) {
		this.permissionId = permissionId;
	}
	public Role getRoleId() {
		return roleId;
	}
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "RolePermissionDTO [rolePermissionId=" + rolePermissionId
				+ ", permissionId=" + permissionId + ", roleId=" + roleId + "]";
	}
}
