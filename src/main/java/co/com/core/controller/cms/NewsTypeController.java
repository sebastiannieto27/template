package co.com.core.controller.cms;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.commons.SessionUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.dto.UserDTO;
import co.com.core.dto.cms.NewsTypeDTO;
import co.com.core.services.cms.INewsTypeService;


public class NewsTypeController {

	INewsTypeService newsTypeService;
	List<NewsTypeDTO> items;
	private NewsTypeDTO selected;
	
	private static final Logger logger = Logger.getLogger(NewsTypeController.class);
	
	public void init() {
		items = newsTypeService.getAll();
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			UserDTO userDto = SessionUtil.getSessionUser();
			selected.setUserId(UserUtil.getEntityFromDto(userDto));
			selected.setDateCre(new Date());
			newsTypeService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [NewsTypeController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = newsTypeService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				newsTypeService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [NewsTypeController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = newsTypeService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				newsTypeService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [NewsTypeController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = newsTypeService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new NewsTypeDTO();
	}

	public INewsTypeService getNewsTypeService() {
		return newsTypeService;
	}

	public void setNewsTypeService(INewsTypeService NewsTypeService) {
		this.newsTypeService = NewsTypeService;
	}

	public List<NewsTypeDTO> getItems() {
		return items;
	}

	public void setItems(List<NewsTypeDTO> items) {
		this.items = items;
	}

	public NewsTypeDTO getSelected() {
		return selected;
	}

	public void setSelected(NewsTypeDTO selected) {
		this.selected = selected;
	}
}
