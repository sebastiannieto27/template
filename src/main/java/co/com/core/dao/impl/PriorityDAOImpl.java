package co.com.core.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.PriorityDAO;
import co.com.core.domain.Priority;

public class PriorityDAOImpl implements PriorityDAO {
	
	private SessionFactory sessionFactory;
    private Session session;
    private static final Logger logger = Logger.getLogger(PriorityDAOImpl.class);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public List<Priority> getAll() {
		List<Priority> entityList = null;
		try {
			session = this.sessionFactory.openSession();
	        Query query = session.getNamedQuery("Priority.findAll");
	        entityList = query.list();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PriorityDAOImpl.getAll]: " +ex.getMessage());
		} finally {
			session.close();
		}
		return entityList;
	}

	@Override
	public void create(Priority entity) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PriorityDAOImpl.createPriority]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Priority entity) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
	        session.merge(entity);
	        tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PriorityDAOImpl.update]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	@Override
	public void delete(Priority entity) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [PriorityDAOImpl.delete]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
}
