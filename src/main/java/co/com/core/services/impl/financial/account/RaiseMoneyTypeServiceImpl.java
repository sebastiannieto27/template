package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.RaiseMoneyTypeUtil;
import co.com.core.dao.financial.account.RaiseMoneyTypeDAO;
import co.com.core.domain.financial.account.RaiseMoneyType;
import co.com.core.dto.financial.account.RaiseMoneyTypeDTO;
import co.com.core.services.financial.account.IRaiseMoneyTypeService;

public class RaiseMoneyTypeServiceImpl implements IRaiseMoneyTypeService {
	private static final Logger logger = Logger.getLogger(RaiseMoneyTypeServiceImpl.class);
	RaiseMoneyTypeDAO taxDAO;
	
	@Override
	public List<RaiseMoneyTypeDTO> getAll() {
		List<RaiseMoneyTypeDTO> RaiseMoneyTypes = new ArrayList<RaiseMoneyTypeDTO>();
		List<RaiseMoneyType> entityList = taxDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(RaiseMoneyType RaiseMoneyType : entityList) {
				RaiseMoneyTypes.add(RaiseMoneyTypeUtil.getDtoFromEntity(RaiseMoneyType));
			}
		}
		return RaiseMoneyTypes;
	}

	@Override
	public List<RaiseMoneyTypeDTO> getAllFilter(Map<String, Object> filter) {
		List<RaiseMoneyTypeDTO> RaiseMoneyTypes = new ArrayList<RaiseMoneyTypeDTO>();
		List<RaiseMoneyType> entityList = taxDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(RaiseMoneyType RaiseMoneyType : entityList) {
				RaiseMoneyTypes.add(RaiseMoneyTypeUtil.getDtoFromEntity(RaiseMoneyType));
			}
		}
		return RaiseMoneyTypes;
	}
	
	@Override
	public RaiseMoneyType create(RaiseMoneyTypeDTO dto) {
		return taxDAO.create(RaiseMoneyTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(RaiseMoneyTypeDTO dto) {
		taxDAO.delete(RaiseMoneyTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(RaiseMoneyTypeDTO dto) {
		taxDAO.update(RaiseMoneyTypeUtil.getEntityFromDto(dto));
	}

	public RaiseMoneyTypeDAO getRaiseMoneyTypeDAO() {
		return taxDAO;
	}

	public void setRaiseMoneyTypeDAO(RaiseMoneyTypeDAO RaiseMoneyTypeDAO) {
		this.taxDAO = RaiseMoneyTypeDAO;
	}
}
