package co.com.core.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.RolePermissionDAO;
import co.com.core.domain.PagePermission;
import co.com.core.domain.Role;
import co.com.core.domain.RoleMenu;
import co.com.core.domain.RolePermission;

public class RolePermissionDAOImpl implements RolePermissionDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(RolePermissionDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<RolePermission> getAll() {
			List<RolePermission> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("RolePermission.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RolePermissionDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public void create(RolePermission entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RolePermissionDAOImpl.createRolePermission]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public void update(RolePermission entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RolePermissionDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		@Override
		public void delete(RolePermission entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RolePermissionDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}


		@Override
		public List<RolePermission> findByRole(Role role) {
			List<RolePermission> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("RolePermission.findByRoleId");
		        query.setParameter("roleId", role);
		        entityList = query.list();
		        
			} catch(Exception ex) {
				logger.error("Throwed Exception [RolePermissionDAOImpl.findByRole]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}


		@Override
		public RolePermission findByRolePagePermission(Role role, PagePermission pagePermission) {
			RolePermission entity = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("RolePermission.findByRolePagePermissionId");
		        query.setParameter("roleId", role);
		        query.setParameter("pagePermissionId", pagePermission);
		        List<RolePermission> entityList = query.list();
		        
		        if(entityList!=null && entityList.size()>0) {
		        	 for(RolePermission rolePermission : entityList) {
		        		 entity = rolePermission;
			        }
		        }
		        
			} catch(Exception ex) {
				logger.error("Throwed Exception [RolePermissionDAOImpl.findByRolePagePermission]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entity;
		}
}
