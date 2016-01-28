package co.com.core.commons.converter;

import co.com.core.domain.Menu;
import co.com.core.dto.MenuDTO;

public class MenuUtil {

	public static MenuDTO getDtoFromEntity(Menu entity) {
		MenuDTO menuDto = new MenuDTO();
		menuDto.setMenuId(entity.getMenuId());
		menuDto.setMenuName(entity.getMenuName());
		menuDto.setPageId(entity.getPageId());
		menuDto.setParentMenuId(entity.getParentMenuId());
		menuDto.setSubmenu(entity.getSubmenu());
		menuDto.setGeneral(entity.getGeneral());
		return menuDto;
	}
	
	public static Menu getEntityFromDto(MenuDTO dto) {
		Menu menu = new Menu();
		menu.setGeneral(dto.getGeneral());
		menu.setMenuId(dto.getMenuId());
		menu.setMenuName(dto.getMenuName());
		menu.setPageId(dto.getPageId());
		menu.setParentMenuId(dto.getParentMenuId());
		menu.setSubmenu(dto.getSubmenu());
		return menu;
	}
}
