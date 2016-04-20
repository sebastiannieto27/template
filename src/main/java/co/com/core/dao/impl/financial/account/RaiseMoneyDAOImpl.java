package co.com.core.dao.impl.financial.account;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.RaiseMoneyDAO;
import co.com.core.domain.financial.account.BranchClient;
import co.com.core.domain.financial.account.RaiseMoney;
import co.com.core.domain.financial.account.RaiseMoneyType;

public class RaiseMoneyDAOImpl implements RaiseMoneyDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(RaiseMoneyDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<RaiseMoney> getAll() {
			List<RaiseMoney> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("RaiseMoney.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<RaiseMoney> getAllFilter(Map<String, Object> filters) {
			List<RaiseMoney> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT r FROM RaiseMoney r ");

		        BranchClient branchClient = null;
		        RaiseMoneyType raiseMoneyType = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					branchClient = (BranchClient) filters.get("branchClient");
					raiseMoneyType = (RaiseMoneyType) filters.get("raiseMoneyType");
					
					if(branchClient!=null) {
						where = true;
						hql.append("WHERE ");
						hql.append(" r.branchClient = :branchClient ");
					}
					
					if(raiseMoneyType!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(branchClient!=null) {
							hql.append(" AND ");
						}
						
						
						hql.append(" r.raiseMoneyType = :raiseMoneyType ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				
				if(branchClient!=null) {
					query.setParameter("branchClient", filters.get("branchClient"));
				}  
				 
				if(raiseMoneyType!=null) {
					query.setParameter("raiseMoneyType", filters.get("raiseMoneyType"));
				}  
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public RaiseMoney create(RaiseMoney entity) {
			RaiseMoney newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (RaiseMoney) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyDAOImpl.createRaiseMoney]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(RaiseMoney entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(RaiseMoney entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RaiseMoneyDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
