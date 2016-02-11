package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.PageUtil;
import co.com.core.commons.converter.RolePermissionUtil;
import co.com.core.commons.converter.RoleUtil;
import co.com.core.commons.converter.UserRoleUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.dao.PageDAO;
import co.com.core.dao.UserRoleDAO;
import co.com.core.domain.Page;
import co.com.core.domain.RolePermission;
import co.com.core.domain.UserRole;
import co.com.core.dto.PageDTO;
import co.com.core.dto.RolePermissionDTO;
import co.com.core.dto.UserDTO;
import co.com.core.dto.UserRoleDTO;
import co.com.core.services.IPageService;
import co.com.core.services.IUserRoleService;

public class UserRoleServiceImpl implements IUserRoleService {

	private static final Logger logger = Logger.getLogger(UserRoleServiceImpl.class);
	UserRoleDAO userRoleDAO;
	
	@Override
	public List<UserRoleDTO> getAll() {
		List<UserRoleDTO> userRoles = new ArrayList<UserRoleDTO>();
		List<UserRole> entityList = userRoleDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(UserRole userRole : entityList) {
				userRoles.add(UserRoleUtil.getDtoFromEntity(userRole));
			}
		}
		return userRoles;
	}

	@Override
	public void createUserRole(UserRoleDTO userRoleDto) {
		userRoleDAO.createUserRole(UserRoleUtil.getEntityFromDto(userRoleDto));
	}

	@Override
	public void delete(UserRoleDTO userRoleDto) {
		userRoleDAO.delete(UserRoleUtil.getEntityFromDto(userRoleDto));
	}

	@Override
	public void update(UserRoleDTO userRoleDto) {
		userRoleDAO.update(UserRoleUtil.getEntityFromDto(userRoleDto));
	}

	public UserRoleDAO getUserRoleDAO() {
		return userRoleDAO;
	}

	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	@Override
	public List<UserRoleDTO> findByUser(UserDTO dto) {
		List<UserRoleDTO> dtoList = new ArrayList<UserRoleDTO>();
		List<UserRole> entityList = this.userRoleDAO.findByUser(UserUtil.getEntityFromDto(dto));
		
		if(entityList!= null && entityList.size() > 0) {
			for(UserRole entity : entityList) {
				dtoList.add(UserRoleUtil.getDtoFromEntity(entity));
			}
		}
		
		return dtoList;
	}

	
}
