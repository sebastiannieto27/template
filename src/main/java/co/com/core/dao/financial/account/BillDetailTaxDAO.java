package co.com.core.dao.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.domain.financial.account.BillDetailTax;

public interface BillDetailTaxDAO {

	public List<BillDetailTax> getAllFilter(Map<String, Object> filter);
	
	public List<BillDetailTax> getAll();
	
	public BillDetailTax create(BillDetailTax entity);
	
	public void delete(BillDetailTax entity);
	
	public void update(BillDetailTax entity);
}
