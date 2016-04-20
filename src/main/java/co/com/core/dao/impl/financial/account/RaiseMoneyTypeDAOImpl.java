package co.com.core.dao.impl.financial.account;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.RaiseMoneyTypeDAO;
import co.com.core.domain.financial.account.RaiseMoneyType;

public class RaiseMoneyTypeDAOImpl implements RaiseMoneyTypeDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(RaiseMoneyTypeDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<RaiseMoneyType> getAll() {
			List<RaiseMoneyType> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("RaiseMoneyType.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyTypeDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<RaiseMoneyType> getAllFilter(Map<String, Object> filters) {
			List<RaiseMoneyType> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT r FROM RaiseMoneyType r ");

		        String raiseMonTypeName = null;
				if(filters.size() > 0) {
					 
					raiseMonTypeName = (String) filters.get("raiseMonTypeName");
					
					if(raiseMonTypeName!=null && !raiseMonTypeName.isEmpty()) {
						hql.append("WHERE ");
						hql.append(" lower(r.raiseMonTypeName) LIKE :raiseMonTypeName ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				 
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty).toString();
                    query.setParameter(filterProperty, "%"+filterValue.toLowerCase()+"%");
				}   
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyTypeDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public RaiseMoneyType create(RaiseMoneyType entity) {
			RaiseMoneyType newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (RaiseMoneyType) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyTypeDAOImpl.createRaiseMoneyType]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(RaiseMoneyType entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyTypeDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(RaiseMoneyType entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyTypeDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
