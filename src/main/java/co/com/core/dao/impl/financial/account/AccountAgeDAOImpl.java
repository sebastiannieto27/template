package co.com.core.dao.impl.financial.account;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.AccountAgeDAO;
import co.com.core.domain.financial.account.AccountAge;

public class AccountAgeDAOImpl implements AccountAgeDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private static final Logger logger = Logger.getLogger(AccountAgeDAOImpl.class);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public List<AccountAge> getAll() {
		List<AccountAge> entityList = null;
		try {
			session = this.sessionFactory.openSession();
	        Query query = session.getNamedQuery("PagePermission.findAll");
	        entityList = query.list();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PagePermissionDAOImpl.getAll]: " +ex.getMessage());
		} finally {
			session.close();
		}
		return entityList;
	}
	
}
