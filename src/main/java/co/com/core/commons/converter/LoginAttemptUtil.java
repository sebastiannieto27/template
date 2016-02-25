package co.com.core.commons.converter;

import co.com.core.domain.LoginAttempt;
import co.com.core.dto.LoginAttemptDTO;

public class LoginAttemptUtil {

	public static LoginAttemptDTO getDtoFromEntity(LoginAttempt entity) {
		LoginAttemptDTO dto = new LoginAttemptDTO();
		dto.setLoginAttemptId(entity.getLoginAttemptId());
		dto.setDateAttempt(entity.getDateAttempt());
		dto.setIpAddress(entity.getIpAddress());
		dto.setUserAgent(entity.getUserAgent());
		dto.setUserMail(entity.getUserMail());
		dto.setValidAttempt(entity.getValidAttempt());
		return dto;
	}
	
	public static LoginAttempt getEntityFromDto(LoginAttemptDTO dto) {
		LoginAttempt entity = new LoginAttempt();
		entity.setLoginAttemptId(dto.getLoginAttemptId());
		entity.setDateAttempt(dto.getDateAttempt());
		entity.setIpAddress(dto.getIpAddress());
		entity.setUserAgent(dto.getUserAgent());
		entity.setUserMail(dto.getUserMail());
		entity.setValidAttempt(dto.getValidAttempt());
		return entity;
	}
}
