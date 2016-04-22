package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.DutyPay;
import co.com.core.dto.financial.account.DutyPayDTO;

public interface IDutyPayService {

	public List<DutyPayDTO> getAll(); 

	public List<DutyPayDTO> getAllFilter(Map<String, Object> filter); 
	
	public DutyPay create(DutyPayDTO dto);
	
	public void delete(DutyPayDTO dto);
	
	public void update(DutyPayDTO dto);

}
