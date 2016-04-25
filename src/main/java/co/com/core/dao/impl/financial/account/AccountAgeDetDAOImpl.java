package co.com.core.dao.impl.financial.account;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.AccountAgeDetDAO;
import co.com.core.domain.financial.account.AccountAge;
import co.com.core.domain.financial.account.AccountAgeDet;
import co.com.core.domain.financial.account.AccountAgeType;

public class AccountAgeDetDAOImpl implements AccountAgeDetDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(AccountAgeDetDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<AccountAgeDet> getAll() {
			List<AccountAgeDet> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("AccountAgeDet.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AccountAgeDetDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<AccountAgeDet> getAllFilter(Map<String, Object> filters) {
			List<AccountAgeDet> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT a FROM AccountAgeDet a ");

		        AccountAge accountAge = null;
		        AccountAgeType accountAgeType = null;
		        
		        boolean where = false;
		        boolean and = false;
				if(filters.size() > 0) {
					 
					accountAge = (AccountAge) filters.get("accountAgeId");
					accountAgeType = (AccountAgeType) filters.get("accountAgeTypeId");
					
					if(accountAge!=null) {
						where = true;
						hql.append("WHERE ");
						hql.append(" a.accountAgeId = :accountAgeId ");
						and = true;
					}
					
					if(accountAgeType!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						
						hql.append(" a.accountAgeTypeId = :accountAgeTypeId ");
						and = true;
					}
					
				}
				Query query = session.createQuery(hql.toString());
				 
				if(accountAge!=null) {
					query.setParameter("accountAgeId", filters.get("accountAgeId"));
				}
				
				if(accountAgeType!=null) {
					query.setParameter("accountAgeTypeId", filters.get("accountAgeTypeId"));
				}
		        
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AccountAgeDetDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public AccountAgeDet create(AccountAgeDet entity) {
			AccountAgeDet newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (AccountAgeDet) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AccountAgeDetDAOImpl.createAccountAgeDet]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(AccountAgeDet entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AccountAgeDetDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(AccountAgeDet entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AccountAgeDetDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
