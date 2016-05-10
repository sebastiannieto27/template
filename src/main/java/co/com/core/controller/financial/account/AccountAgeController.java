package co.com.core.controller.financial.account;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.ApplicationConstants;
import co.com.core.commons.ColumnModel;
import co.com.core.dto.financial.account.AccountAgeDTO;
import co.com.core.dto.financial.account.AccountAgeQueryDTO;
import co.com.core.dto.financial.account.AccountAgeTypeDTO;
import co.com.core.services.financial.account.IAccountAgeService;
import co.com.core.services.financial.account.IAccountAgeTypeService;


public class AccountAgeController {

	private static final Logger logger = Logger.getLogger(AccountAgeController.class);
	
	private static final String COLUMN_ID_MARK = "colId-";
	
	private IAccountAgeService accountAgeService;
	private IAccountAgeTypeService accountAgeTypeService;
	private List<AccountAgeDTO> items;
	private AccountAgeDTO selected;

	private Integer branchClientSearch;
	private List<AccountAgeTypeDTO> ageTypesList = new ArrayList<>();
	private String[] selectedAgeType;
	private Map<Integer, AccountAgeTypeDTO> ageTypeMap;
	
	AccountAgeTypeDTO selectedAgeTypeRow;
	
	private List<ColumnModel> columns = new ArrayList<ColumnModel>();
	
	private List<AccountAgeQueryDTO> items2;
	
	private List<AccountAgeTypeDTO> ageTypeItems;
	
	
	public String setAlignment(String property) {
		if(property.equals("pendantValue") || property.equals("ageTypeValue") || property.equals("totalValue")) {
			return ApplicationConstants.OUTPUT_TEXT_RIGHT_ALIGN;
		} else {
			return ApplicationConstants.OUTPUT_TEXT_CENTER_ALIGN;
		}
	}
	
	public boolean isTextField(String property) {
		if(property.equals("internalCode") || property.equals("clientName")) {
			return true;
		}
		return false;
	}
	
	public boolean isNumber(String property) {
		if(property.equals("pendantValue") || property.equals("ageTypeValue") || property.equals("totalValue")) {
			return true;
		}
		return false;
	}
	
	public boolean isDetailLink(String property) {
		if(property.equals("billDetailText")) {
			return true;
		}
		return false;
	}
	
	public String getColumnHeader(String header) {
		String headerTitle = header;
		if(header.contains(COLUMN_ID_MARK)) {
			String[] arrHeader = header.split("-");
			AccountAgeTypeDTO type = (AccountAgeTypeDTO) ageTypeMap.get(new Integer(arrHeader[1]));
			headerTitle = type.getAccountAgeTypeName();
		}
		return headerTitle;
	}
	
	public void showBillDetail(AccountAgeQueryDTO item) {
		logger.info(item);
	}
	
	
	public void generateItemsForList() {  
		
		items2 = new ArrayList<AccountAgeQueryDTO>();
		
		AccountAgeQueryDTO item1 = new AccountAgeQueryDTO(1, "001", "Almacenes EXITO", 120000000, 390000000, 120000, "Facturas");
		AccountAgeQueryDTO item2 = new AccountAgeQueryDTO(2, "002", "Almacenes JUMBO", 20000000, 90000000, 200000, "Facturas");
		AccountAgeQueryDTO item3 = new AccountAgeQueryDTO(3, "003", "Almacenes SURTIMAX", 990000000, 1390000000, 990000, "Facturas");
		
		items2.add(0, item1);
		items2.add(1, item2);
		items2.add(2, item3);
    }
	
	public void fillTypes() {
		ageTypesList = new ArrayList<>();
		ageTypeMap = new HashMap<Integer, AccountAgeTypeDTO>();
		AccountAgeTypeDTO ageType = new AccountAgeTypeDTO(1, "1-30", 1, 30);
		AccountAgeTypeDTO ageType2 = new AccountAgeTypeDTO(2, "31-60", 31, 60);
		AccountAgeTypeDTO ageType3 = new AccountAgeTypeDTO(3, "61-90", 61, 90);
		AccountAgeTypeDTO ageType4 = new AccountAgeTypeDTO(4, "91-120", 91, 120);
		ageTypesList.add(0, ageType);
		ageTypesList.add(1, ageType2);
		ageTypesList.add(2, ageType3);
		ageTypesList.add(3, ageType4);
		
		for(AccountAgeTypeDTO item : ageTypesList) {
			ageTypeMap.put(item.getAccountAgeTypeId(), item);
		}
		
		
		columns = new ArrayList<ColumnModel>();
	}
	
	
	public void init() {
		generateItemsForList();
		ageTypeItems = accountAgeTypeService.getAll();
		items = accountAgeService.getAll();
		Map<String, Object> filter = new HashMap<String, Object>();
	}

	public void showSelectedItems() {
		generateItemsForList();
		createDynamicColumns();
	}
	
	public void createDynamicColumns() {
		
		if(selectedAgeType!=null && selectedAgeType.length > 0) {
			columns.add(new ColumnModel(geProperty("code"), "internalCode"));
			columns.add(new ColumnModel(geProperty("name"), "clientName"));
			columns.add(new ColumnModel(geProperty("pendantValue"), "pendantValue"));
			
			for(int i=0; i < selectedAgeType.length; i++) {
				Integer typeId = Integer.parseInt(selectedAgeType[i]);
				if(ageTypeItems!=null && ageTypeItems.size() > 0) {
					for(AccountAgeTypeDTO item : ageTypeItems) {
						if(item.getAccountAgeTypeId() == typeId) {
							String colId = COLUMN_ID_MARK + item.getAccountAgeTypeId().toString();
							columns.add(new ColumnModel(colId, "ageTypeValue"));
						}
					}
				}
			}
			
			columns.add(new ColumnModel(geProperty("totalValue"), "totalValue"));
			columns.add(new ColumnModel(geProperty("detail"), "billDetailText"));
		}
	}
	
	//query to get the value related to the account age and account age type
	public long getAccountAgetypeValue(String property) {
		long value = 0;
		if(property.equals("ageTypeValue") || property.equals("totalValue") || property.equals("pendantValue")) {
			value = (long) (Math.random() * 10000000 + 1000);
		}
		return value;
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

	public IAccountAgeTypeService getAccountAgeTypeService() {
		return accountAgeTypeService;
	}

	public void setAccountAgeTypeService(
			IAccountAgeTypeService accountAgeTypeService) {
		this.accountAgeTypeService = accountAgeTypeService;
	}
	
}
