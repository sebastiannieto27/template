package co.com.core.dao.psaber.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.MediaNacionalAreaDAO;
import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.MediaNacionalArea;

public class MediaNacionalAreaDAOImpl implements MediaNacionalAreaDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(MediaNacionalAreaDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<MediaNacionalArea> getAll() {
			List<MediaNacionalArea> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("MediaNacionalArea.findAll");

		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MediaNacionalAreaDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<MediaNacionalArea> getAllFilter(Map<String, Object> filters) {
			List<MediaNacionalArea> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM MediaNacionalArea b ");

		        String name = null;
				if(filters.size() > 0) {
					 
					name = (String) filters.get("nombre");
					
					if(name!=null && !name.isEmpty()) {
						hql.append("WHERE ");
						hql.append(" lower(b.nombreArchivo) LIKE :nombreArchivo ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				 
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty).toString();
                    query.setParameter(filterProperty, "%"+filterValue.toLowerCase()+"%");
				}   
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MediaNacionalAreaDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public MediaNacionalArea create(MediaNacionalArea entity) {
			MediaNacionalArea newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (MediaNacionalArea) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MediaNacionalAreaDAOImpl.createMediaNacionalArea]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(MediaNacionalArea entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MediaNacionalAreaDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(MediaNacionalArea entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MediaNacionalAreaDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public List<MediaNacionalArea> getMediaNacionalByArchivoPrueba(ArchivoPrueba entity) {
			List<MediaNacionalArea> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("MediaNacionalArea.findByArchivoPruebaId");
		        query.setParameter("archivoPruebaId", entity);
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MediaNacionalAreaDAOImpl.getMediaNacionalByArchivoPrueba]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
}
