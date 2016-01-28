package co.com.core.services;

import co.com.core.dao.IBaseDAO;

public interface IBaseService {

	public IBaseDAO getBaseDAO();

	public void setBaseDAO(IBaseDAO baseDAO);
}
