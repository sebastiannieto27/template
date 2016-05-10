package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.dao.financial.account.AccountStatusDAO;
import co.com.core.domain.financial.account.Client;
import co.com.core.dto.financial.account.AccountStatusDTO;
import co.com.core.dto.financial.account.BranchClientDTO;
import co.com.core.services.financial.account.IAccountStatusService;

public class AccountStatusServiceImpl implements IAccountStatusService {

	private static final Logger logger = Logger.getLogger(AccountStatusServiceImpl.class);
	AccountStatusDAO accountAgeDAO;
	
	@Override
	public List<AccountStatusDTO> getAll() {
		List<AccountStatusDTO> ageList = new ArrayList<AccountStatusDTO>();
		/*List<AccountStatus> entityList = accountAgeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(AccountStatus AccountStatus : entityList) {
				ageList.add(AccountStatusUtil.getDtoFromEntity(AccountStatus));
			}
		}*/
		return ageList;
	}

	@Override
	public List<AccountStatusDTO> getAllFilter(Map<String, Object> filter) {
		List<AccountStatusDTO> dtoList = new ArrayList<AccountStatusDTO>();
		
		BranchClientDTO branch1 = new BranchClientDTO();
		branch1.setBranchClAddress("Calle 123 # 37-43");
		branch1.setBranchClientId(1);
		branch1.setBranchClIntCode("0023");
		branch1.setBranchClName("Almacenes Éxito");
		branch1.setBranchClPhone("675 23 09");
		branch1.setClientId(new Client(new Integer(1)));
		
		BranchClientDTO branch2 = new BranchClientDTO();
		branch2.setBranchClAddress("Calle 45 # 120-43");
		branch2.setBranchClientId(1);
		branch2.setBranchClIntCode("002");
		branch2.setBranchClName("Almacenes Jumbo");
		branch2.setBranchClPhone("275 12 09");
		branch2.setClientId(new Client(new Integer(1)));
		
		BranchClientDTO branch3 = new BranchClientDTO();
		branch3.setBranchClAddress("Calle 100 # 7-43");
		branch3.setBranchClientId(1);
		branch3.setBranchClIntCode("001");
		branch3.setBranchClName("Almacenes Surtimax");
		branch3.setBranchClPhone("876 00 11");
		branch3.setClientId(new Client(new Integer(1)));
		
		AccountStatusDTO entry1 = new AccountStatusDTO();
		entry1.setAccountStatusId(new Integer(1));
		entry1.setBillDate("2016-05-15");
		entry1.setBillNumber("7658-4");
		entry1.setDueDate("2016-05-30");
		entry1.setExpirationDays(15);
		entry1.setPendantValue(30_000_000);
		entry1.setBranchClient(branch1);
		
		AccountStatusDTO entry2 = new AccountStatusDTO();
		entry2.setAccountStatusId(new Integer(2));
		entry2.setBillDate("2016-06-01");
		entry2.setBillNumber("7658-5");
		entry2.setDueDate("2016-06-15");
		entry2.setExpirationDays(15);
		entry2.setPendantValue(70_000_000);
		entry2.setBranchClient(branch2);
		
		AccountStatusDTO entry3 = new AccountStatusDTO();
		entry3.setAccountStatusId(new Integer(3));
		entry3.setBillDate("2016-07-15");
		entry3.setBillNumber("7658-5");
		entry3.setDueDate("2016-07-30");
		entry3.setExpirationDays(15);
		entry3.setPendantValue(100_000_000);
		entry3.setBranchClient(branch3);
		
		dtoList.add(entry1);
		dtoList.add(entry2);
		dtoList.add(entry3);
		
		return dtoList;
	}
	
	public AccountStatusDAO getAccountStatusDAO() {
		return accountAgeDAO;
	}

	public void setAccountStatusDAO(AccountStatusDAO accountAgeDAO) {
		this.accountAgeDAO = accountAgeDAO;
	}
}
