package co.com.core.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.PageDAO;
import co.com.core.domain.Page;


public class PageDAOImpl implements PageDAO{
	
    private SessionFactory sessionFactory;
    private Session session;
    private static final Logger logger = Logger.getLogger(PageDAOImpl.class);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	
	@Override
	public List<Page> getAll() {
		List<Page> pages = null;
		try {
			session = this.sessionFactory.openSession();
	        Query query = session.getNamedQuery("Page.findAll");
			pages = query.list();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PageDAOImpl.getAll]: " +ex.getMessage());
		} finally {
			session.close();
		}
		return pages;
	}

	@Override
	public void createPage(Page page) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(page);
			tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PageDAOImpl.createPage]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Page page) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
	        session.merge(page);
	        tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PageDAOImpl.update]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	@Override
	public void delete(Page page) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(page);
			tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PageDAOImpl.delete]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}


	@Override
	public List<Page> getPageByURL(String url) {
		List<Page> pages = null;
		try {
			session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT p FROM Page p WHERE p.realUrl LIKE :realUrl");
	        Query query = session.createQuery(hql.toString());
	        query.setParameter("realUrl", "%"+url+"%");
	        pages = query.list();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PageDAOImpl.getPageByURL]: " +ex.getMessage());
		} finally {
			session.close();
		}
		
		return pages;
	}
}
