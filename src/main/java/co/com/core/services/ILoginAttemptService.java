package co.com.core.services;

import java.util.List;

import co.com.core.dto.LoginAttemptDTO;


public interface ILoginAttemptService {

	public List<LoginAttemptDTO> getAll(); 
	
	public void create(LoginAttemptDTO dto);
	
	public void delete(LoginAttemptDTO dto);
	
	public void update(LoginAttemptDTO dto);
	
	public long invalidLoginAttemps(String userMail);
}
