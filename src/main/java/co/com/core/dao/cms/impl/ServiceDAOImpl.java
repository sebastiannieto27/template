package co.com.core.dao.cms.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.cms.ServiceDAO;
import co.com.core.domain.cms.GeneralStatus;
import co.com.core.domain.cms.Service;

public class ServiceDAOImpl implements ServiceDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(ServiceDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<Service> getAll() {
			List<Service> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Service.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ServiceDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<Service> getAllFilter(Map<String, Object> filters) {
			List<Service> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT s FROM Service s ");

		        String serviceName = null;
		        GeneralStatus serviceStatus = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					serviceName = (String) filters.get("serviceName");
					serviceStatus = (GeneralStatus) filters.get("generalStatusId");
					
					if(serviceName!=null && !serviceName.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append("lower(s.serviceName) LIKE :serviceName");
					}
					
					if(serviceStatus!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						hql.append("s.generalStatusId = :generalStatusId");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				 
				if(serviceName!=null && !serviceName.isEmpty()) {
					query.setParameter("serviceName", "%"+filters.get("serviceName").toString().toLowerCase()+"%");
				}
				if(serviceStatus!=null) {
					query.setParameter("generalStatusId", filters.get("generalStatusId"));
				}  
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ServiceDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public void create(Service entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ServiceDAOImpl.createService]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public void update(Service entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ServiceDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(Service entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ServiceDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
