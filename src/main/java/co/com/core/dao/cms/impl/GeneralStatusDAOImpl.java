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
import co.com.core.dao.cms.GeneralStatusDAO;
import co.com.core.domain.cms.GeneralStatus;

public class GeneralStatusDAOImpl implements GeneralStatusDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(GeneralStatusDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<GeneralStatus> getAll() {
			List<GeneralStatus> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("GeneralStatus.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [GeneralStatusDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<GeneralStatus> getAllFilter(Map<String, Object> filters) {
			List<GeneralStatus> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM GeneralStatus b ");

				if(filters.size() > 0) {
					 Map<String, Object> queryData = new HashMap<String, Object>();
				        queryData.put("where", null);
				        queryData.put("property0", "b.GeneralStatusName");
				        queryData.put("property0.value", ":GeneralStatusName");
				        queryData.put("property0.conditional", "like");
				        queryData.put("property0.function", "lower");
				        
				        queryData.put("property1", "b.GeneralStatusAddress");
				        queryData.put("property1.value", ":GeneralStatusAddress");
				        queryData.put("property1.operation", "and");
				        queryData.put("property1.conditional", "like");
				        queryData.put("property1.function", "lower");
				        
				        StringBuilder sb = QueryUtil.buildQUery(queryData);
				        hql.append(sb.toString());
				}
				
				/*
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					String filterProperty = it.next();
                    Object filterValue = filters.get(filterProperty);
                    
                    if(StringUtils.hasText(filterProperty) && filterValue != null) {
                    	hql.append(" lower(b.").append(filterProperty).append(") ").append("LIKE :").append(filterProperty);
                    }
				}*/
				
				Query query = session.createQuery(hql.toString());
				 
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					String filterProperty = it.next();
                    Object filterValue = filters.get(filterProperty);
                    query.setParameter(filterProperty, "%"+filterValue+"%");
				}   
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [GeneralStatusDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public GeneralStatus create(GeneralStatus entity) {
			GeneralStatus newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (GeneralStatus) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [GeneralStatusDAOImpl.createGeneralStatus]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(GeneralStatus entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [GeneralStatusDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(GeneralStatus entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [GeneralStatusDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
