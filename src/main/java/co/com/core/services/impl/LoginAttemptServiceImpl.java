package co.com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.LoginAttemptUtil;
import co.com.core.dao.LoginAttemptDAO;
import co.com.core.domain.LoginAttempt;
import co.com.core.dto.LoginAttemptDTO;
import co.com.core.services.ILoginAttemptService;

public class LoginAttemptServiceImpl implements ILoginAttemptService {

	private static final Logger logger = Logger.getLogger(LoginAttemptServiceImpl.class);
	LoginAttemptDAO loginAttemptDAO;
	
	@Override
	public List<LoginAttemptDTO> getAll() {
		List<LoginAttemptDTO> LoginAttempts = new ArrayList<LoginAttemptDTO>();
		List<LoginAttempt> entityList = loginAttemptDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(LoginAttempt LoginAttempt : entityList) {
				LoginAttempts.add(LoginAttemptUtil.getDtoFromEntity(LoginAttempt));
			}
		}
		return LoginAttempts;
	}

	@Override
	public void create(LoginAttemptDTO dto) {
		loginAttemptDAO.create(LoginAttemptUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(LoginAttemptDTO dto) {
		loginAttemptDAO.delete(LoginAttemptUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(LoginAttemptDTO dto) {
		loginAttemptDAO.update(LoginAttemptUtil.getEntityFromDto(dto));
	}

	public LoginAttemptDAO getLoginAttemptDAO() {
		return loginAttemptDAO;
	}

	public void setLoginAttemptDAO(LoginAttemptDAO LoginAttemptDAO) {
		this.loginAttemptDAO = LoginAttemptDAO;
	}

	@Override
	public long invalidLoginAttemps(String userMail) {
		long attempts = 0;
		
		Long objAttempts = this.loginAttemptDAO.invalidLoginAttemps(userMail);
		
		if(objAttempts!=null) {
			attempts = objAttempts.longValue();
		}
		return attempts;
	}
}
