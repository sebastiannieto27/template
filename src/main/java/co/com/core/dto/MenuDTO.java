package co.com.core.dto;

import co.com.core.domain.Menu;
import co.com.core.domain.Page;


public class MenuDTO implements IBaseDTO {

	private Integer menuId;
	private String menuName;
	private Boolean submenu;
	private Boolean general;
	private Menu parentMenuId;
	private Page pageId;
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Boolean getSubmenu() {
		return submenu;
	}
	public void setSubmenu(Boolean submenu) {
		this.submenu = submenu;
	}
	public Menu getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(Menu parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public Page getPageId() {
		return pageId;
	}
	public void setPageId(Page pageId) {
		this.pageId = pageId;
	}
	public Boolean getGeneral() {
		return general;
	}
	public void setGeneral(Boolean general) {
		this.general = general;
	}
	
	@Override
	public String toString() {
		return "MenuDTO [menuId=" + menuId + ", menuName=" + menuName
				+ ", submenu=" + submenu + ", general=" + general
				+ ", parentMenuId=" + parentMenuId + ", pageId=" + pageId + "]";
	}
	
}
