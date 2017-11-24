package co.com.core.dao.psaber.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.RespuestaExamenDAO;
import co.com.core.domain.User;
import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.ArchivoPruebaProcesado;
import co.com.core.domain.psaber.PreguntaTema;
import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;

public class RespuestaExamenDAOImpl implements RespuestaExamenDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(RespuestaExamenDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<RespuestaExamen> getAll() {
			List<RespuestaExamen> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("RespuestaExamen.findAll");

		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<RespuestaExamen> getAllFilter(Map<String, Object> filters) {
			List<RespuestaExamen> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM RespuestaExamen b ");

		        String name = null;
				if(filters.size() > 0) {
					 
					name = (String) filters.get("nombre");
					
					if(name!=null && !name.isEmpty()) {
						hql.append("WHERE ");
						hql.append(" lower(b.nombre) LIKE :nombre ");
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
				logger.error("Throwed Exception [RespuestaExamenDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public RespuestaExamen create(RespuestaExamen entity) {
			RespuestaExamen newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (RespuestaExamen) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenDAOImpl.createRespuestaExamen]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(RespuestaExamen entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(RespuestaExamen entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public RespuestaExamen getByRespuestaExamenId(Integer id) {
			RespuestaExamen entity = null;
			try {
				session = this.sessionFactory.openSession();
				entity = (RespuestaExamen) session.get(RespuestaExamen.class, id);
			} catch(Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenDAOImpl.getAllByRespuestaExamenId]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entity;
		}

		@Override
		public List<RespuestaExamen> getByArchivoPruebaProcesado(ArchivoPruebaProcesado id) {
			List<RespuestaExamen> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("RespuestaExamen.findByArchivoPruebaProcesado");
		        query.setParameter("archivoPruebaProcesadoId", id);
		        query.setParameter("procesado", (short)0);
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenDAOImpl.getByArchivoPruebaProcesado]: " +ex.getMessage());
			} finally {
				session.close();
			}
			
			return entityList;
		}
		
		@Override
		public List<RespuestaExamen> getByRespuestaExamenResultado(User userId, Date searchDate) {
			List<RespuestaExamen> entityList = null;
			try {
				session = this.sessionFactory.openSession();
				StringBuilder hql = new StringBuilder();
				hql.append("SELECT r FROM RespuestaExamen r LEFT JOIN r.archivoPruebaProcesadoId a");
				hql.append(" WHERE r.userId = :userId");
				hql.append(" AND a.fecCre = :fecCre");
				Query query = session.createQuery(hql.toString());
				query.setParameter("userId", userId);
				query.setParameter("fecCre", searchDate);
				entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenDAOImpl.getByArchivoPruebaProcesado]: " +ex.getMessage());
			} finally {
				session.close();
			}
			
			return entityList;
		}
		
		@Override
		public List<RespuestaExamen> getByArchivoPruebaFecha(ArchivoPrueba archivoPruebaId, Date searchDate) {
			List<RespuestaExamen> entityList = new ArrayList<>();
			try {
				session = this.sessionFactory.openSession();
				StringBuilder hql = new StringBuilder();
				hql.append("SELECT MAX(r.respuestaExamenId), MAX(r.userId), MAX(r.archivoPruebaProcesadoId) FROM RespuestaExamen r ");
				hql.append("LEFT JOIN r.archivoPruebaProcesadoId a");
				//hql.append("LEFT JOIN a.archivoPruebaId ap");
				
				hql.append(" WHERE a.archivoPruebaId = :archivoPruebaId");
				hql.append(" AND a.fecCre = :fecCre");
				hql.append(" GROUP BY a.archivoPruebaId");
				Query query = session.createQuery(hql.toString());
				query.setParameter("archivoPruebaId", archivoPruebaId);
				query.setParameter("fecCre", searchDate);
				List<Object[]> objList = query.list();
				
				if(objList!=null && objList.size() > 0) {
					RespuestaExamen entity = new RespuestaExamen();
					Object[] arrObj = objList.get(0);
					
					entity.setRespuestaExamenId((Integer) arrObj[0]);
					entity.setUserId((User)arrObj[1]);
					entity.setArchivoPruebaProcesadoId((ArchivoPruebaProcesado)arrObj[2]);
					
					entityList.add(entity);
				}
				
			} catch(Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenDAOImpl.getByArchivoPruebaFecha]: " +ex.getMessage());
			} finally {
				session.close();
			}
			
			return entityList;
		}
}
