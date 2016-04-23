package co.com.core.dao.impl.financial.account;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.CreditNoteDAO;
import co.com.core.domain.financial.account.BillHead;
import co.com.core.domain.financial.account.BranchClient;
import co.com.core.domain.financial.account.CreditNote;
import co.com.core.domain.financial.account.CreditNoteType;

public class CreditNoteDAOImpl implements CreditNoteDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(CreditNoteDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<CreditNote> getAll() {
			List<CreditNote> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("CreditNote.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<CreditNote> getAllFilter(Map<String, Object> filters) {
			List<CreditNote> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT c FROM CreditNote c ");

		        String creditNotNum = null;
		        BranchClient branchClientId = null;
		        BillHead billHeadId = null;
		        CreditNoteType creditNoteTypeId = null;
		        boolean where = false;
		        boolean and = false;
				if(filters.size() > 0) {
					 
					creditNotNum = (String) filters.get("creditNotNum");
					branchClientId = (BranchClient) filters.get("branchClientId");
					billHeadId = (BillHead) filters.get("billHeadId");
					creditNoteTypeId = (CreditNoteType) filters.get("creditNoteTypeId");
					
					if(creditNotNum!=null && !creditNotNum.isEmpty()) {
						where = true;
						and = true;
						hql.append("WHERE ");
						hql.append(" lower(c.creditNotNum) LIKE :creditNotNum ");
					}
					
					if(branchClientId!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						and = true;
						hql.append(" c.branchClientId = :branchClientId ");
					}
					
					if(billHeadId!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						and = true;
						hql.append(" c.billHeadId = :billHeadId ");
					}
					
					if(creditNoteTypeId!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(and) {
							hql.append(" AND ");
						}
						and = true;
						hql.append(" c.creditNoteTypeId = :creditNoteTypeId ");
					}
					
				}
				
				Query query = session.createQuery(hql.toString());
				
				if(creditNotNum!=null && !creditNotNum.isEmpty()) {
					query.setParameter("creditNotNum", "%"+creditNotNum.toLowerCase()+"%");
				}
				
				if(branchClientId!=null) {
					query.setParameter("branchClientId", branchClientId);
				}
				
				if(billHeadId!=null) {
					query.setParameter("billHeadId", billHeadId);
				}
				 
				if(creditNoteTypeId!=null) {
					query.setParameter("creditNoteTypeId", creditNoteTypeId);
				}
				
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public CreditNote create(CreditNote entity) {
			CreditNote newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (CreditNote) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteDAOImpl.createCreditNote]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(CreditNote entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(CreditNote entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
