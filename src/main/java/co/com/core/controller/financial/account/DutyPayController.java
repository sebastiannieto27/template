package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import co.com.core.domain.financial.account.BranchClient;
import co.com.core.dto.financial.account.DutyPayDTO;
import co.com.core.services.financial.account.IDutyPayService;

public class DutyPayController {

private static final Logger logger = Logger.getLogger(DutyPayController.class);
	
	private IDutyPayService dutyPayService;
	private List<DutyPayDTO> items;
	private DutyPayDTO selected;
	
	//filters
	private Integer searchBranchClientId;
	private String searchDutyPayNum;
	
	public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(searchBranchClientId!=null && searchBranchClientId!=0) {
			BranchClient branchClient = new BranchClient(searchBranchClientId);
			filter.put("productName", branchClient);
		}
		
		if(StringUtils.hasText(searchDutyPayNum)) {
			filter.put("dutyPayNum", searchDutyPayNum);
		}
			
		items = dutyPayService.getAllFilter(filter);
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dutyPayService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [DutyPayController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = dutyPayService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				dutyPayService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [DutyPayController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = dutyPayService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				dutyPayService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [DutyPayController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = dutyPayService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new DutyPayDTO();
	}

	public IDutyPayService getDutyPayService() {
		return dutyPayService;
	}

	public void setDutyPayService(IDutyPayService DutyPayService) {
		this.dutyPayService = DutyPayService;
	}

	public List<DutyPayDTO> getItems() {
		return items;
	}

	public void setItems(List<DutyPayDTO> items) {
		this.items = items;
	}

	public DutyPayDTO getSelected() {
		return selected;
	}

	public void setSelected(DutyPayDTO selected) {
		this.selected = selected;
	}

	public Integer getSearchBranchClientId() {
		return searchBranchClientId;
	}

	public void setSearchBranchClientId(Integer searchBranchClientId) {
		this.searchBranchClientId = searchBranchClientId;
	}

	public String getSearchDutyPayNum() {
		return searchDutyPayNum;
	}

	public void setSearchDutyPayNum(String searchDutyPayNum) {
		this.searchDutyPayNum = searchDutyPayNum;
	}
}
