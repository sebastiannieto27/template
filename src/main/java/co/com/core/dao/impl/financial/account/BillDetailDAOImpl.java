package co.com.core.dao.impl.financial.account;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.BillDetailDAO;
import co.com.core.domain.financial.account.BillDetail;
import co.com.core.domain.financial.account.BillHead;
import co.com.core.domain.financial.account.Product;

public class BillDetailDAOImpl implements BillDetailDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(BillDetailDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<BillDetail> getAll() {
			List<BillDetail> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("BillDetail.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<BillDetail> getAllFilter(Map<String, Object> filters) {
			List<BillDetail> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM BillDetail b ");

		        BillHead billHeadId = null;
		        Product productId = null;
		        boolean where = false;
		        boolean and = false;
				if(filters.size() > 0) {
					 
					billHeadId = (BillHead) filters.get("billHeadId");
					productId = (Product) filters.get("productId");
					
					if(billHeadId!=null) {
						where = true;
						and = true;
						hql.append("WHERE ");
						hql.append(" b.billHeadId = :billHeadId ");
					}
					
					if(productId!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						and = true;
						hql.append(" b.productId = :productId ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				
				if(billHeadId!=null) {
					query.setParameter("billHeadId", filters.get("billHeadId"));
				}     
				 
				if(productId!=null) {
					query.setParameter("productId", filters.get("productId"));
				}     
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailDAOImpl.getAllFilter]: " + ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public BillDetail create(BillDetail entity) {
			BillDetail newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (BillDetail) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailDAOImpl.createBillDetail]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(BillDetail entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(BillDetail entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
