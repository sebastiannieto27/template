package co.com.core.dao.cms.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.cms.NewsDAO;
import co.com.core.domain.cms.News;
import co.com.core.domain.cms.NewsType;

public class NewsDAOImpl implements NewsDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(NewsDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<News> getAll() {
			List<News> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("News.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [NewsDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public List<News> getAllFilter(Map<String, Object> filters) {
			List<News> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT n FROM News n ");

		        String newsTitle = null;
		        NewsType type = null;
		        
		        boolean where = false;
				if(filters.size() > 0) {
					 
					newsTitle = (String) filters.get("newsTitle");
					type = (NewsType) filters.get("newsTypeId");
					
					if(newsTitle!=null && !newsTitle.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append(" lower(n.newsTitle) LIKE :newsTitle ");
					}
					
					if(type!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(newsTitle!=null && !newsTitle.isEmpty()) {
							hql.append(" AND ");
						}
						
						
						hql.append(" n.newsTypeId = :newsTypeId ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				 
				if(newsTitle!=null && !newsTitle.isEmpty()) {
					query.setParameter("newsTitle", "%"+filters.get("newsTitle").toString().toLowerCase()+"%");
				}
				if(type!=null) {
					query.setParameter("newsTypeId", filters.get("newsTypeId"));
				}
				
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [NewsDAOImpl.getAllFilter]:  " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public void create(News entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [NewsDAOImpl.createNews]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public void update(News entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [NewsDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(News entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [NewsDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
