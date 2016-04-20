package co.com.core.dao.cms.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.commons.query.QueryUtil;
import co.com.core.dao.cms.CompanyEventDAO;
import co.com.core.domain.cms.Brand;
import co.com.core.domain.cms.CompanyEvent;

public class CompanyEventDAOImpl implements CompanyEventDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(CompanyEventDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<CompanyEvent> getAll() {
			List<CompanyEvent> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("CompanyEvent.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CompanyEventDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<CompanyEvent> getAllFilter(Map<String, Object> filters) {
			List<CompanyEvent> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT c FROM CompanyEvent c ");

		        String companyEventTitle = null;
		        String companyEventLocation = null;
		        boolean where = false;

		        if(filters.size() > 0) {
					 
		        	companyEventTitle = (String) filters.get("companyEventTitle");
		        	companyEventLocation = (String) filters.get("companyEventLocation");
					
					if(companyEventTitle!=null && !companyEventTitle.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append(" lower(c.companyEventTitle) LIKE :companyEventTitle ");
					}
					
					if(companyEventLocation!=null && !companyEventLocation.isEmpty()) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(companyEventTitle!=null && !companyEventTitle.isEmpty()) {
							hql.append(" AND ");
						}
						
						hql.append(" lower(c.companyEventLocation) LIKE :companyEventLocation ");
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
				logger.error("Throwed Exception [CompanyEventDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		
		@Override
		public void create(CompanyEvent entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CompanyEventDAOImpl.createCompanyEvent]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public void update(CompanyEvent entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CompanyEventDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(CompanyEvent entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CompanyEventDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
