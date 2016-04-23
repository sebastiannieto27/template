package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.CreditNoteUtil;
import co.com.core.dao.financial.account.CreditNoteDAO;
import co.com.core.domain.financial.account.CreditNote;
import co.com.core.dto.financial.account.CreditNoteDTO;
import co.com.core.services.financial.account.ICreditNoteService;

public class CreditNoteServiceImpl implements ICreditNoteService {
	private static final Logger logger = Logger.getLogger(CreditNoteServiceImpl.class);
	CreditNoteDAO creditNoteTypeDAO;
	
	@Override
	public List<CreditNoteDTO> getAll() {
		List<CreditNoteDTO> dtoList = new ArrayList<CreditNoteDTO>();
		List<CreditNote> entityList = creditNoteTypeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(CreditNote entity : entityList) {
				dtoList.add(CreditNoteUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}

	@Override
	public List<CreditNoteDTO> getAllFilter(Map<String, Object> filter) {
		List<CreditNoteDTO> dtoList = new ArrayList<CreditNoteDTO>();
		List<CreditNote> entityList = creditNoteTypeDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(CreditNote entity : entityList) {
				dtoList.add(CreditNoteUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public CreditNote create(CreditNoteDTO dto) {
		return creditNoteTypeDAO.create(CreditNoteUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(CreditNoteDTO dto) {
		creditNoteTypeDAO.delete(CreditNoteUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(CreditNoteDTO dto) {
		creditNoteTypeDAO.update(CreditNoteUtil.getEntityFromDto(dto));
	}

	public CreditNoteDAO getCreditNoteDAO() {
		return creditNoteTypeDAO;
	}

	public void setCreditNoteDAO(CreditNoteDAO CreditNoteDAO) {
		this.creditNoteTypeDAO = CreditNoteDAO;
	}
}
