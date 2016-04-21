package co.com.core.dao.impl.financial.account;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.BillHeadDAO;
import co.com.core.domain.cms.GeneralStatus;
import co.com.core.domain.financial.account.BillHead;
import co.com.core.domain.financial.account.BranchClient;

public class BillHeadDAOImpl implements BillHeadDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(BillHeadDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<BillHead> getAll() {
			List<BillHead> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("BillHead.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillHeadDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<BillHead> getAllFilter(Map<String, Object> filters) {
			List<BillHead> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM BillHead b ");

		        BranchClient branchClient = null;
		        GeneralStatus generalStatus = null;
		        boolean where = false;
		        boolean and = false;
				if(filters.size() > 0) {
					 
					branchClient = (BranchClient) filters.get("branchClientId");
					generalStatus = (GeneralStatus) filters.get("generalStatusId");
					
					if(branchClient!=null) {
						where = true;
						hql.append("WHERE ");
						hql.append(" b.branchClientId = :branchClientId ");
						and = true;
					}
					
					if(generalStatus!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						
						hql.append(" b.generalStatusId = :generalStatusId ");
						and = true;
					}
					
				}
				Query query = session.createQuery(hql.toString());
				 
				if(branchClient!=null) {
					query.setParameter("branchClientId", filters.get("branchClientId"));
				}
				
				if(generalStatus!=null) {
					query.setParameter("generalStatusId", filters.get("generalStatus"));
				}
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillHeadDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public BillHead create(BillHead entity) {
			BillHead newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (BillHead) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillHeadDAOImpl.createBillHead]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(BillHead entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillHeadDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(BillHead entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillHeadDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
