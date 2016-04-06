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
import co.com.core.dto.cms.NewsDTO;
import co.com.core.services.cms.INewsService;


public class NewsController {

	INewsService newsService;
	List<NewsDTO> items;
	private NewsDTO selected;
	
	private static final Logger logger = Logger.getLogger(NewsController.class);
	
	public void init() {
		items = newsService.getAll();
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			logger.error(selected);
			UserDTO userDto = SessionUtil.getSessionUser();
			selected.setUserId(UserUtil.getEntityFromDto(userDto));
			selected.setDateCre(new Date());
			newsService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [NewsController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = newsService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				newsService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [NewsController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = newsService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				newsService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [NewsController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = newsService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new NewsDTO();
	}

	public INewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(INewsService NewsService) {
		this.newsService = NewsService;
	}

	public List<NewsDTO> getItems() {
		return items;
	}

	public void setItems(List<NewsDTO> items) {
		this.items = items;
	}

	public NewsDTO getSelected() {
		return selected;
	}

	public void setSelected(NewsDTO selected) {
		this.selected = selected;
	}
}
