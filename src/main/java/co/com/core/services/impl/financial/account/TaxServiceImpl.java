package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.TaxUtil;
import co.com.core.dao.financial.account.TaxDAO;
import co.com.core.domain.financial.account.Tax;
import co.com.core.dto.financial.account.TaxDTO;
import co.com.core.services.financial.account.ITaxService;

public class TaxServiceImpl implements ITaxService {
	private static final Logger logger = Logger.getLogger(TaxServiceImpl.class);
	TaxDAO taxDAO;
	
	@Override
	public List<TaxDTO> getAll() {
		List<TaxDTO> Taxs = new ArrayList<TaxDTO>();
		List<Tax> entityList = taxDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Tax Tax : entityList) {
				Taxs.add(TaxUtil.getDtoFromEntity(Tax));
			}
		}
		return Taxs;
	}

	@Override
	public List<TaxDTO> getAllFilter(Map<String, Object> filter) {
		List<TaxDTO> Taxs = new ArrayList<TaxDTO>();
		List<Tax> entityList = taxDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Tax Tax : entityList) {
				Taxs.add(TaxUtil.getDtoFromEntity(Tax));
			}
		}
		return Taxs;
	}
	
	@Override
	public Tax create(TaxDTO dto) {
		return taxDAO.create(TaxUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(TaxDTO dto) {
		taxDAO.delete(TaxUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(TaxDTO dto) {
		taxDAO.update(TaxUtil.getEntityFromDto(dto));
	}

	public TaxDAO getTaxDAO() {
		return taxDAO;
	}

	public void setTaxDAO(TaxDAO TaxDAO) {
		this.taxDAO = TaxDAO;
	}
}
