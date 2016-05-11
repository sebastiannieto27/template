package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.dto.financial.account.AlbaranDTO;

public interface IAlbaranService {

	public List<AlbaranDTO> getAll(); 

	public List<AlbaranDTO> getAllFilter(Map<String, Object> filter); 

}
