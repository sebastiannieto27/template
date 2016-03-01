package co.com.core.dto;

import co.com.core.domain.Page;
import co.com.core.domain.Permission;

public class PagePermissionDTO implements IBaseDTO {

    private Integer idPagePermission;
    private Page pageId;
    private Permission permissionId;
    
	public Integer getIdPagePermission() {
		return idPagePermission;
	}
	public void setIdPagePermission(Integer idPagePermission) {
		this.idPagePermission = idPagePermission;
	}
	public Page getPageId() {
		return pageId;
	}
	public void setPageId(Page pageId) {
		this.pageId = pageId;
	}
	public Permission getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Permission permissionId) {
		this.permissionId = permissionId;
	}
	@Override
	public String toString() {
		return "PagePermissionDTO [idPagePermission=" + idPagePermission
				+ ", pageId=" + pageId + ", permissionId=" + permissionId + "]";
	}
}
