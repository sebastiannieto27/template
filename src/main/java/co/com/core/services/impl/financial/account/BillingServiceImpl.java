package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.dao.financial.account.BillingDAO;
import co.com.core.dto.financial.account.BillingDTO;
import co.com.core.services.financial.account.IBillingService;

public class BillingServiceImpl implements IBillingService {

	private static final Logger logger = Logger.getLogger(BillingServiceImpl.class);
	BillingDAO billingDAO;
	
	@Override
	public List<BillingDTO> getAll() {
		List<BillingDTO> ageList = new ArrayList<BillingDTO>();
		/*List<Billing> entityList = accountAgeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Billing Billing : entityList) {
				ageList.add(BillingUtil.getDtoFromEntity(Billing));
			}
		}*/
		return ageList;
	}

	@Override
	public List<BillingDTO> getAllFilter(Map<String, Object> filter) {
		List<BillingDTO> dtoList = new ArrayList<BillingDTO>();
		
		BillingDTO entry1 = new BillingDTO();
		entry1.setBillDate(new Date());
		entry1.setBillNumber("332-7");
		entry1.setIvaTax(320679);
		entry1.setNetValue(387650000);
		entry1.setRawValue(456900000);
		
		BillingDTO entry2 = new BillingDTO();
		entry2.setBillDate(new Date());
		entry2.setBillNumber("335-3");
		entry2.setIvaTax(32679);
		entry2.setNetValue(47650000);
		entry2.setRawValue(56900000);
		
		BillingDTO entry3 = new BillingDTO();
		entry3.setBillDate(new Date());
		entry3.setBillNumber("932-1");
		entry3.setIvaTax(220679);
		entry3.setNetValue(87650000);
		entry3.setRawValue(56900000);
		
		BillingDTO entry4 = new BillingDTO();
		entry4.setBillDate(new Date());
		entry4.setBillNumber("232-0");
		entry4.setIvaTax(120679);
		entry4.setNetValue(187650000);
		entry4.setRawValue(256900000);
		
		dtoList.add(entry1);
		dtoList.add(entry2);
		dtoList.add(entry3);
		dtoList.add(entry4);
		
		return dtoList;
	}
	
	public BillingDAO getBillingDAO() {
		return billingDAO;
	}

	public void setBillingDAO(BillingDAO accountAgeDAO) {
		this.billingDAO = accountAgeDAO;
	}
}
