package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.BillDetailTax;
import co.com.core.dto.financial.account.BillDetailTaxDTO;

public interface IBillDetailTaxService {

	public List<BillDetailTaxDTO> getAll(); 

	public List<BillDetailTaxDTO> getAllFilter(Map<String, Object> filter); 
	
	public BillDetailTax create(BillDetailTaxDTO dto);
	
	public void delete(BillDetailTaxDTO dto);
	
	public void update(BillDetailTaxDTO dto);

}
