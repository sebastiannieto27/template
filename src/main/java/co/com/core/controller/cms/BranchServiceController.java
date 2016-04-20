package co.com.core.controller.cms;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.commons.ApplicationConstants;
import co.com.core.commons.SessionUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.domain.cms.Branch;
import co.com.core.domain.cms.Service;
import co.com.core.dto.UserDTO;
import co.com.core.dto.cms.BranchServiceDTO;
import co.com.core.services.cms.IBranchServiceService;


public class BranchServiceController {

	private static final Logger logger = Logger.getLogger(BranchServiceController.class);
	
	IBranchServiceService branchServiceService;
	List<BranchServiceDTO> items;
	private BranchServiceDTO selected;
	private Integer selectedServiceId;
	private Integer selectedBranchId;
	
	private Integer searchServiceId;
	private Integer searchBranchId;
	
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(searchBranchId!=null && searchBranchId!=0) {
			Branch searchBranch = new Branch(searchBranchId);
			filter.put("branchId", searchBranch);
		}
		if(searchServiceId!=null && searchServiceId!=0) {
			Service searchBranch = new Service(searchServiceId);
			filter.put("serviceId", searchBranch);
		}
		items = branchServiceService.getAllFilter(filter);
	}

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(selectedServiceId==null || selectedServiceId==0) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					geProperty("serviceRequiredMessage"), geProperty("pleaseVerifySummary")));
			return false;
		}
		
		if(selectedBranchId==null || selectedBranchId==0) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					geProperty("branchRequiredMessage"), geProperty("pleaseVerifySummary")));
			return false;
		}
		
		
		if(selectedServiceId!=null && selectedServiceId!=0) {
			Service service = new Service(selectedServiceId);
			selected.setServiceId(service);
		}
		
		if(selectedBranchId!=null && selectedBranchId!=0) {
			Branch branch = new Branch(selectedBranchId);
			selected.setBranchId(branch);
		}
		try {
			UserDTO userDto = SessionUtil.getSessionUser();
			selected.setUserId(UserUtil.getEntityFromDto(userDto));
			selected.setDateCre(new Date());
			branchServiceService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [BranchServiceController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = branchServiceService.getAll();
		}
		return true;
	}

	public boolean save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				
				if(selectedServiceId==null || selectedServiceId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("serviceRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				
				if(selectedBranchId==null || selectedBranchId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("branchRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				
				
				if(selectedServiceId!=null && selectedServiceId!=0) {
					Service service = new Service(selectedServiceId);
					selected.setServiceId(service);
				}
				
				if(selectedBranchId!=null && selectedBranchId!=0) {
					Branch branch = new Branch(selectedBranchId);
					selected.setBranchId(branch);
				}
				
				branchServiceService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BranchServiceController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = branchServiceService.getAll();
			}
		}
		
		return true;
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				branchServiceService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BranchServiceController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = branchServiceService.getAll();
			}
		}
	}
	
	public void prepareCreate() {
		selected = new BranchServiceDTO();
		this.selectedBranchId = ApplicationConstants.ZERO_CONSTANT_VALUE;
		this.selectedServiceId = ApplicationConstants.ZERO_CONSTANT_VALUE;
	}

	public void prepareEdit() {
		this.selectedBranchId = selected.getBranchId().getBranchId();
		this.selectedServiceId = selected.getServiceId().getServiceId();
	}

	public List<BranchServiceDTO> getItems() {
		return items;
	}

	public void setItems(List<BranchServiceDTO> items) {
		this.items = items;
	}

	public BranchServiceDTO getSelected() {
		return selected;
	}

	public void setSelected(BranchServiceDTO selected) {
		this.selected = selected;
	}

	public IBranchServiceService getBranchServiceService() {
		return branchServiceService;
	}

	public void setBranchServiceService(IBranchServiceService branchServiceService) {
		this.branchServiceService = branchServiceService;
	}

	public Integer getSearchServiceId() {
		return searchServiceId;
	}

	public void setSearchServiceId(Integer searchServiceId) {
		this.searchServiceId = searchServiceId;
	}

	public Integer getSearchBranchId() {
		return searchBranchId;
	}

	public void setSearchBranchId(Integer searchBranchId) {
		this.searchBranchId = searchBranchId;
	}

	public Integer getSelectedServiceId() {
		return selectedServiceId;
	}

	public void setSelectedServiceId(Integer selectedServiceId) {
		this.selectedServiceId = selectedServiceId;
	}

	public Integer getSelectedBranchId() {
		return selectedBranchId;
	}

	public void setSelectedBranchId(Integer selectedBranchId) {
		this.selectedBranchId = selectedBranchId;
	}
	
}
