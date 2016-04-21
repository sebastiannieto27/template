package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.BillHeadUtil;
import co.com.core.dao.financial.account.BillHeadDAO;
import co.com.core.domain.financial.account.BillHead;
import co.com.core.dto.financial.account.BillHeadDTO;
import co.com.core.services.financial.account.IBillHeadService;

public class BillHeadServiceImpl implements IBillHeadService {
	private static final Logger logger = Logger.getLogger(BillHeadServiceImpl.class);
	BillHeadDAO billHeadDAO;
	
	@Override
	public List<BillHeadDTO> getAll() {
		List<BillHeadDTO> dtoList = new ArrayList<BillHeadDTO>();
		List<BillHead> entityList = billHeadDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(BillHead entity : entityList) {
				dtoList.add(BillHeadUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}

	@Override
	public List<BillHeadDTO> getAllFilter(Map<String, Object> filter) {
		List<BillHeadDTO> dtoList = new ArrayList<BillHeadDTO>();
		List<BillHead> entityList = billHeadDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(BillHead entity : entityList) {
				dtoList.add(BillHeadUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public BillHead create(BillHeadDTO dto) {
		return billHeadDAO.create(BillHeadUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BillHeadDTO dto) {
		billHeadDAO.delete(BillHeadUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BillHeadDTO dto) {
		billHeadDAO.update(BillHeadUtil.getEntityFromDto(dto));
	}

	public BillHeadDAO getBillHeadDAO() {
		return billHeadDAO;
	}

	public void setBillHeadDAO(BillHeadDAO BillHeadDAO) {
		this.billHeadDAO = BillHeadDAO;
	}
}
