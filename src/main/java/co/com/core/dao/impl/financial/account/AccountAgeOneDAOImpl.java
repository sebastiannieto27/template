package co.com.core.dao.impl.financial.account;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.com.core.dao.financial.account.AccountAgeOneDAO;
import co.com.core.domain.financial.account.views.AccountAgeOne;

public class AccountAgeOneDAOImpl implements AccountAgeOneDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private static final Logger logger = Logger.getLogger(AccountAgeOneDAOImpl.class);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public List<AccountAgeOne> getAll() {
		List<AccountAgeOne> entityList = null;
		try {
			session = this.sessionFactory.openSession();
	        Query query = session.getNamedQuery("AccountAgeOne.findAll");
	        entityList = query.list();
		} catch(Exception ex) {
			logger.error("Throwed Exception [AccountAgeOneDAOImpl.getAll]: " +ex.getMessage());
		} finally {
			session.close();
		}
		return entityList;
	}
	
}
