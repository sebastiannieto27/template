package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.BillDetailUtil;
import co.com.core.dao.financial.account.BillDetailDAO;
import co.com.core.domain.financial.account.BillDetail;
import co.com.core.dto.financial.account.BillDetailDTO;
import co.com.core.services.financial.account.IBillDetailService;

public class BillDetailServiceImpl implements IBillDetailService {
	private static final Logger logger = Logger.getLogger(BillDetailServiceImpl.class);
	BillDetailDAO billDetailDAO;
	
	@Override
	public List<BillDetailDTO> getAll() {
		List<BillDetailDTO> BillDetails = new ArrayList<BillDetailDTO>();
		List<BillDetail> entityList = billDetailDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(BillDetail entity : entityList) {
				BillDetails.add(BillDetailUtil.getDtoFromEntity(entity));
			}
		}
		return BillDetails;
	}

	@Override
	public List<BillDetailDTO> getAllFilter(Map<String, Object> filter) {
		List<BillDetailDTO> dtoList = new ArrayList<BillDetailDTO>();
		List<BillDetail> entityList = billDetailDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(BillDetail entity : entityList) {
				dtoList.add(BillDetailUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public BillDetail create(BillDetailDTO dto) {
		return billDetailDAO.create(BillDetailUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BillDetailDTO dto) {
		billDetailDAO.delete(BillDetailUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BillDetailDTO dto) {
		billDetailDAO.update(BillDetailUtil.getEntityFromDto(dto));
	}

	public BillDetailDAO getBillDetailDAO() {
		return billDetailDAO;
	}

	public void setBillDetailDAO(BillDetailDAO BillDetailDAO) {
		this.billDetailDAO = BillDetailDAO;
	}
}
