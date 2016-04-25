package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.BillDetail;
import co.com.core.dto.financial.account.BillDetailDTO;

public interface IBillDetailService {

	public List<BillDetailDTO> getAll(); 

	public List<BillDetailDTO> getAllFilter(Map<String, Object> filter); 
	
	public BillDetail create(BillDetailDTO dto);
	
	public void delete(BillDetailDTO dto);
	
	public void update(BillDetailDTO dto);

}
