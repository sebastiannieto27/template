package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.dto.financial.account.BranchClientDTO;
import co.com.core.services.financial.account.IBranchClientService;

public class BranchClientController {

private static final Logger logger = Logger.getLogger(BranchClientController.class);
	
	private IBranchClientService branchClientService;
	private List<BranchClientDTO> items;
	private BranchClientDTO selected;
	
	//filters
	private String branchClName;
	private String branchClIntCode;
	private String branchClAddress;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(branchClName)) {
			filter.put("branchClName", branchClName);
		}
		
		if(StringUtils.hasText(branchClIntCode)) {
			filter.put("branchClIntCode", branchClIntCode);
		}
		
		if(StringUtils.hasText(branchClAddress)) {
			filter.put("branchClAddress", branchClAddress);
		}
			
		items = branchClientService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			branchClientService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [BranchClientController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = branchClientService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				branchClientService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BranchClientController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = branchClientService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				branchClientService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [BranchClientController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = branchClientService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new BranchClientDTO();
	}

	public IBranchClientService getBranchClientService() {
		return branchClientService;
	}

	public void setBranchClientService(IBranchClientService BranchClientService) {
		this.branchClientService = BranchClientService;
	}

	public List<BranchClientDTO> getItems() {
		return items;
	}

	public void setItems(List<BranchClientDTO> items) {
		this.items = items;
	}

	public BranchClientDTO getSelected() {
		return selected;
	}

	public void setSelected(BranchClientDTO selected) {
		this.selected = selected;
	}

	public String getBranchClName() {
		return branchClName;
	}

	public void setBranchClName(String branchClName) {
		this.branchClName = branchClName;
	}

	public String getBranchClIntCode() {
		return branchClIntCode;
	}

	public void setBranchClIntCode(String branchClIntCode) {
		this.branchClIntCode = branchClIntCode;
	}

	public String getBranchClAddress() {
		return branchClAddress;
	}

	public void setBranchClAddress(String branchClAddress) {
		this.branchClAddress = branchClAddress;
	}

	
}
