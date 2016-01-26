package co.com.plantilla.services;

import co.com.plantilla.dao.IBaseDAO;

public interface IBaseService {

	public IBaseDAO getBaseDAO();

	public void setBaseDAO(IBaseDAO baseDAO);
}
