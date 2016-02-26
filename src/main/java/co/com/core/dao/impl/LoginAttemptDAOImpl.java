package co.com.core.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.commons.ApplicationConstants;
import co.com.core.commons.ApplicationUtil;
import co.com.core.dao.LoginAttemptDAO;
import co.com.core.domain.LoginAttempt;

public class LoginAttemptDAOImpl implements LoginAttemptDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(LoginAttemptDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		
		@Override
		public List<LoginAttempt> getAll() {
			List<LoginAttempt> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("LoginAttempt.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [LoginAttemptDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public void create(LoginAttempt entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [LoginAttemptDAOImpl.createLoginAttempt]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public void update(LoginAttempt entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.merge(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [LoginAttemptDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(LoginAttempt entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [LoginAttemptDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}


		@Override
		public Long invalidLoginAttemps(String userMail) {
			Long count = null;
			try {
				StringBuilder hql = new StringBuilder();
				
				String endStr = ApplicationUtil.getFormattedDate(new Date(), ApplicationConstants.SIMPLE_DATE_FORMAT, ApplicationConstants.END_OF_DAY_TIME);
				String startStr = ApplicationUtil.getFormattedDate(new Date(), ApplicationConstants.SIMPLE_DATE_FORMAT, ApplicationConstants.START_OF_DAY_TIME);
				
				Date startDate = ApplicationUtil.getDateFromString(startStr, ApplicationConstants.FULL_DATE_FORMAT);
				Timestamp startTime = new java.sql.Timestamp(startDate.getTime());
				Date endDate = ApplicationUtil.getDateFromString(endStr, ApplicationConstants.FULL_DATE_FORMAT);
				Timestamp endTime = new java.sql.Timestamp(endDate.getTime());
				
				hql.append("SELECT COUNT(*) FROM LoginAttempt l WHERE l.userMail=:userMail ");
				hql.append("AND  l.validAttempt=:validAttempt ");
				hql.append("AND l.dateAttempt BETWEEN :startDate AND :endDate ");
				
				session = this.sessionFactory.openSession();
		        Query query = session.createQuery(hql.toString());
		        query.setParameter("userMail", userMail);
		        query.setParameter("validAttempt", (short)0);
		        query.setParameter("startDate", startTime);
		        query.setParameter("endDate", endTime);
		        
		        count = (Long) query.uniqueResult();
		        
			} catch (Exception ex) {
				logger.error("Throwed Exception [LoginAttemptDAOImpl.invalidLoginAttemps]: " +ex.getMessage());
			} finally {
				session.close();
			}
			
			return count;
		}
}
