package co.com.core.dao.cms.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.cms.BranchServiceDAO;
import co.com.core.domain.cms.Branch;
import co.com.core.domain.cms.BranchService;
import co.com.core.domain.cms.Service;

public class BranchServiceDAOImpl implements BranchServiceDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(BranchServiceDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<BranchService> getAll() {
			List<BranchService> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("BranchService.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchServiceDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<BranchService> getAllFilter(Map<String, Object> filters) {
			List<BranchService> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM BranchService b ");

		        Branch branch = null;
		        Service service = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					branch = (Branch) filters.get("branchId");
					service = (Service) filters.get("serviceId");
					
					if(branch!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						hql.append(" b.branchId = :branchId ");
					}
					
					if(service!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(branch!=null) {
							hql.append(" AND ");
						}
						
						hql.append(" b.serviceId = :serviceId ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				
				if(branch!=null) {
					query.setParameter("branchId", filters.get("branchId"));
				}   
				 
				if(service!=null) {
					query.setParameter("serviceId", filters.get("serviceId"));
				}   
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchServiceDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}		

		@Override
		public void create(BranchService entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchServiceDAOImpl.createBranchService]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public void update(BranchService entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchServiceDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(BranchService entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BranchServiceDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
