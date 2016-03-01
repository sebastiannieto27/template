package co.com.core.dto;

import co.com.core.domain.Menu;
import co.com.core.domain.Role;

public class RoleMenuDTO implements IBaseDTO {
	private Integer roleMenuId;
	private Menu menuId;
	private Role roleId;

	public Integer getRoleMenuId() {
		return roleMenuId;
	}

	public void setRoleMenuId(Integer roleMenuId) {
		this.roleMenuId = roleMenuId;
	}

	public Menu getMenuId() {
		return menuId;
	}

	public void setMenuId(Menu menuId) {
		this.menuId = menuId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "RoleMenuDTO [roleMenuId=" + roleMenuId + ", menuId=" + menuId
				+ ", roleId=" + roleId + "]";
	}

}
