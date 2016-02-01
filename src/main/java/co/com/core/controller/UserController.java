package co.com.core.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import co.com.core.commons.EncryptDecrypt;
import co.com.core.dto.UserDTO;
import co.com.core.lazy.loader.UserLazyLoader;
import co.com.core.services.IUserService;

public class UserController {
	IUserService userService;
	List<UserDTO> items;
	private UserDTO selected;
	private LazyDataModel<UserDTO> lazyModel;
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	public void init() {
		items = userService.getAll();
		//lazyModel = new UserLazyLoader(userService);
	}

	public void saveNew() {
		try {
			String encryptedPasswd = EncryptDecrypt.encrypt(selected.getPassword());
			selected.setPassword(encryptedPasswd);
			userService.createUser(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Usuario"));
		} catch (Exception ex) {
			logger.error("Throwed Exception [UserController.saveNew]: " +ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Usuario"));
		} finally {
			items = userService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				userService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Usuario"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [UserController.delete]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Usuario"));
			} finally {
				items = userService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			try {
				String encryptedPasswd = EncryptDecrypt.encrypt(selected.getPassword());
				selected.setPassword(encryptedPasswd);
				userService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Usuario"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [UserController.save]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Usuario"));
			} finally {
				items = userService.getAll();
			}
		}
	}

	public void selectOne() {
		System.out.println("selected: " + selected);
	}
	public void prepareCreate() {
		selected = new UserDTO();
	}
	
	public LazyDataModel<UserDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<UserDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public List<UserDTO> getItems() {
		return items;
	}

	public void setItems(List<UserDTO> items) {
		this.items = items;
	}

	public UserDTO getSelected() {
		return selected;
	}

	public void setSelected(UserDTO selected) {
		this.selected = selected;
	}
}
