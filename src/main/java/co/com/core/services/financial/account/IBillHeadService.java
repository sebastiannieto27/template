package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.BillHead;
import co.com.core.dto.financial.account.BillHeadDTO;

public interface IBillHeadService {

	public List<BillHeadDTO> getAll(); 

	public List<BillHeadDTO> getAllFilter(Map<String, Object> filter); 
	
	public BillHead create(BillHeadDTO dto);
	
	public void delete(BillHeadDTO dto);
	
	public void update(BillHeadDTO dto);

}
