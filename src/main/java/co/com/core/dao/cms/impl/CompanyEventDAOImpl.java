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

				if(filters.size() > 0) {
				 	/*Map<String, Object> queryData = new HashMap<String, Object>();
			        queryData.put("where", null);
			        queryData.put("property0", "c.companyEventTitle");
			        queryData.put("property0.value", ":companyEventTitle");
			        queryData.put("property0.conditional", "like");
			        queryData.put("property0.function", "lower");
			        //TODO
			        queryData.put("property1", "c.companyEventLocation");
			        queryData.put("property1.value", ":companyEventLocation");
			        queryData.put("property1.operation", "and");
			        queryData.put("property1.conditional", "like");
			        queryData.put("property1.function", "lower");*/
				        
			        StringBuilder sb = QueryUtil.buildQUery(filters);
			        hql.append(sb.toString());
				}
				
				Query query = session.createQuery(hql.toString());
				if(filters.size() > 0) {
					for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
						String key = it.next();
	                    
	                    if(key.contains("queryParam")) {
	                    	String[] value = filters.get(key).toString().split("/");
	                    	query.setParameter(value[0], value[1]);
	                    }
					} 
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
