package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.RoleMenuUtil;
import co.com.core.commons.converter.RolePermissionUtil;
import co.com.core.commons.converter.RoleUtil;
import co.com.core.dao.RolePermissionDAO;
import co.com.core.domain.RoleMenu;
import co.com.core.domain.RolePermission;
import co.com.core.dto.RoleDTO;
import co.com.core.dto.RoleMenuDTO;
import co.com.core.dto.RolePermissionDTO;
import co.com.core.services.IRolePermissionService;

public class RolePermissionServiceImpl implements IRolePermissionService {

	private static final Logger logger = Logger.getLogger(RolePermissionServiceImpl.class);
	RolePermissionDAO rolePermissionDAO;
	
	@Override
	public List<RolePermissionDTO> getAll() {
		List<RolePermissionDTO> RolePermissions = new ArrayList<RolePermissionDTO>();
		List<RolePermission> entityList = rolePermissionDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(RolePermission RolePermission : entityList) {
				RolePermissions.add(RolePermissionUtil.getDtoFromEntity(RolePermission));
			}
		}
		return RolePermissions;
	}

	@Override
	public void create(RolePermissionDTO dto) {
		rolePermissionDAO.create(RolePermissionUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(RolePermissionDTO dto) {
		rolePermissionDAO.delete(RolePermissionUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(RolePermissionDTO dto) {
		rolePermissionDAO.update(RolePermissionUtil.getEntityFromDto(dto));
	}

	public RolePermissionDAO getRolePermissionDAO() {
		return rolePermissionDAO;
	}

	public void setRolePermissionDAO(RolePermissionDAO RolePermissionDAO) {
		this.rolePermissionDAO = RolePermissionDAO;
	}

	@Override
	public List<RolePermissionDTO> findByRole(RoleDTO role) {
		List<RolePermissionDTO> dtoList = new ArrayList<RolePermissionDTO>();
		List<RolePermission> entityList = this.rolePermissionDAO.findByRole(RoleUtil.getEntityFromDto(role));
		
		if(entityList!= null && entityList.size() > 0) {
			for(RolePermission entity : entityList) {
				dtoList.add(RolePermissionUtil.getDtoFromEntity(entity));
			}
		}
		
		return dtoList;
	}
}
