package co.com.core.dto;

import co.com.core.domain.PagePermission;
import co.com.core.domain.Role;

public class RolePermissionDTO implements IBaseDTO {
	private Integer rolePermissionId;
	private PagePermission pagePermissionId;
    private Role roleId;
    
	public Integer getRolePermissionId() {
		return rolePermissionId;
	}
	public void setRolePermissionId(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}
	public PagePermission getPagePermissionId() {
		return pagePermissionId;
	}
	public void setPagePermissionId(PagePermission pagePermissionId) {
		this.pagePermissionId = pagePermissionId;
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
				+ ", pagePermissionId=" + pagePermissionId + ", roleId="
				+ roleId + "]";
	}
}
