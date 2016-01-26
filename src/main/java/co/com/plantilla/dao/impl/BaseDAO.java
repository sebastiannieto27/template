package co.com.plantilla.dao.impl;

import co.com.plantilla.dao.IBaseDAO;
import co.com.plantilla.domain.BaseEntity;

public class BaseDAO implements IBaseDAO {

	@Override
	public BaseEntity getById(String id) {

		return new BaseEntity();
	}
}