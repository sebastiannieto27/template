package co.com.core.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.PagePermissionDAO;
import co.com.core.domain.Page;
import co.com.core.domain.PagePermission;
import co.com.core.domain.Permission;

public class PagePermissionDAOImpl implements PagePermissionDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(PagePermissionDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<PagePermission> getAll() {
			List<PagePermission> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("PagePermission.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PagePermissionDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public void create(PagePermission entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PagePermissionDAOImpl.createPagePermission]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public void update(PagePermission entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PagePermissionDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(PagePermission entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PagePermissionDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public List<PagePermission> getNotAssignedPermission(String ids) {
			List<PagePermission> permissionList = null;
			try {
				session = this.sessionFactory.openSession();
				StringBuilder hql = new StringBuilder();
				if(ids!=null && !ids.isEmpty()) {
					hql.append("SELECT p FROM PagePermission p WHERE p.idPagePermission NOT IN(").append(ids).append(")");
				} else {
					hql.append("SELECT p FROM PagePermission p");
				}
				
				Query query = session.createQuery(hql.toString());
				permissionList = query.list();
				
			} catch(Exception ex) {
				logger.error("Throwed Exception [PagePermissionDAOImpl.getNotAssignedMenu]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return permissionList;
		}

		@Override
		public PagePermission getPermissionByPageCode(Page page, Permission permission) {
			PagePermission pagePermission = null;
			
			try {
				if(page!=null && permission!=null) {
					session = this.sessionFactory.openSession();
					StringBuilder hql = new StringBuilder();
					hql.append("SELECT p FROM PagePermission p WHERE p.permissionId = :permissionId ");
					hql.append(" AND p.pageId = :pageId ");
					Query query = session.createQuery(hql.toString());
					query.setParameter("permissionId", permission);
					query.setParameter("pageId", page);
					List permissionList = query.list();
					for(Iterator iterator = permissionList.iterator(); iterator.hasNext();) {
						pagePermission = (PagePermission) iterator.next();
					}
				}
			} catch(Exception ex) {
				logger.error("Throwed Exception [PagePermissionDAOImpl.getPermissionByPageCode]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return pagePermission;
		}
}
