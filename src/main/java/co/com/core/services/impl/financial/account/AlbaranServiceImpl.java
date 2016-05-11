package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.dao.financial.account.AlbaranDAO;
import co.com.core.dto.financial.account.AlbaranDTO;
import co.com.core.services.financial.account.IAlbaranService;

public class AlbaranServiceImpl implements IAlbaranService {

	private static final Logger logger = Logger.getLogger(AlbaranServiceImpl.class);
	AlbaranDAO billingDAO;
	
	@Override
	public List<AlbaranDTO> getAll() {
		List<AlbaranDTO> ageList = new ArrayList<AlbaranDTO>();
		/*List<Albaran> entityList = accountAgeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Albaran Albaran : entityList) {
				ageList.add(AlbaranUtil.getDtoFromEntity(Albaran));
			}
		}*/
		return ageList;
	}

	@Override
	public List<AlbaranDTO> getAllFilter(Map<String, Object> filter) {
		List<AlbaranDTO> dtoList = new ArrayList<AlbaranDTO>();
		
		AlbaranDTO entry1 = new AlbaranDTO();
		entry1.setAlbaranDate(new Date());
		entry1.setAlbaranNumber("332-7");
		entry1.setValue(387650000);
		entry1.setAlbaranType("CONFORMADO");
		
		AlbaranDTO entry2 = new AlbaranDTO();
		entry2.setAlbaranDate(new Date());
		entry2.setAlbaranNumber("335-3");
		entry2.setValue(47650000);
		entry2.setAlbaranType("FACTURADO");
		
		AlbaranDTO entry3 = new AlbaranDTO();
		entry3.setAlbaranDate(new Date());
		entry3.setAlbaranNumber("932-1");
		entry3.setValue(87650000);
		entry3.setAlbaranType("FACTURADO");
		
		AlbaranDTO entry4 = new AlbaranDTO();
		entry4.setAlbaranDate(new Date());
		entry4.setAlbaranNumber("232-0");
		entry4.setValue(187650000);
		entry4.setAlbaranType("CONFORMADO");
		
		dtoList.add(entry1);
		dtoList.add(entry2);
		dtoList.add(entry3);
		dtoList.add(entry4);
		
		return dtoList;
	}
	
	public AlbaranDAO getAlbaranDAO() {
		return billingDAO;
	}

	public void setAlbaranDAO(AlbaranDAO accountAgeDAO) {
		this.billingDAO = accountAgeDAO;
	}
}
