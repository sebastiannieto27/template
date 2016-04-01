package co.com.core.services.cms.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.cms.BrandUtil;
import co.com.core.dao.cms.BrandDAO;
import co.com.core.domain.cms.Brand;
import co.com.core.dto.cms.BrandDTO;
import co.com.core.services.cms.IBrandService;

public class BrandServiceImpl implements IBrandService {

	private static final Logger logger = Logger.getLogger(BrandServiceImpl.class);
	BrandDAO brandDAO;
	
	@Override
	public List<BrandDTO> getAll() {
		List<BrandDTO> Brands = new ArrayList<BrandDTO>();
		List<Brand> entityList = brandDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Brand Brand : entityList) {
				Brands.add(BrandUtil.getDtoFromEntity(Brand));
			}
		}
		return Brands;
	}

	@Override
	public List<BrandDTO> getAllFilter(Map<String, Object> filter) {
		List<BrandDTO> Brands = new ArrayList<BrandDTO>();
		List<Brand> entityList = brandDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Brand Brand : entityList) {
				Brands.add(BrandUtil.getDtoFromEntity(Brand));
			}
		}
		return Brands;
	}
	
	@Override
	public Brand create(BrandDTO dto) {
		return brandDAO.create(BrandUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BrandDTO dto) {
		brandDAO.delete(BrandUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BrandDTO dto) {
		brandDAO.update(BrandUtil.getEntityFromDto(dto));
	}

	public BrandDAO getBrandDAO() {
		return brandDAO;
	}

	public void setBrandDAO(BrandDAO BrandDAO) {
		this.brandDAO = BrandDAO;
	}
}
