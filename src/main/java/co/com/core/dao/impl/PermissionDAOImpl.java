package co.com.core.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.PermissionDAO;
import co.com.core.domain.Menu;
import co.com.core.domain.PagePermission;
import co.com.core.domain.Permission;

public class PermissionDAOImpl implements PermissionDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(PermissionDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<Permission> getAll() {
			List<Permission> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Permission.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PermissionDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public void create(Permission entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PermissionDAOImpl.createPermission]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public void update(Permission entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PermissionDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		@Override
		public void delete(Permission entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PermissionDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}


		@Override
		public List<Permission> getNotAssignedPermission(String ids) {
			List<Permission> permissionList = null;
			try {
				session = this.sessionFactory.openSession();
				StringBuilder hql = new StringBuilder();
				if(ids!=null && !ids.isEmpty()) {
					hql.append("SELECT p FROM Permission p WHERE p.permissionId NOT IN(").append(ids).append(")");
				} else {
					hql.append("SELECT p FROM Permission p");
				}
				
				Query query = session.createQuery(hql.toString());
				permissionList = query.list();
				
			} catch(Exception ex) {
				logger.error("Throwed Exception [PermissionDAOImpl.getNotAssignedMenu]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return permissionList;
		}


		@Override
		public Permission getByCode(String code) {
			Permission entity = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Permission.findByCode");
		        query.setParameter("code", code);
		        List entityList = query.list();
		        
		        for(Iterator iterator = entityList.iterator(); iterator.hasNext();) {
		        	entity = (Permission) iterator.next();
				}
			} catch(Exception ex) {
				logger.error("Throwed Exception [PermissionDAOImpl.getByCode]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entity;
		}
}
