package co.com.core.dao.impl.financial.account;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.TaxDAO;
import co.com.core.domain.financial.account.Tax;

public class TaxDAOImpl implements TaxDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(TaxDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<Tax> getAll() {
			List<Tax> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Tax.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TaxDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<Tax> getAllFilter(Map<String, Object> filters) {
			List<Tax> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT t FROM Tax t ");

		        String taxName = null;
		        String taxIntCode = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					taxName = (String) filters.get("taxName");
					taxIntCode = (String) filters.get("taxIntCode");
					
					if(taxName!=null && !taxName.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append(" lower(t.taxName) LIKE :taxName ");
					}
					
					if(taxIntCode!=null && !taxIntCode.isEmpty()) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(taxName!=null && !taxName.isEmpty()) {
							hql.append(" AND ");
						}
						
						hql.append(" lower(t.taxIntCode) LIKE :taxIntCode ");
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
				logger.error("Throwed Exception [TaxDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public Tax create(Tax entity) {
			Tax newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (Tax) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TaxDAOImpl.createTax]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(Tax entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TaxDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(Tax entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TaxDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
