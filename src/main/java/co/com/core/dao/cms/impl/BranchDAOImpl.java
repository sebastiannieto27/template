package co.com.core.dao.cms.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.util.StringUtils;

import co.com.core.commons.query.QueryUtil;
import co.com.core.dao.cms.BranchDAO;
import co.com.core.domain.cms.Branch;;

public class BranchDAOImpl implements BranchDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(BranchDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<Branch> getAll() {
			List<Branch> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Branch.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<Branch> getAllFilter(Map<String, Object> filters) {
			List<Branch> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM Branch b ");

		        String branchName = null;
		        String branchAddress = null;
		        String branchInternalCode = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					branchName = (String) filters.get("branchName");
					branchAddress = (String) filters.get("branchAddress");
					branchInternalCode = (String) filters.get("branchInternalCode");
					
					if(branchName!=null && !branchName.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append(" lower(b.branchName) LIKE :branchName ");
					}
					
					if(branchAddress!=null && !branchAddress.isEmpty()) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(branchName!=null && !branchName.isEmpty()) {
							hql.append(" AND ");
						}
						
						hql.append(" lower(b.branchAddress) LIKE :branchAddress ");
					}
					
					if(branchInternalCode!=null && !branchInternalCode.isEmpty()) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if((branchName!=null && !branchName.isEmpty()) || (branchAddress!=null && !branchAddress.isEmpty())) {
							hql.append(" AND ");
						}
						
						hql.append(" lower(b.branchInternalCode) LIKE :branchInternalCode ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				 
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty).toString();
                    query.setParameter(filterProperty, "%"+filterValue.toLowerCase()+"%");
				}   
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public Branch create(Branch entity) {
			Branch newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (Branch) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchDAOImpl.createBranch]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(Branch entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(Branch entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
