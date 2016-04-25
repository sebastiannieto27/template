package co.com.core.dao.impl.financial.account;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.BillDetailTaxDAO;
import co.com.core.domain.financial.account.BillDetail;
import co.com.core.domain.financial.account.BillDetailTax;
import co.com.core.domain.financial.account.Tax;

public class BillDetailTaxDAOImpl implements BillDetailTaxDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(BillDetailTaxDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<BillDetailTax> getAll() {
			List<BillDetailTax> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("BillDetailTax.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailTaxDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<BillDetailTax> getAllFilter(Map<String, Object> filters) {
			List<BillDetailTax> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM BillDetailTax b ");

		        Tax taxId = null;
		        BillDetail billDetailId = null;
		        boolean where = false;
		        boolean and = false;
				if(filters.size() > 0) {
					 
					taxId = (Tax) filters.get("taxId");
					billDetailId = (BillDetail) filters.get("billDetailId");
					
					if(taxId!=null) {
						where = true;
						and = true;
						hql.append("WHERE ");
						hql.append(" b.taxId = :taxId ");
					}
					
					if(billDetailId!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						and = true;
						hql.append(" b.billDetailId = :billDetailId ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				
				if(taxId!=null) {
					query.setParameter("taxId", filters.get("taxId"));
				}     
				 
				if(billDetailId!=null) {
					query.setParameter("billDetailId", filters.get("billDetailId"));
				}     
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailTaxDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public BillDetailTax create(BillDetailTax entity) {
			BillDetailTax newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (BillDetailTax) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailTaxDAOImpl.createBillDetailTax]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(BillDetailTax entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailTaxDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(BillDetailTax entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [BillDetailTaxDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
