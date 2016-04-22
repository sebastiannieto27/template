package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.DutyPayUtil;
import co.com.core.dao.financial.account.DutyPayDAO;
import co.com.core.domain.financial.account.DutyPay;
import co.com.core.dto.financial.account.DutyPayDTO;
import co.com.core.services.financial.account.IDutyPayService;

public class DutyPayServiceImpl implements IDutyPayService {
	private static final Logger logger = Logger.getLogger(DutyPayServiceImpl.class);
	private DutyPayDAO dutyPayDAO;
	
	@Override
	public List<DutyPayDTO> getAll() {
		List<DutyPayDTO> DutyPays = new ArrayList<DutyPayDTO>();
		List<DutyPay> entityList = dutyPayDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(DutyPay DutyPay : entityList) {
				DutyPays.add(DutyPayUtil.getDtoFromEntity(DutyPay));
			}
		}
		return DutyPays;
	}

	@Override
	public List<DutyPayDTO> getAllFilter(Map<String, Object> filter) {
		List<DutyPayDTO> dtoList = new ArrayList<DutyPayDTO>();
		List<DutyPay> entityList = dutyPayDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(DutyPay entity : entityList) {
				dtoList.add(DutyPayUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public DutyPay create(DutyPayDTO dto) {
		return dutyPayDAO.create(DutyPayUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(DutyPayDTO dto) {
		dutyPayDAO.delete(DutyPayUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(DutyPayDTO dto) {
		dutyPayDAO.update(DutyPayUtil.getEntityFromDto(dto));
	}

	public DutyPayDAO getDutyPayDAO() {
		return dutyPayDAO;
	}

	public void setDutyPayDAO(DutyPayDAO DutyPayDAO) {
		this.dutyPayDAO = DutyPayDAO;
	}
}
