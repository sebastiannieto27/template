package co.com.core.dao.impl.financial.account;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.ClientTypeDAO;
import co.com.core.domain.financial.account.ClientType;

public class ClientTypeDAOImpl implements ClientTypeDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(ClientTypeDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<ClientType> getAll() {
			List<ClientType> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("ClientType.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ClientTypeDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<ClientType> getAllFilter(Map<String, Object> filters) {
			List<ClientType> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT c FROM ClientType c ");

		        String clientTypeName = null;
				if(filters.size() > 0) {
					 
					clientTypeName = (String) filters.get("clientTypeName");
					
					if(clientTypeName!=null && !clientTypeName.isEmpty()) {
						hql.append("WHERE ");
						hql.append(" lower(c.clientTypeName) LIKE :clientTypeName ");
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
				logger.error("Throwed Exception [ClientTypeDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public ClientType create(ClientType entity) {
			ClientType newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (ClientType) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ClientTypeDAOImpl.createClientType]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(ClientType entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ClientTypeDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(ClientType entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ClientTypeDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
