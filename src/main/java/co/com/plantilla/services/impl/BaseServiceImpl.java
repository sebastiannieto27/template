package co.com.plantilla.services.impl;

import co.com.plantilla.dao.IBaseDAO;
import co.com.plantilla.services.IBaseService;

public class BaseServiceImpl implements IBaseService {

	private IBaseDAO baseDAO;

	@Override
	public IBaseDAO getBaseDAO() {
		return baseDAO;
	}

	@Override
	public void setBaseDAO(IBaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}
}
