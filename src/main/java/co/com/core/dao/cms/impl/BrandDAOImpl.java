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
import org.springframework.util.StringUtils;

import co.com.core.commons.query.QueryUtil;
import co.com.core.dao.cms.BrandDAO;
import co.com.core.domain.cms.Brand;

public class BrandDAOImpl implements BrandDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(BrandDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<Brand> getAll() {
			List<Brand> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Brand.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BrandDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<Brand> getAllFilter(Map<String, Object> filters) {
			List<Brand> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM Brand b ");

				if(filters.size() > 0) {
					 Map<String, Object> queryData = new HashMap<String, Object>();
				        queryData.put("where", null);
				        queryData.put("property0", "b.brandName");
				        queryData.put("property0.value", ":brandName");
				        queryData.put("property0.conditional", "like");
				        queryData.put("property0.function", "lower");
				        
				        queryData.put("property1", "b.brandAddress");
				        queryData.put("property1.value", ":brandAddress");
				        queryData.put("property1.operation", "and");
				        queryData.put("property1.conditional", "like");
				        queryData.put("property1.function", "lower");
				        
				        StringBuilder sb = QueryUtil.buildQUery(queryData);
				        hql.append(sb.toString());
				}
				
				Query query = session.createQuery(hql.toString());
				 
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					String filterProperty = it.next();
                    Object filterValue = filters.get(filterProperty);
                    query.setParameter(filterProperty, "%"+filterValue+"%");
				}   
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BrandDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public Brand create(Brand entity) {
			Brand newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (Brand) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BrandDAOImpl.createBrand]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(Brand entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BrandDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(Brand entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BrandDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
