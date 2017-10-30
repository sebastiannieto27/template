package co.com.core.dao.psaber.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.ArchivoPruebaProcesadoDAO;
import co.com.core.domain.User;
import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;

public class ArchivoPruebaProcesadoDAOImpl implements ArchivoPruebaProcesadoDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(ArchivoPruebaProcesadoDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<ArchivoPruebaProcesado> getAll() {
			List<ArchivoPruebaProcesado> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("ArchivoPruebaProcesado.findAll");

		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaProcesadoDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<ArchivoPruebaProcesado> getAllFilter(Map<String, Object> filters) {
			List<ArchivoPruebaProcesado> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM ArchivoPruebaProcesado b ");

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
				logger.error("Throwed Exception [ArchivoPruebaProcesadoDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public ArchivoPruebaProcesado create(ArchivoPruebaProcesado entity) {
			ArchivoPruebaProcesado newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (ArchivoPruebaProcesado) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaProcesadoDAOImpl.createArchivoPruebaProcesado]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(ArchivoPruebaProcesado entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaProcesadoDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(ArchivoPruebaProcesado entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaProcesadoDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public ArchivoPruebaProcesado getByDateNName(Date date, String name) {
			ArchivoPruebaProcesado entity = null;
			try {
				session = this.sessionFactory.openSession();
				StringBuilder hql = new StringBuilder();
				hql.append("SELECT u FROM ArchivoPruebaProcesado u WHERE u.fecCre = '").append(date).append("'");
				hql.append(" and u.nombre_archivo = '").append(name).append("'");
				Query query = session.createQuery(hql.toString());
				List entityList = query.list();
				
				for(Iterator iterator = entityList.iterator(); iterator.hasNext();) {
					entity = (ArchivoPruebaProcesado) iterator.next();
				}
				
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaProcesadoDAOImpl.getByDateNName]: " +ex.getMessage());
			} finally {
				session.close();
			}
			
			return entity;
		}
}
