package co.com.core.dao.impl;

import co.com.core.dao.IBaseDAO;
import co.com.core.domain.BaseEntity;

public class BaseDAO implements IBaseDAO {

	@Override
	public BaseEntity getById(String id) {

		return new BaseEntity();
	}
}