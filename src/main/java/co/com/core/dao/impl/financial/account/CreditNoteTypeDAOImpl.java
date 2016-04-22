package co.com.core.dao.impl.financial.account;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.financial.account.CreditNoteTypeDAO;
import co.com.core.domain.financial.account.CreditNoteType;

public class CreditNoteTypeDAOImpl implements CreditNoteTypeDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(CreditNoteTypeDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<CreditNoteType> getAll() {
			List<CreditNoteType> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("CreditNoteType.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteTypeDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<CreditNoteType> getAllFilter(Map<String, Object> filters) {
			List<CreditNoteType> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT c FROM CreditNoteType c ");

		        String creditNotTypeName = null;
		        String productIntCode = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					creditNotTypeName = (String) filters.get("creditNotTypeName");
					
					if(creditNotTypeName!=null && !creditNotTypeName.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append(" lower(c.creditNotTypeName) LIKE :creditNotTypeName ");
					}
					
				}
				
				Query query = session.createQuery(hql.toString());
				 
				if(creditNotTypeName!=null && !creditNotTypeName.isEmpty()) {
					query.setParameter("creditNotTypeName", "%"+creditNotTypeName.toLowerCase()+"%");
				}
				
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteTypeDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public CreditNoteType create(CreditNoteType entity) {
			CreditNoteType newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (CreditNoteType) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteTypeDAOImpl.createCreditNoteType]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(CreditNoteType entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteTypeDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(CreditNoteType entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CreditNoteTypeDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
