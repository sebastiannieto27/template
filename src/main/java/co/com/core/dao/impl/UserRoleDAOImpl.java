package co.com.core.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.UserRoleDAO;
import co.com.core.domain.RolePermission;
import co.com.core.domain.User;
import co.com.core.domain.UserRole;

public class UserRoleDAOImpl implements UserRoleDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(UserRoleDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<UserRole> getAll() {
			List<UserRole> userRoles = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("UserRole.findAll");
		        userRoles = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [UserRoleDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return userRoles;
		}

		@Override
		public void createUserRole(UserRole userRole) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(userRole);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [UserRoleDAOImpl.createUserRole]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public void update(UserRole userRole) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(userRole);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [UserRoleDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		@Override
		public void delete(UserRole userRole) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(userRole);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [UserRoleDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}


		@Override
		public List<UserRole> findByUser(User user) {
			List<UserRole> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("UserRole.findByUserId");
		        query.setParameter("userId", user);
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [UserRoleDAOImpl.findByUser]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
}
