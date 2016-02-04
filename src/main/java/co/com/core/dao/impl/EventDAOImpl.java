package co.com.core.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.EventDAO;
import co.com.core.domain.Event;

public class EventDAOImpl implements EventDAO{
	
	private static final Logger logger = Logger.getLogger(EventDAOImpl.class);
	
    private SessionFactory sessionFactory;
    private Session session;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public List<Event> getAll() {
		List<Event> events = null;
		try {
			session = this.sessionFactory.openSession();
			Query query = session.getNamedQuery("Event.findAll");
			events = query.list();
		} catch (Exception ex) {
			logger.error("Throwed Exception [EventDAOImpl.getAll]: " +ex.getMessage());
		} finally {
			session.close();
		}
		return events;
	}

	@Override
	public void createEvent(Event event) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(event);
			tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [EventDAOImpl.createEvent]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Event event) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(event);
			tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [EventDAOImpl.delete]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Event event) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
	        session.merge(event);
	        tx.commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [EventDAOImpl.update]: " +ex.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateHQL(Event event) {
		
		try {
			session.beginTransaction();
			StringBuffer sb = new StringBuffer();
			
			sb.append("UPDATE event SET ");
			sb.append(" name = ").append("'").append(event.getName()).append("'").append(",");
//			sb.append(" start_date = ").append("'").append(event.getStartDate()).append("'");
			sb.append(" start_date = ").append("'2015-12-29'").append(",");
			sb.append(" end_date = ").append("'2016-01-01'").append(",");
			//sb.append(" end_date = ").append("'").append(event.getEndDate()).append("'");
			//sb.append(" priority_id =").append(event.getPriorityId().getPriorityId());
			sb.append(" priority_id = 3");
			sb.append(" WHERE event_id = ").append(event.getEventId());
			System.out.println(sb.toString());
			Query query = session.createSQLQuery(sb.toString());
			query.executeUpdate();
			session.getTransaction().commit();
		} catch(Exception ex) {
			logger.error("Throwed Exception [EventDAOImpl.updateHQL]: " +ex.getMessage());
		} finally {
			session.close();
		}
	}

}
