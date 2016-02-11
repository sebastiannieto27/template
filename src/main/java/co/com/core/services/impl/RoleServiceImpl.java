package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.PagePermissionUtil;
import co.com.core.commons.converter.RoleUtil;
import co.com.core.dao.RoleDAO;
import co.com.core.domain.PagePermission;
import co.com.core.domain.Role;
import co.com.core.dto.PagePermissionDTO;
import co.com.core.dto.RoleDTO;
import co.com.core.services.IRoleService;

public class RoleServiceImpl implements IRoleService {

	RoleDAO roleDAO;
	private static final Logger logger = Logger.getLogger(RoleServiceImpl.class);
	
	@Override
	public List<RoleDTO> getAll() {
		List<RoleDTO> roles = new ArrayList<RoleDTO>();
		List<Role> entityList = roleDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Role Role : entityList) {
				roles.add(RoleUtil.getDtoFromEntity(Role));
			}
		}
		return roles;
	}

	@Override
	public void createRole(RoleDTO roleDto) {
		roleDAO.createRole(RoleUtil.getEntityFromDto(roleDto));
	}

	@Override
	public void delete(RoleDTO roleDto) {
		roleDAO.delete(RoleUtil.getEntityFromDto(roleDto));
	}

	@Override
	public void update(RoleDTO roleDto) {
		roleDAO.update(RoleUtil.getEntityFromDto(roleDto));
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO RoleDAO) {
		this.roleDAO = RoleDAO;
	}

	@Override
	public List<RoleDTO> getNotAssignedRole(String ids) {
		List<RoleDTO> dtoList = new ArrayList<RoleDTO>();
		List<Role> entityList = this.roleDAO.getNotAssignedRole(ids);
		if(entityList!=null && entityList.size() > 0) {
			for(Role entity: entityList) {
				dtoList.add(RoleUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
}
