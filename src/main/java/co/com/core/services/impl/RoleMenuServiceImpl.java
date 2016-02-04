package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.RoleMenuUtil;
import co.com.core.commons.converter.RoleUtil;
import co.com.core.dao.RoleMenuDAO;
import co.com.core.domain.RoleMenu;
import co.com.core.dto.RoleDTO;
import co.com.core.dto.RoleMenuDTO;
import co.com.core.services.IRoleMenuService;

public class RoleMenuServiceImpl implements IRoleMenuService {

	private static final Logger logger = Logger.getLogger(RoleMenuServiceImpl.class);
	RoleMenuDAO roleMenuDAO;
	
	@Override
	public List<RoleMenuDTO> getAll() {
		List<RoleMenuDTO> RoleMenus = new ArrayList<RoleMenuDTO>();
		List<RoleMenu> entityList = roleMenuDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(RoleMenu RoleMenu : entityList) {
				RoleMenus.add(RoleMenuUtil.getDtoFromEntity(RoleMenu));
			}
		}
		return RoleMenus;
	}

	@Override
	public void create(RoleMenuDTO dto) {
		roleMenuDAO.createRoleMenu(RoleMenuUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(RoleMenuDTO dto) {
		roleMenuDAO.delete(RoleMenuUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(RoleMenuDTO dto) {
		roleMenuDAO.update(RoleMenuUtil.getEntityFromDto(dto));
	}

	public RoleMenuDAO getRoleMenuDAO() {
		return roleMenuDAO;
	}

	public void setRoleMenuDAO(RoleMenuDAO RoleMenuDAO) {
		this.roleMenuDAO = RoleMenuDAO;
	}

	@Override
	public List<RoleMenuDTO> findMenuByRole(RoleDTO role) {
		List<RoleMenuDTO> dtoList = new ArrayList<RoleMenuDTO>();
		List<RoleMenu> entityList = this.roleMenuDAO.findMenuByRole(RoleUtil.getEntityFromDto(role));
		
		if(entityList!= null && entityList.size() > 0) {
			for(RoleMenu entity : entityList) {
				dtoList.add(RoleMenuUtil.getDtoFromEntity(entity));
			}
		}
		
		return dtoList;
	}

	
}
