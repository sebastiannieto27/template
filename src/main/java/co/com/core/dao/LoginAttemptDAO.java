package co.com.core.dao;

import java.util.List;

import co.com.core.domain.LoginAttempt;

public interface LoginAttemptDAO {
	
	public List<LoginAttempt> getAll();
	
	public void create(LoginAttempt entity);
	
	public void delete(LoginAttempt entity);
	
	public void update(LoginAttempt entity);
	
	public Long invalidLoginAttemps(String userMail);
}
