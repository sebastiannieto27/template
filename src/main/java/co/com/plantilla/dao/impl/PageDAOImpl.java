package co.com.plantilla.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.plantilla.dao.PageDAO;
import co.com.plantilla.domain.Page;


public class PageDAOImpl implements PageDAO{
	
    private SessionFactory sessionFactory;
    private Session session;
    
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
			//TODO logger
		} finally {
			session.close();
		}
		return pages;
	}

	@Override
	public void createPage(Page page) {
		/*try {
			session = HibernateUtil.getSessionFactory().openSession(); 
			session.beginTransaction();
			session.save(page);
			session.getTransaction().commit();
		} catch(Exception ex) {
			//TODO
			session.getTransaction().rollback();
		} finally {
			session.close();
		}*/
	}

	@Override
	public void delete(Page page) {
		/*try {
			session = HibernateUtil.getSessionFactory().openSession(); 
			session.beginTransaction();
			Query query = session.createQuery("delete Page p where p.pageId = :pageId");
			query.setParameter("pageId", page.getPageId());
			query.executeUpdate();
			session.getTransaction().commit();
		} catch(Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}*/
	}

	@Override
	public void update(Page page) {
		/*try {
			session = HibernateUtil.getSessionFactory().openSession(); 
			session.beginTransaction();
			session.merge(page);
			session.getTransaction().commit();
		} catch(Exception ex) {
			session.getTransaction().rollback();
		} */
	}

}
