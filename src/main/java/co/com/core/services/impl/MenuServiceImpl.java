package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.core.commons.converter.MenuUtil;
import co.com.core.commons.converter.UserRoleUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.dao.MenuDAO;
import co.com.core.domain.Menu;
import co.com.core.domain.RoleMenu;
import co.com.core.domain.User;
import co.com.core.domain.UserRole;
import co.com.core.dto.MenuDTO;
import co.com.core.dto.UserDTO;
import co.com.core.dto.UserRoleDTO;
import co.com.core.services.IMenuService;

public class MenuServiceImpl implements IMenuService {

	MenuDAO menuDAO;
	
	@Override
	public List<MenuDTO> getUserMenu(User user) {
		List<MenuDTO> userMenuDto = new ArrayList<>();
		List<UserRole> userRoles = menuDAO.getUserRoles(user);
		List<RoleMenu> roleMenu = menuDAO.getUserRoleMenu(userRoles);
		List<Menu> userMenu = menuDAO.getUserMenuOptions(roleMenu);
		if(userMenu!=null && userMenu.size() > 0) {
			for(Menu menu : userMenu) {
				userMenuDto.add(MenuUtil.getDtoFromEntity(menu));
			}
		}
		return userMenuDto;
	}

	@Override
	public List<MenuDTO> getMenuGeneral() {
		List<MenuDTO> userMenuDto = new ArrayList<>();
		List<Menu> menuGeneral = menuDAO.getMenuGeneral();
		if(menuGeneral!=null && menuGeneral.size() > 0) {
			for(Menu menu : menuGeneral) {
				userMenuDto.add(MenuUtil.getDtoFromEntity(menu));
			}
		}
		return userMenuDto;
	}
	
	@Override
	public List<UserRoleDTO> getUserRoles(UserDTO userDto) {
		List<UserRoleDTO> dtoList = null;
		
		List<UserRole> userRoles = menuDAO.getUserRoles(UserUtil.getEntityFromDto(userDto));
		
		if(userRoles!=null && userRoles.size()>0) {
			dtoList = new ArrayList<UserRoleDTO>();
			for(UserRole entity : userRoles) {
				dtoList.add(UserRoleUtil.getDtoFromEntity(entity));
			}
		}
		
		return dtoList;
	}
	/*******************ADMIN************************/
	@Override
	public List<MenuDTO> getAll() {
		List<MenuDTO> Menus = new ArrayList<MenuDTO>();
		List<Menu> entityList = menuDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Menu Menu : entityList) {
				Menus.add(MenuUtil.getDtoFromEntity(Menu));
			}
		}
		return Menus;
	}

	@Override
	public void createMenu(MenuDTO menuDto) {
		menuDAO.createMenu(MenuUtil.getEntityFromDto(menuDto));
	}

	@Override
	public void delete(MenuDTO menuDto) {
		menuDAO.delete(MenuUtil.getEntityFromDto(menuDto));
	}

	@Override
	public void update(MenuDTO menuDto) {
		menuDAO.update(MenuUtil.getEntityFromDto(menuDto));
	}

	public MenuDAO getMenuDAO() {
		return menuDAO;
	}

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	@Override
	public List<MenuDTO> getNotAssignedMenu(String ids) {
		List<MenuDTO> dtoList = new ArrayList<MenuDTO>();
		List<Menu> entityList = this.menuDAO.getNotAssignedMenu(ids);
		if(entityList!=null && entityList.size() > 0) {
			for(Menu entity: entityList) {
				dtoList.add(MenuUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
}
