package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.RaiseMoneyUtil;
import co.com.core.dao.financial.account.RaiseMoneyDAO;
import co.com.core.domain.financial.account.RaiseMoney;
import co.com.core.dto.financial.account.RaiseMoneyDTO;
import co.com.core.services.financial.account.IRaiseMoneyService;

public class RaiseMoneyServiceImpl implements IRaiseMoneyService {
	private static final Logger logger = Logger.getLogger(RaiseMoneyServiceImpl.class);
	RaiseMoneyDAO raiseMoneyDAO;
	
	@Override
	public List<RaiseMoneyDTO> getAll() {
		List<RaiseMoneyDTO> RaiseMoneys = new ArrayList<RaiseMoneyDTO>();
		List<RaiseMoney> entityList = raiseMoneyDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(RaiseMoney RaiseMoney : entityList) {
				RaiseMoneys.add(RaiseMoneyUtil.getDtoFromEntity(RaiseMoney));
			}
		}
		return RaiseMoneys;
	}

	@Override
	public List<RaiseMoneyDTO> getAllFilter(Map<String, Object> filter) {
		List<RaiseMoneyDTO> RaiseMoneys = new ArrayList<RaiseMoneyDTO>();
		List<RaiseMoney> entityList = raiseMoneyDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(RaiseMoney RaiseMoney : entityList) {
				RaiseMoneys.add(RaiseMoneyUtil.getDtoFromEntity(RaiseMoney));
			}
		}
		return RaiseMoneys;
	}
	
	@Override
	public RaiseMoney create(RaiseMoneyDTO dto) {
		return raiseMoneyDAO.create(RaiseMoneyUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(RaiseMoneyDTO dto) {
		raiseMoneyDAO.delete(RaiseMoneyUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(RaiseMoneyDTO dto) {
		raiseMoneyDAO.update(RaiseMoneyUtil.getEntityFromDto(dto));
	}

	public RaiseMoneyDAO getRaiseMoneyDAO() {
		return raiseMoneyDAO;
	}

	public void setRaiseMoneyDAO(RaiseMoneyDAO RaiseMoneyDAO) {
		this.raiseMoneyDAO = RaiseMoneyDAO;
	}
}
