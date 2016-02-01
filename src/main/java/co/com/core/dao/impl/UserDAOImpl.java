package co.com.core.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.UserDAO;
import co.com.core.domain.User;


public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;
    private Session session;
    
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
			//TODO
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
			ex.printStackTrace();
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
			//TODO
		}
		return Users;
	}

	@Override
	public void createUser(User user) {
		try {
			System.out.println(user);
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch(Exception ex) {
			//TODO
			ex.printStackTrace();
			System.out.println("Error user: " + ex.getMessage());
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
			Query query = session.createQuery("delete User p where p.UserId = :UserId");
			query.setParameter("UserId", user.getUserId());
			query.executeUpdate();
			tx.commit();
		} catch(Exception ex) {
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
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

}
