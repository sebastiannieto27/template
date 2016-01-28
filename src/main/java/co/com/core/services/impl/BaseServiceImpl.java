package co.com.core.services.impl;

import co.com.core.dao.IBaseDAO;
import co.com.core.services.IBaseService;

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
