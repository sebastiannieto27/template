package co.com.core.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;

import co.com.core.dto.UserDTO;
import co.com.core.lazy.loader.UserLazyLoader;
import co.com.core.services.IUserService;

public class UserController {
	IUserService userService;
	List<UserDTO> items;
	private UserDTO selected;
	
	private LazyDataModel<UserDTO> lazyModel;

	@PostConstruct
	public void init() {
		lazyModel = new UserLazyLoader(userService);
	}

	public void saveNew() {
		try {
			userService.createUser(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Usuario"));
		} catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage(
					null,
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
				ex.printStackTrace();
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
				userService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Usuario"));
			} catch (Exception ex) {
				ex.printStackTrace();
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
