package co.com.core.dao.impl.financial.account;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.com.core.dao.financial.account.AccountStatusDAO;
import co.com.core.domain.financial.account.AccountStatus;

public class AccountStatusDAOImpl implements AccountStatusDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private static final Logger logger = Logger.getLogger(AccountStatusDAOImpl.class);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public List<AccountStatus> getAll() {
		List<AccountStatus> entityList = null;
		try {
			session = this.sessionFactory.openSession();
	        Query query = session.getNamedQuery("AccountAge.findAll");
	        entityList = query.list();
		} catch(Exception ex) {
			logger.error("Throwed Exception [AccountStatusDAOImpl.getAll]: " +ex.getMessage());
		} finally {
			session.close();
		}
		return entityList;
	}

	@Override
	public List<AccountStatus> getAllFilter(Map<String, Object> filter) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
