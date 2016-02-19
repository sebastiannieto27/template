package co.com.core.controller;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.RoleUtil;
import co.com.core.domain.Page;
import co.com.core.domain.Permission;
import co.com.core.dto.PageDTO;
import co.com.core.dto.PagePermissionDTO;
import co.com.core.dto.PermissionDTO;
import co.com.core.dto.RolePermissionDTO;
import co.com.core.dto.UserDTO;
import co.com.core.dto.UserRoleDTO;
import co.com.core.services.IMenuService;
import co.com.core.services.IPagePermissionService;
import co.com.core.services.IPageService;
import co.com.core.services.IPermissionService;
import co.com.core.services.IRolePermissionService;


public class PagePermissionController {

	private IPagePermissionService pagePermissionService;
	private IRolePermissionService rolePermissionService;
	private IPermissionService permissionService;
	private IMenuService menuService;
	private IPageService pageService;
	private List<PagePermissionDTO> items;
	private PagePermissionDTO selected;
	private Integer selectedPageId;
	private Integer selectedPermissionId;
	private static final Logger logger = Logger.getLogger(PagePermissionController.class);
	
	public void init() {
		items = pagePermissionService.getAll();
	}

	public void saveNew() {
		boolean valid = true;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			if(selectedPageId!=null && selectedPageId!=0) {
				Page p = new Page(selectedPageId);
				selected.setPageId(p);
			} else {
				valid = false;
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, geProperty("pageRequiredMessage"), geProperty("pleaseVerifySummary")));
			}
			
			if(valid) {
				if(selectedPermissionId!=null && selectedPermissionId!=0) {
					Permission p = new Permission(selectedPermissionId);
					selected.setPermissionId(p);
					
					pagePermissionService.create(selected);
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
					
				} else {
					valid = false;
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, geProperty("permissionRequiredMessage"), geProperty("pleaseVerifySummary")));
				}
			}
			
		} catch (Exception ex) {
			logger.error("Throwed Exception [PagePermissionController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = pagePermissionService.getAll();
		}

	}

	public void save() {
		if (this.selected != null) {
			boolean valid = true;
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				
				if(selectedPageId!=null && selectedPageId!=0) {
					Page p = new Page(selectedPageId);
					selected.setPageId(p);
				} else {
					valid = false;
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, geProperty("pageRequiredMessage"), geProperty("pleaseVerifySummary")));
				}
				
				if(valid) {
					if(selectedPermissionId!=null && selectedPermissionId!=0) {
						Permission p = new Permission(selectedPermissionId);
						selected.setPermissionId(p);
						
						pagePermissionService.update(selected);
						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
						
					} else {
						valid = false;
						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, geProperty("permissionRequiredMessage"), geProperty("pleaseVerifySummary")));
					}
				}
			} catch (Exception ex) {
				logger.error("Throwed Exception [PagePermissionController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = pagePermissionService.getAll();
			}
		}
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				pagePermissionService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [PagePermissionController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = pagePermissionService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new PagePermissionDTO();
	}

	/**
	 * Validates if the user have permission related to the code and page
	 * @param code
	 * @param page
	 * @return
	 */
	public boolean validatePermission(String code, String page) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean valid = false;
		logger.info(code + " -- " + page);
		UserDTO userDto = (UserDTO) context.getExternalContext().getSessionMap().get("user");
		
		if(userDto!=null) {
			logger.info("USERDTO : " + userDto);
			List<UserRoleDTO> roleList = menuService.getUserRoles(userDto);
			
			if(roleList!=null && roleList.size()>0) {
				PermissionDTO permissionDto = permissionService.getByCode(code);
				
				if(permissionDto!=null) {
					logger.info("permissionDto : " + permissionDto);
					PageDTO pageDto = pageService.getPageByURL(page);
					
					if(pageDto!=null) {
						PagePermissionDTO pagePermissionDto = pagePermissionService.validatePermission(pageDto, permissionDto);
						logger.info("pageDto : " + pageDto);
						if(pagePermissionDto!=null) {
							logger.info("pagePermissionDto : " + pagePermissionDto);
							for(UserRoleDTO userRole : roleList) {
								RolePermissionDTO dto = rolePermissionService.
										findByRolePagePermission(RoleUtil.getDtoFromEntity(userRole.getRoleId()), pagePermissionDto);
								
								if(dto!=null) {
									logger.info("dto!=null : " + dto);
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		return valid;
	}
	
	public IPagePermissionService getPagePermissionService() {
		return pagePermissionService;
	}

	public void setPagePermissionService(IPagePermissionService PagePermissionService) {
		this.pagePermissionService = PagePermissionService;
	}

	public List<PagePermissionDTO> getItems() {
		return items;
	}

	public void setItems(List<PagePermissionDTO> items) {
		this.items = items;
	}

	public PagePermissionDTO getSelected() {
		return selected;
	}

	public void setSelected(PagePermissionDTO selected) {
		this.selected = selected;
	}

	public Integer getSelectedPageId() {
		return selectedPageId;
	}

	public void setSelectedPageId(Integer selectedPageId) {
		this.selectedPageId = selectedPageId;
	}

	public Integer getSelectedPermissionId() {
		return selectedPermissionId;
	}

	public void setSelectedPermissionId(Integer selectedPermissionId) {
		this.selectedPermissionId = selectedPermissionId;
	}

	public IPermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public IPageService getPageService() {
		return pageService;
	}

	public void setPageService(IPageService pageService) {
		this.pageService = pageService;
	}

	public IRolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}

	public void setRolePermissionService(
			IRolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}
	
}
