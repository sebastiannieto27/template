package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.PagePermissionUtil;
import co.com.core.commons.converter.PageUtil;
import co.com.core.commons.converter.PermissionUtil;
import co.com.core.commons.converter.RoleUtil;
import co.com.core.dao.PagePermissionDAO;
import co.com.core.domain.PagePermission;
import co.com.core.domain.Permission;
import co.com.core.dto.PageDTO;
import co.com.core.dto.PermissionDTO;
import co.com.core.dto.RoleDTO;
import co.com.core.dto.PagePermissionDTO;
import co.com.core.services.IPagePermissionService;

public class PagePermissionServiceImpl implements IPagePermissionService {

	private static final Logger logger = Logger.getLogger(PagePermissionServiceImpl.class);
	PagePermissionDAO pagePermissionDAO;
	
	@Override
	public List<PagePermissionDTO> getAll() {
		List<PagePermissionDTO> PagePermissions = new ArrayList<PagePermissionDTO>();
		List<PagePermission> entityList = pagePermissionDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(PagePermission PagePermission : entityList) {
				PagePermissions.add(PagePermissionUtil.getDtoFromEntity(PagePermission));
			}
		}
		return PagePermissions;
	}

	@Override
	public void create(PagePermissionDTO dto) {
		pagePermissionDAO.create(PagePermissionUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(PagePermissionDTO dto) {
		pagePermissionDAO.delete(PagePermissionUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(PagePermissionDTO dto) {
		pagePermissionDAO.update(PagePermissionUtil.getEntityFromDto(dto));
	}

	public PagePermissionDAO getPagePermissionDAO() {
		return pagePermissionDAO;
	}

	public void setPagePermissionDAO(PagePermissionDAO PagePermissionDAO) {
		this.pagePermissionDAO = PagePermissionDAO;
	}
	
	@Override
	public List<PagePermissionDTO> getNotAssignedPermission(String ids) {
		List<PagePermissionDTO> dtoList = new ArrayList<PagePermissionDTO>();
		List<PagePermission> entityList = this.pagePermissionDAO.getNotAssignedPermission(ids);
		if(entityList!=null && entityList.size() > 0) {
			for(PagePermission entity: entityList) {
				dtoList.add(PagePermissionUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}

	@Override
	public PagePermissionDTO validatePermission(PageDTO pageDto,
			PermissionDTO permissionDto) {
		PagePermissionDTO dto = null;
		PagePermission entity = this.pagePermissionDAO.getPermissionByPageCode(PageUtil.getEntityFromDto(pageDto), PermissionUtil.getEntityFromDto(permissionDto));
		
		if(entity!=null) {
			dto = PagePermissionUtil.getDtoFromEntity(entity);
		}
		return dto;
	}
}
