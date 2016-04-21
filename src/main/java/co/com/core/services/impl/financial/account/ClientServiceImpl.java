package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.financialAccount.ClientUtil;
import co.com.core.dao.financial.account.ClientDAO;
import co.com.core.domain.financial.account.Client;
import co.com.core.dto.financial.account.ClientDTO;
import co.com.core.services.financial.account.IClientService;

public class ClientServiceImpl implements IClientService {
	private static final Logger logger = Logger.getLogger(ClientServiceImpl.class);
	ClientDAO clientDAO;
	
	@Override
	public List<ClientDTO> getAll() {
		List<ClientDTO> dtoList = new ArrayList<ClientDTO>();
		List<Client> entityList = clientDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Client entity : entityList) {
				dtoList.add(ClientUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}

	@Override
	public List<ClientDTO> getAllFilter(Map<String, Object> filter) {
		List<ClientDTO> dtoList = new ArrayList<ClientDTO>();
		List<Client> entityList = clientDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(Client entity : entityList) {
				dtoList.add(ClientUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public Client create(ClientDTO dto) {
		return clientDAO.create(ClientUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(ClientDTO dto) {
		clientDAO.delete(ClientUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(ClientDTO dto) {
		clientDAO.update(ClientUtil.getEntityFromDto(dto));
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO ClientDAO) {
		this.clientDAO = ClientDAO;
	}
}
