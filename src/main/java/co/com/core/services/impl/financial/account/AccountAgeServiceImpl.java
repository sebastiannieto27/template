package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.core.dao.financial.account.AccountAgeDAO;
import co.com.core.domain.financial.account.AccountAge;
import co.com.core.dto.financial.account.AccountAgeDTO;
import co.com.core.services.financial.account.IAccountAge;

public class AccountAgeServiceImpl implements IAccountAge {

	private static final Logger logger = Logger.getLogger(AccountAgeServiceImpl.class);
	AccountAgeDAO accountAgeDAO;
	
	@Override
	public List<AccountAgeDTO> getAll() {
		List<AccountAgeDTO> accountAge = new ArrayList<AccountAgeDTO>();
		List<AccountAge> entityList = AccountAgeDAO. .getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(AccountAge AccountAge : entityList) {
				AccountAge.add(AccountAgeUtil.getDtoFromEntity(AccountAge));
			}
		}
		return pages;
	}

	@Override
	public void createPage(PageDTO pageDto) {
		pageDAO.createPage(PageUtil.getEntityFromDto(pageDto));
	}

	@Override
	public void delete(PageDTO pageDto) {
		pageDAO.delete(PageUtil.getEntityFromDto(pageDto));
	}

	@Override
	public void update(PageDTO pageDto) {
		pageDAO.update(PageUtil.getEntityFromDto(pageDto));
	}

	public PageDAO getPageDAO() {
		return pageDAO;
	}

	public void setPageDAO(PageDAO pageDAO) {
		this.pageDAO = pageDAO;
	}

	@Override
	public PageDTO getPageByURL(String url) {
		PageDTO dto = null;
		List<Page> pageList = pageDAO.getPageByURL(url);
		if(pageList!=null && pageList.size() > 0) {
			for(Page page : pageList) {
				dto = PageUtil.getDtoFromEntity(page);
			}
		} else {
			logger.info("Zero pages found related to : " + url);
		}
		
		return dto;
	}
}
