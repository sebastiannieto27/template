package co.com.core.controller.financial.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.ColumnModel;
import co.com.core.domain.financial.account.AccountAgeType;
import co.com.core.dto.financial.account.AccountAgeDTO;
import co.com.core.dto.financial.account.AccountAgeQueryDTO;
import co.com.core.dto.financial.account.AccountAgeTypeDTO;
import co.com.core.services.financial.account.IAccountAgeService;


public class AccountAgeController {

	private static final Logger logger = Logger.getLogger(AccountAgeController.class);
	
	private IAccountAgeService accountAgeService;
	private List<AccountAgeDTO> items;
	private AccountAgeDTO selected;

	private Integer branchClientSearch;
	private List<AccountAgeTypeDTO> ageTypesList = new ArrayList<>();
	private String[] selectedAgeType;
	
	AccountAgeTypeDTO selectedAgeTypeRow;
	
	private List<ColumnModel> columns = new ArrayList<ColumnModel>();
	
	private List<AccountAgeQueryDTO> items2;
	
	
	public void generateItemsForList() {  
		items2 = new ArrayList<AccountAgeQueryDTO>();
		AccountAgeTypeDTO type1 = new AccountAgeTypeDTO(1, "1-30", 1, 30);
		AccountAgeTypeDTO type2 = new AccountAgeTypeDTO(2, "31-60", 31, 60);
		AccountAgeTypeDTO type3 = new AccountAgeTypeDTO(3, "61-90", 61, 90);
		AccountAgeTypeDTO type4 = new AccountAgeTypeDTO(4, "91-120", 91, 120);
		
		AccountAgeQueryDTO item1 = new AccountAgeQueryDTO(1, "001", "Almacenes EXITO", 120000000, 390000000, 120000);
		AccountAgeQueryDTO item2 = new AccountAgeQueryDTO(2, "002", "Almacenes JUMBO", 20000000, 90000000, 200000);
		AccountAgeQueryDTO item3 = new AccountAgeQueryDTO(3, "002", "Almacenes SURTIMAX", 990000000, 1390000000, 990000);
		
		items2.add(item1);
		items2.add(item2);
		items2.add(item3);
		
    }
	
	public void init() {
		AccountAgeTypeDTO ageType = new AccountAgeTypeDTO(1, "1-30", 1, 30);
		AccountAgeTypeDTO ageType2 = new AccountAgeTypeDTO(2, "31-60", 31, 60);
		AccountAgeTypeDTO ageType3 = new AccountAgeTypeDTO(3, "61-90", 61, 90);
		AccountAgeTypeDTO ageType4 = new AccountAgeTypeDTO(4, "91-120", 91, 120);
		ageTypesList.add(ageType);
		ageTypesList.add(ageType2);
		ageTypesList.add(ageType3);
		ageTypesList.add(ageType4);
		items = accountAgeService.getAll();
		Map<String, Object> filter = new HashMap<String, Object>();
	}

	public void showSelectedItems() {
		generateItemsForList();
		createDynamicColumns();
		   
	}
	
	private void createDynamicColumns() {
		if(selectedAgeType!=null && selectedAgeType.length > 0) {
			columns.add(new ColumnModel("internalCode", "internalCode"));
			columns.add(new ColumnModel("clientName", "clientName"));
			columns.add(new ColumnModel("pendantValue", "pendantValue"));
			
			for(int i=0; i < selectedAgeType.length; i++) {
				Integer typeId = Integer.parseInt(selectedAgeType[i]);
				AccountAgeType type = new AccountAgeType(typeId);
				columns.add(new ColumnModel(type.getAccountAgeTypeName(), "ageTypeValue"));
			}
			
			columns.add(new ColumnModel("totalValue", "totalValue"));
		}
	}
	
	
	public IAccountAgeService getAccountAgeService() {
		return accountAgeService;
	}

	public void setAccountAgeService(IAccountAgeService accountAgeService) {
		this.accountAgeService = accountAgeService;
	}

	public List<AccountAgeDTO> getItems() {
		return items;
	}

	public void setItems(List<AccountAgeDTO> items) {
		this.items = items;
	}

	public AccountAgeDTO getSelected() {
		return selected;
	}

	public void setSelected(AccountAgeDTO selected) {
		this.selected = selected;
	}
	public List<AccountAgeTypeDTO> getAgeTypesList() {
		return ageTypesList;
	}

	public void setAgeTypesList(List<AccountAgeTypeDTO> ageTypesList) {
		this.ageTypesList = ageTypesList;
	}

	public String[] getSelectedAgeType() {
		return selectedAgeType;
	}

	public void setSelectedAgeType(String[] selectedAgeType) {
		this.selectedAgeType = selectedAgeType;
	}

	public Integer getBranchClientSearch() {
		return branchClientSearch;
	}

	public void setBranchClientSearch(Integer branchClientSearch) {
		this.branchClientSearch = branchClientSearch;
	}

	public AccountAgeTypeDTO getSelectedAgeTypeRow() {
		return selectedAgeTypeRow;
	}

	public void setSelectedAgeTypeRow(AccountAgeTypeDTO selectedAgeTypeRow) {
		this.selectedAgeTypeRow = selectedAgeTypeRow;
	}

	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

	public List<AccountAgeQueryDTO> getItems2() {
		return items2;
	}

	public void setItems2(List<AccountAgeQueryDTO> items2) {
		this.items2 = items2;
	}
	
}
