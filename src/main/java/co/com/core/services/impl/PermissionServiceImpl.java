package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.MenuUtil;
import co.com.core.commons.converter.PermissionUtil;
import co.com.core.commons.converter.RoleMenuUtil;
import co.com.core.commons.converter.RoleUtil;
import co.com.core.dao.PermissionDAO;
import co.com.core.domain.Menu;
import co.com.core.domain.Permission;
import co.com.core.domain.RoleMenu;
import co.com.core.dto.MenuDTO;
import co.com.core.dto.PermissionDTO;
import co.com.core.dto.RoleDTO;
import co.com.core.dto.RoleMenuDTO;
import co.com.core.services.IPermissionService;

public class PermissionServiceImpl implements IPermissionService {

	private static final Logger logger = Logger.getLogger(PermissionServiceImpl.class);
	PermissionDAO permissionDAO;
	
	@Override
	public List<PermissionDTO> getAll() {
		List<PermissionDTO> Permissions = new ArrayList<PermissionDTO>();
		List<Permission> entityList = permissionDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Permission Permission : entityList) {
				Permissions.add(PermissionUtil.getDtoFromEntity(Permission));
			}
		}
		return Permissions;
	}

	@Override
	public void create(PermissionDTO dto) {
		permissionDAO.create(PermissionUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(PermissionDTO dto) {
		permissionDAO.delete(PermissionUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(PermissionDTO dto) {
		permissionDAO.update(PermissionUtil.getEntityFromDto(dto));
	}

	public PermissionDAO getPermissionDAO() {
		return permissionDAO;
	}

	public void setPermissionDAO(PermissionDAO PermissionDAO) {
		this.permissionDAO = PermissionDAO;
	}

	@Override
	public List<PermissionDTO> getNotAssignedPermission(String ids) {
		List<PermissionDTO> dtoList = new ArrayList<PermissionDTO>();
		List<Permission> entityList = this.permissionDAO.getNotAssignedPermission(ids);
		if(entityList!=null && entityList.size() > 0) {
			for(Permission entity: entityList) {
				dtoList.add(PermissionUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}

	@Override
	public PermissionDTO getByCode(String code) {
		PermissionDTO dto = null;
		Permission entity = this.permissionDAO.getByCode(code);
		if(entity!=null) {
			dto = PermissionUtil.getDtoFromEntity(entity);
		}
		return dto;
	}
	
}
