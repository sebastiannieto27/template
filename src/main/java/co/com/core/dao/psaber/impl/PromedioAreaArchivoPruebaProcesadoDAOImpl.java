package co.com.core.dao.psaber.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.PromedioAreaArchivoPruebaProcesadoDAO;
import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.domain.psaber.PromedioAreaArchivoPruebaProcesado;

public class PromedioAreaArchivoPruebaProcesadoDAOImpl implements PromedioAreaArchivoPruebaProcesadoDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(PromedioAreaArchivoPruebaProcesadoDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<PromedioAreaArchivoPruebaProcesado> getAll() {
			List<PromedioAreaArchivoPruebaProcesado> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("PromedioAreaArchivoPruebaProcesado.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PromedioAreaArchivoPruebaProcesadoDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<PromedioAreaArchivoPruebaProcesado> getAllFilter(Map<String, Object> filters) {
			List<PromedioAreaArchivoPruebaProcesado> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM PromedioAreaArchivoPruebaProcesado b ");

		        String name = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					name = (String) filters.get("codigo");
					
					if(name!=null && !name.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append(" lower(b.codigo) LIKE :codigo ");
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
				logger.error("Throwed Exception [PromedioAreaArchivoPruebaProcesadoDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public PromedioAreaArchivoPruebaProcesado create(PromedioAreaArchivoPruebaProcesado entity) {
			PromedioAreaArchivoPruebaProcesado newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (PromedioAreaArchivoPruebaProcesado) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PromedioAreaArchivoPruebaProcesadoDAOImpl.createPromedioAreaArchivoPruebaProcesado]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(PromedioAreaArchivoPruebaProcesado entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PromedioAreaArchivoPruebaProcesadoDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(PromedioAreaArchivoPruebaProcesado entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PromedioAreaArchivoPruebaProcesadoDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public List<PromedioAreaArchivoPruebaProcesado> getByArchivoPruebaProcesado(ArchivoPruebaProcesado entity) {
			List<PromedioAreaArchivoPruebaProcesado> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("PromedioAreaArchivoPruebaProcesado.findByArchivoPruebaProcesadoId");
		        query.setParameter("archivoPruebaProcesadoId", entity);
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [PromedioAreaArchivoPruebaProcesadoDAOImpl.getByArchivoPruebaProcesado]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
}
