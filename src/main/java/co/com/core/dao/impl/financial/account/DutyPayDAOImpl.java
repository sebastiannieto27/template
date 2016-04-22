package co.com.core.dao.impl.financial.account;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.DutyPayDAO;
import co.com.core.domain.financial.account.BranchClient;
import co.com.core.domain.financial.account.DutyPay;

public class DutyPayDAOImpl implements DutyPayDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(DutyPayDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<DutyPay> getAll() {
			List<DutyPay> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("DutyPay.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [DutyPayDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<DutyPay> getAllFilter(Map<String, Object> filters) {
			List<DutyPay> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT d FROM DutyPay d ");

		        BranchClient branchClient = null;
		        String dutyPayNum = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					branchClient = (BranchClient) filters.get("branchClientId");
					dutyPayNum = (String) filters.get("dutyPayNum");
					
					if(branchClient!=null) {
						where = true;
						hql.append("WHERE ");
						hql.append(" d.branchClientId = :branchClientId ");
					}
					
					if(dutyPayNum!=null && !dutyPayNum.isEmpty()) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(branchClient!=null) {
							hql.append(" AND ");
						}
						
						hql.append(" lower(d.dutyPayNum) LIKE :dutyPayNum ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				 
				if(branchClient!=null) {
					query.setParameter("branchClientId", branchClient);
				}
				
				if(dutyPayNum!=null && !dutyPayNum.isEmpty()) {
					query.setParameter("dutyPayNum", "%"+dutyPayNum.toLowerCase()+"%");
				}
				
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [DutyPayDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public DutyPay create(DutyPay entity) {
			DutyPay newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (DutyPay) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [DutyPayDAOImpl.createDutyPay]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(DutyPay entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [DutyPayDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(DutyPay entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [DutyPayDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
