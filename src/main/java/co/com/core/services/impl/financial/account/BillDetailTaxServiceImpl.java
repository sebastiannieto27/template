package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.BillDetailTaxUtil;
import co.com.core.dao.financial.account.BillDetailTaxDAO;
import co.com.core.domain.financial.account.BillDetailTax;
import co.com.core.dto.financial.account.BillDetailTaxDTO;
import co.com.core.services.financial.account.IBillDetailTaxService;

public class BillDetailTaxServiceImpl implements IBillDetailTaxService {
	private static final Logger logger = Logger.getLogger(BillDetailTaxServiceImpl.class);
	BillDetailTaxDAO billDetailTaxDAO;
	
	@Override
	public List<BillDetailTaxDTO> getAll() {
		List<BillDetailTaxDTO> BillDetailTaxs = new ArrayList<BillDetailTaxDTO>();
		List<BillDetailTax> entityList = billDetailTaxDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(BillDetailTax entity : entityList) {
				BillDetailTaxs.add(BillDetailTaxUtil.getDtoFromEntity(entity));
			}
		}
		return BillDetailTaxs;
	}

	@Override
	public List<BillDetailTaxDTO> getAllFilter(Map<String, Object> filter) {
		List<BillDetailTaxDTO> dtoList = new ArrayList<BillDetailTaxDTO>();
		List<BillDetailTax> entityList = billDetailTaxDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(BillDetailTax entity : entityList) {
				dtoList.add(BillDetailTaxUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public BillDetailTax create(BillDetailTaxDTO dto) {
		return billDetailTaxDAO.create(BillDetailTaxUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(BillDetailTaxDTO dto) {
		billDetailTaxDAO.delete(BillDetailTaxUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(BillDetailTaxDTO dto) {
		billDetailTaxDAO.update(BillDetailTaxUtil.getEntityFromDto(dto));
	}

	public BillDetailTaxDAO getBillDetailTaxDAO() {
		return billDetailTaxDAO;
	}

	public void setBillDetailTaxDAO(BillDetailTaxDAO BillDetailTaxDAO) {
		this.billDetailTaxDAO = BillDetailTaxDAO;
	}
}
