package co.com.core.dao.psaber.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.ResultadoExamenUsuarioDAO;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.domain.psaber.ResultadoExamenUsuario;

public class ResultadoExamenUsuarioDAOImpl implements ResultadoExamenUsuarioDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(ResultadoExamenUsuarioDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<ResultadoExamenUsuario> getAll() {
			List<ResultadoExamenUsuario> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("ResultadoExamenUsuario.findAll");

		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<ResultadoExamenUsuario> getAllFilter(Map<String, Object> filters) {
			List<ResultadoExamenUsuario> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM ResultadoExamenUsuario b ");

				Query query = session.createQuery(hql.toString());
				 
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty).toString();
                    query.setParameter(filterProperty, "%"+filterValue.toLowerCase()+"%");
				}   
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public ResultadoExamenUsuario create(ResultadoExamenUsuario entity) {
			ResultadoExamenUsuario newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (ResultadoExamenUsuario) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioDAOImpl.createResultadoExamenUsuario]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(ResultadoExamenUsuario entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(ResultadoExamenUsuario entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public List<ResultadoExamenUsuario> getByRespuestaExamen(RespuestaExamen id) {
			List<ResultadoExamenUsuario> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("ResultadoExamenUsuario.findByRespuestaExamenId");
		        query.setParameter("respuestaExamenId", id);
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioDAOImpl.getByRespuestaExamen]: " +ex.getMessage());
			} finally {
				session.close();
			}
			
			return entityList;
		}

		@Override
		public void updatePromedioArea(double promedio, List<Integer> idList) {
			try {
				session = this.sessionFactory.openSession();
				Query query = session.createQuery("UPDATE ResultadoExamenUsuario SET promedioArea = :promedioArea WHERE resultadoExamenUsuarioId IN(:ids)");
				query.setParameter("promedioArea", promedio);
				query.setParameterList("ids", idList);
				query.executeUpdate();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioDAOImpl.updatePromedioArea]: " +ex.getMessage());
			}
		}
		
		@Override
		public List<ResultadoExamenUsuario> getByAreaRespuestaExamenList(List<RespuestaExamen> idList, Area area) {
			List<ResultadoExamenUsuario> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("ResultadoExamenUsuario.findByAreaRespuestaExamenIdList");
		        query.setParameter("areaId", area);
		        query.setParameterList("ids", idList);
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioDAOImpl.getByRespuestaExamenList]: " +ex.getMessage());
			} finally {
				session.close();
			}
			
			return entityList;
		}
}
