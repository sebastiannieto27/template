package co.com.core.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.UserDAO;
import co.com.core.domain.User;


public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public User getUserById(Integer userID) {
		User user = null;
		try {
			session = this.sessionFactory.openSession();
			user = (User) session.get(User.class, userID);
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserDAOImpl.getUserById]: " +ex.getMessage());
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public User login(String userEmail, String userPassword) {
		User user = null;
		try {
			session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT u FROM User u WHERE u.email = '").append(userEmail).append("'");
			hql.append(" and u.password = '").append(userPassword).append("'");
			Query query = session.createQuery(hql.toString());
			List users = query.list();
			
			for(Iterator iterator = users.iterator(); iterator.hasNext();) {
				user = (User) iterator.next();
			}
			
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserDAOImpl.login]: " +ex.getMessage());
		} finally {
			session.close();
		}
		
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> Users = null;
		try {
			session = this.sessionFactory.openSession();
			Query query = session.getNamedQuery("User.findAll");
			Users = query.list();
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserDAOImpl.getAll]: " +ex.getMessage());
		}
		return Users;
	}

	@Override
	public void createUser(User user) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserDAOImpl.createUser]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(User user) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserDAOImpl.delete]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void update(User user) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
	        session.merge(user);
	        tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserDAOImpl.update]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public User getByMail(String userEmail) {
		User user = null;
		try {
			session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT u FROM User u WHERE u.email = '").append(userEmail).append("'");
			Query query = session.createQuery(hql.toString());
			List users = query.list();
			
			for(Iterator iterator = users.iterator(); iterator.hasNext();) {
				user = (User) iterator.next();
			}
			
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserDAOImpl.getByMail]: " +ex.getMessage());
		} finally {
			session.close();
		}
		
		return user;
	}

	@Override
	public List<User> getUserByName(String name) {
		List<User> entityList = null;
		try {
			session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT u FROM User u WHERE lower(u.completeName) LIKE :completeName");
	        Query query = session.createQuery(hql.toString());
	        query.setParameter("completeName", "%"+name+"%");
	        entityList = query.list();
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserDAOImpl.getUserByName]: " +ex.getMessage());
		} finally {
			session.close();
		}
		
		return entityList;
	}
	
	@Override
	public User getUserByDocNum(String idNumber) {
		User user = null;
		try {
			session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT u FROM User u WHERE u.idNumber = :idNumber");
	        Query query = session.createQuery(hql.toString());
	        query.setParameter("idNumber", idNumber);
	        List users = query.list();
	        
	        for(Iterator iterator = users.iterator(); iterator.hasNext();) {
				user = (User) iterator.next();
			}
	        
		} catch(Exception ex) {
			logger.error("Throwed Exception [UserDAOImpl.getUserByDocNum]: " +ex.getMessage());
		} finally {
			session.close();
		}
		
		return user;
	}
}
