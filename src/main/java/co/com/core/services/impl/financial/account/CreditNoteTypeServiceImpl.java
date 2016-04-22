package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.CreditNoteTypeUtil;
import co.com.core.dao.financial.account.CreditNoteTypeDAO;
import co.com.core.domain.financial.account.CreditNoteType;
import co.com.core.dto.financial.account.CreditNoteTypeDTO;
import co.com.core.services.financial.account.ICreditNoteTypeService;

public class CreditNoteTypeServiceImpl implements ICreditNoteTypeService {
	private static final Logger logger = Logger.getLogger(CreditNoteTypeServiceImpl.class);
	CreditNoteTypeDAO creditNoteTypeDAO;
	
	@Override
	public List<CreditNoteTypeDTO> getAll() {
		List<CreditNoteTypeDTO> CreditNoteTypes = new ArrayList<CreditNoteTypeDTO>();
		List<CreditNoteType> entityList = creditNoteTypeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(CreditNoteType entity : entityList) {
				CreditNoteTypes.add(CreditNoteTypeUtil.getDtoFromEntity(entity));
			}
		}
		return CreditNoteTypes;
	}

	@Override
	public List<CreditNoteTypeDTO> getAllFilter(Map<String, Object> filter) {
		List<CreditNoteTypeDTO> dtoList = new ArrayList<CreditNoteTypeDTO>();
		List<CreditNoteType> entityList = creditNoteTypeDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(CreditNoteType entity : entityList) {
				dtoList.add(CreditNoteTypeUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public CreditNoteType create(CreditNoteTypeDTO dto) {
		return creditNoteTypeDAO.create(CreditNoteTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(CreditNoteTypeDTO dto) {
		creditNoteTypeDAO.delete(CreditNoteTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(CreditNoteTypeDTO dto) {
		creditNoteTypeDAO.update(CreditNoteTypeUtil.getEntityFromDto(dto));
	}

	public CreditNoteTypeDAO getCreditNoteTypeDAO() {
		return creditNoteTypeDAO;
	}

	public void setCreditNoteTypeDAO(CreditNoteTypeDAO CreditNoteTypeDAO) {
		this.creditNoteTypeDAO = CreditNoteTypeDAO;
	}
}
