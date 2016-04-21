package co.com.core.dao.impl.financial.account;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.ClientDAO;
import co.com.core.domain.financial.account.Client;
import co.com.core.domain.financial.account.ClientType;

public class ClientDAOImpl implements ClientDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(ClientDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<Client> getAll() {
			List<Client> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Client.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ClientDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<Client> getAllFilter(Map<String, Object> filters) {
			List<Client> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT c FROM Client c ");

		        String clientName = null;
		        String clientIntCode = null;
		        String clientNumId = null;
		        String clientMail = null;
		        ClientType clientType = null;//TODO
		        boolean where = false;
		        boolean and = false;
				if(filters.size() > 0) {
					 
					clientName = (String) filters.get("clientName");
					clientIntCode = (String) filters.get("clientIntCode");
					clientNumId = (String) filters.get("clientNumId");
					clientMail = (String) filters.get("clientMail");
					
					if(clientName!=null && !clientName.isEmpty()) {
						where = true;
						and = true;
						hql.append("WHERE ");
						hql.append(" lower(c.clientName) LIKE :clientName ");
					}
					
					if(clientIntCode!=null && !clientIntCode.isEmpty()) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						and = true;
						hql.append(" lower(c.clientIntCode) LIKE :clientIntCode ");
					}
					
					if(clientNumId!=null && !clientNumId.isEmpty()) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						
						hql.append(" lower(c.clientNumId) LIKE :clientNumId ");
					}
					
					if(clientMail!=null && !clientMail.isEmpty()) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						
						hql.append(" lower(c.clientMail) LIKE :clientMail ");
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
				logger.error("Throwed Exception [ClientDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public Client create(Client entity) {
			Client newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (Client) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ClientDAOImpl.createClient]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(Client entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ClientDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(Client entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ClientDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
