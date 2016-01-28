package co.com.core.services;

import java.util.List;

import co.com.core.domain.User;
import co.com.core.dto.MenuDTO;

public interface IMenuService {

	public List<MenuDTO> getUserMenu(User user);
	
	public List<MenuDTO> getMenuGeneral();
	
	public List<MenuDTO> getAll(); 
	
	public void createMenu(MenuDTO menuDto);
	
	public void delete(MenuDTO menuDto);
	
	public void update(MenuDTO menuDto);
}
