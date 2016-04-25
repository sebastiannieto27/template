package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.ClientTypeUtil;
import co.com.core.dao.financial.account.ClientTypeDAO;
import co.com.core.domain.financial.account.ClientType;
import co.com.core.dto.financial.account.ClientTypeDTO;
import co.com.core.services.financial.account.IClientTypeService;

public class ClientTypeServiceImpl implements IClientTypeService {
	private static final Logger logger = Logger.getLogger(ClientTypeServiceImpl.class);
	ClientTypeDAO clientTypeDAO;
	
	@Override
	public List<ClientTypeDTO> getAll() {
		List<ClientTypeDTO> ClientTypes = new ArrayList<ClientTypeDTO>();
		List<ClientType> entityList = clientTypeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(ClientType entity : entityList) {
				ClientTypes.add(ClientTypeUtil.getDtoFromEntity(entity));
			}
		}
		return ClientTypes;
	}

	@Override
	public List<ClientTypeDTO> getAllFilter(Map<String, Object> filter) {
		List<ClientTypeDTO> dtoList = new ArrayList<ClientTypeDTO>();
		List<ClientType> entityList = clientTypeDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(ClientType entity : entityList) {
				dtoList.add(ClientTypeUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public ClientType create(ClientTypeDTO dto) {
		return clientTypeDAO.create(ClientTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(ClientTypeDTO dto) {
		clientTypeDAO.delete(ClientTypeUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(ClientTypeDTO dto) {
		clientTypeDAO.update(ClientTypeUtil.getEntityFromDto(dto));
	}

	public ClientTypeDAO getClientTypeDAO() {
		return clientTypeDAO;
	}

	public void setClientTypeDAO(ClientTypeDAO ClientTypeDAO) {
		this.clientTypeDAO = ClientTypeDAO;
	}
}
